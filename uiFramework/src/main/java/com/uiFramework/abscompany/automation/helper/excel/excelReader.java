package com.uiFramework.abscompany.automation.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class excelReader {
	//static Xls_Reader reader;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow rows = null;
	private XSSFCell cells = null;
	private Logger log =LoggerHelper.getLogger(excelReader.class);
	
	int rowCount=0;
	int columnCount=0;

	

	public String[][] getExcelData(String excellocation,String sheetName) {
		
			try {
				String dataSets[][]=null;
				
				fis = new FileInputStream(new File(excellocation));
		     	
		     	//Create Workbook instance holding reference to xls file.
				workbook = new XSSFWorkbook(fis);
				
				//Get sheet from the workbook
				sheet=workbook.getSheet(sheetName);
				
				//count number of Active rows
				rowCount=sheet.getLastRowNum();
				
				//get number of active columns from first row 
				columnCount=sheet.getRow(0).getLastCellNum();
				
				//Create Arrays for Rows and column
				dataSets=new String[rowCount][columnCount];
				
				//Iterate through each rows
				Iterator<Row> rowIterator= sheet.iterator();
				int i=0;
			
					while(rowIterator.hasNext()) 
					{
						i=i++;
						Row row =rowIterator.next();
						Iterator<Cell> cellIterator=row.cellIterator();
						
						int j=0;
							while(cellIterator.hasNext()) 
							{
								
								Cell cell =cellIterator.next();	
								
								//System.out.println(cell.getCellType());
								
																
							if( cell.getStringCellValue().contains("email")) 
									{
										break;
									}
								
								else
									{
									
									switch(cell.getCellType()) 
									{		
										case Cell.CELL_TYPE_NUMERIC:
											dataSets[i][j++]=cell.getStringCellValue();
											System.out.println(cell.getNumericCellValue());
											break;
										case Cell.CELL_TYPE_STRING:
											dataSets[i][j++]=cell.getStringCellValue();
											System.out.println(cell.getStringCellValue());
											break;
										case Cell.CELL_TYPE_BOOLEAN:
											dataSets[i][j++]=cell.getStringCellValue();
											System.out.println(cell.getStringCellValue());		
											break;
										case Cell.CELL_TYPE_FORMULA:
											dataSets[i][j++]=cell.getStringCellValue();
											System.out.println(cell.getStringCellValue());
											break;
									} // switch closure
									} //else closure
									} //While for cell j
							System.out.println("");
							
		}
		fis.close();
		return dataSets;
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
}
		
    public void updateResult(String excellocation,String sheetName,String testCaseName,String testStatus)
{
	try {
		FileInputStream fis = new FileInputStream(new File(excellocation));
     	
     	//Create Workbook instance holding reference to xls file.
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//Get sheet from the workbook
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int totalRowNum = sheet.getLastRowNum()+1;
		
		for(int i=1;i<totalRowNum;i++)
		{
			XSSFRow r = sheet.getRow(i);
			String ce = r.getCell(0).getStringCellValue();
			
			if(ce.contains(testCaseName))
			{
				r.createCell(1).setCellValue(testStatus);
				fis.close();
				log.info("result updated");
				
				FileOutputStream fos=new FileOutputStream(new File (excellocation));
				workbook.write(fos);
				fos.close();
				break;
			}
		
	}
}
	
	catch(Exception e)
	{
		log.info(e);
	}
}
	
   
   /* public static ArrayList<Object[]> getDatafromExcel(){
    	
    	
    	
    	try {
    		ArrayList<Object[]> mydata= new ArrayList<Object[]>();
    		//fis = new FileInputStream(location);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return mydata;
    }*/
    
	public static void main(String[] args) throws IOException {
		excelReader ExcelReader= new excelReader(); 
		String excellocation="C:/Users/abhinay.sutrakar/Desktop/uiFramework/TestData.xlsx";
		String sheetName="Data";
		excelReader read= new excelReader();
		String[][] data=read.getExcelData(excellocation,sheetName);
		System.out.println(data);
		ExcelReader.updateResult(excellocation, "TestScripts", "Login","Pass");
		ExcelReader.updateResult(excellocation, "TestScripts", "Registration","Pass");
		ExcelReader.updateResult(excellocation, "TestScripts", "Add to Cart","Pass");
		// TODO Auto-generated method stub

	}

}
