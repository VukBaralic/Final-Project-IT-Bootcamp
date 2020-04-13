package itbootcamp.project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class InsertDataInExcelFile {

	public static void main(String[] args) {

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Sheet1");
		Row row = null;
		Cell cell;

		String[] data = new String[] { "Lupus0", "Vuk", "Baralic", "aaaaa", "5", "m", "1991", " ulica", "Chicago", "13",
				"60000", "222-555" };

		for (int i = 0; i < 30; i++) {

			row = sheet.createRow(i);
			for (int j = 0; j < 12; j++) {
				cell = row.createCell(j);

				if (j == 0) {
					cell.setCellValue(data[j] + (i + 1) + "@gmail.com");

				} else if (j == 7) {
					cell.setCellValue((i + 1) + data[j]);

				} else {
					cell.setCellValue(data[j]);
				}
			}
		}

		FileOutputStream os;
		try {
			os = new FileOutputStream("src/test/resources/Users.xlsx");
			wb.write(os);
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
