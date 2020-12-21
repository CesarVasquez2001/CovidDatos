package AdaProyecto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class LeerPeru {

	public static void main(String[] args) throws IOException {
		String excelFilePath = "C:\\Users\\qjosi\\eclipse-workspace\\ADAProyecto\\src\\EXCEL.xlsx";
		//DatosPeru[]Data=captarDatosPeru(excelFilePath);
		//imprimir(Data);
		captarCiudades(excelFilePath);
		System.out.println("Ordenamiento Qicksort");
	}
	public static DatosPeru[] captarDatosPeru(String archivo) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(archivo));
		DatosPeru[] data = new DatosPeru[26];
		int i=0;
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			String ciudad=null;
			int positivos=0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case STRING:
					ciudad=cell.getStringCellValue();
					System.out.println(ciudad);
					break;
				case NUMERIC:
					positivos=(int)cell.getNumericCellValue();
					System.out.println(positivos);
					break;
				}
			}
			data[i]=new DatosPeru(ciudad,positivos);
			i++;
		}
		workbook.close();
		inputStream.close();
		System.out.println("Objetos");
		return data;		
	}
	public static void captarCiudades(String archivo) throws IOException {
		int i=0,j=0;
		String[][] ciudades=new String[26][8];
		FileInputStream inputStream = new FileInputStream(new File(archivo));         
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(1);
		Iterator<Row> iterator = firstSheet.iterator();	
		String ciu = null;
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();	             
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();	                 
				switch (cell.getCellType()) {
				case STRING:
					ciu=cell.getStringCellValue();
					System.out.print(ciu);
					break;
				}	
				ciudades[i][j]=ciu;
				System.out.print(" - ");
				i++;
			}
			j++;
			System.out.println();
		}
		workbook.close();
		inputStream.close();
		imprimir(ciudades);
	}	
	public static void imprimir(DatosPeru[]dataa) {
		for (int i = 0; i < dataa.length; i++) {
			System.out.println(dataa[i].toString());
		}
	}
	public static void imprimir(String[][]dataa) {
		for (int i = 0; i < dataa.length; i++) {
			for (int j = 0; j < dataa.length; j++) {
				System.out.println(dataa[i][j]);
			}
		}
	}
	public static void quickSort(DatosPeru[] vector) {
		int n = vector.length;
		quicksort(vector, 0, n - 1);
	}
	private static void quicksort(DatosPeru a[], int primero, int ultimo) {
		int i, j, central;
		DatosPeru pivote;
		central = (primero + ultimo) / 2;
		pivote = a[central];
		i = primero;
		j = ultimo;
		do {
			while (a[i].compareTo(pivote) < 0) {
				i++;
			}
			while (a[j].compareTo(pivote) > 0) {
				j--;
			}
			if (i <= j) {
				DatosPeru aux = a[i];
				a[i] = a[j];
				a[j] = aux;
				i++;
				j--;
			}
		} while (i <= j);
		if (primero < j) {
			quicksort(a, primero, j); 
		}
		if (i < ultimo) {
			quicksort(a, i, ultimo);
		}

	}

}
