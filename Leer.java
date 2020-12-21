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
public class Leer {

	public static void main(String[] args) throws IOException {
		String excelFilePath = "C:\\Users\\qjosi\\eclipse-workspace\\ADAProyecto\\src\\EXCEL.xlsx";
		DatosPeru[]Data=capatarDatosPeru(excelFilePath);
		imprimir(Data);
	}
	public static DatosPeru[] capatarDatosPeru(String archivo) throws IOException {
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
					break;
				case NUMERIC:
					positivos=(int)cell.getNumericCellValue();
					
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
	public static void imprimir(DatosPeru[]dataa) {
		for (int i = 0; i < dataa.length; i++) {
			System.out.println(dataa[i].toString());
		}
	}

}
