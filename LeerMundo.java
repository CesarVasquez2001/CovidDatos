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

public class LeerMundo {
	public static void main(String[] args) throws IOException {
		String excelFilePath = "C:\\Users\\qjosi\\eclipse-workspace\\ADAProyecto\\src\\EXCEL.xlsx";
		//DatosPeru[]Data=capatarDatosPeru(excelFilePath);
		//imprimir(Data);
		captarDatoMundo(excelFilePath);
		System.out.println("Ordenamiento Qicksort");
	}

	public static DatosMundo[] captarDatoMundo(String archivo) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(archivo));
		DatosMundo[] data = new DatosMundo[26];
		int i=0;
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(2);
		Iterator<Row> iterator = firstSheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			String region=null;
			String pais=null;
			int positivos=0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case STRING:
					region=cell.getStringCellValue();
					System.out.println(region);
					break;
				case NUMERIC:
					positivos=(int)cell.getNumericCellValue();
					System.out.println(positivos);
					break;
				}
			}
			data[i]=new DatosMundo(region,pais,positivos);
			i++;
		}
		workbook.close();
		inputStream.close();
		System.out.println("Objetos");
		return data;		
	}
}
