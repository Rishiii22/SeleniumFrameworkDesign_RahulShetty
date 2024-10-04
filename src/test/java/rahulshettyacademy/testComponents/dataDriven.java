package rahulshettyacademy.testComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class dataDriven {
	List<String> PurchasecellvalueList =new ArrayList<String>();
	int valcol=0;
	XSSFSheet sheet = null;
	Row row;
	
@Test
public void excelParsing() throws IOException
{
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+
			"\\src\\test\\java\\rahulshettyacademy\\resources\\DataTest.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	
	for(int i=0;i<sheets;i++)
	{
		if (workbook.getSheetName(i).contains("1")) {
			sheet=workbook.getSheetAt(i);
		}
		
	}
	Iterator<Row> rows=sheet.iterator();
	row=rows.next();
	Iterator<Cell> celltraversal=row.cellIterator();
	while(celltraversal.hasNext())
	{
		
		System.out.println(celltraversal.next());
	}
	while(rows.hasNext())
	{
		 row=rows.next();
		if (row.getCell(valcol).getStringCellValue().equalsIgnoreCase("purchase")) {
			Iterator<Cell> cell=row.cellIterator();
			cell.next();
			while(cell.hasNext())
			{
				PurchasecellvalueList.add(cell.next().getStringCellValue());
//				System.out.println(cell.next());
			}
			
		}
	}
	PurchasecellvalueList.stream().forEach(n->System.out.println(n));
}
public List<String> getData(String TestCaseName) throws IOException
{
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+
			"\\src\\test\\java\\rahulshettyacademy\\resources\\DataTest.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	for(int i=0;i<sheets;i++)
	{
		if (workbook.getSheetName(i).contains("1")) {
			sheet=workbook.getSheetAt(i);
		}
		
	}
	Iterator<Row> rows=sheet.iterator();
	while(rows.hasNext())
	{
		 row=rows.next();
		 
		if (row.getCell(valcol).getStringCellValue().equalsIgnoreCase(TestCaseName)) {
			Iterator<Cell> cell=row.cellIterator();
			Cell c=cell.next();
			cell.next();
			while(cell.hasNext())
			{
				
				if (c.getCellType()==CellType.STRING) {
					PurchasecellvalueList.add(c.getStringCellValue());
				}
				else {
					PurchasecellvalueList.add(String.valueOf(c.getNumericCellValue()));
				}
				
			}
			
		}
	}
	return  PurchasecellvalueList;
}
}
