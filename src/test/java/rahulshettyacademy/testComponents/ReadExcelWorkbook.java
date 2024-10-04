package rahulshettyacademy.testComponents;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelWorkbook {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream((System.getProperty("user.dir")+
    			"\\src\\test\\java\\rahulshettyacademy\\resources\\DataTest.xlsx"));
             XSSFWorkbook workbook = new XSSFWorkbook(fileIn)) {

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through rows
            for (Row row : sheet) {
                // Iterate through cells
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unknown cell type\t");
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
