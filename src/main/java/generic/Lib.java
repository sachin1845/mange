package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lib {
	public String getPropertyData(String property) throws IOException {
		FileInputStream fis = new FileInputStream("./src/main/resources/testdata.property");
		Properties pr = new Properties();
		pr.load(fis);
		String data=pr.getProperty(property);
		return data;
	}
	;

	public void setPropertyData(String property, String value) throws IOException {
	    // Load the existing properties from the file
	    FileInputStream fis = new FileInputStream("./src/main/resources/testdata1.property");
	    Properties pr = new Properties();
	    pr.load(fis);
	    fis.close();

	    // Set the new value for the property
	    pr.setProperty(property, value);

	    // Save the modified properties back to the file
	    FileOutputStream fos = new FileOutputStream("./src/main/resources/testdata1.property");
	    pr.store(fos,null);
	    fos.close();
	}


	public String getExcelData(String sheet ,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fs = new FileInputStream("./src/main/resources/test.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;	
	}
	public Object[][] ToReadexcelData(String  sheentname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fs = new FileInputStream("./src/main/resources/testdata.property");
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet(sheentname);
		int rowcount = sh.getLastRowNum()+1;
		int cellcount=sh.getRow(0).getLastCellNum();
		Object[][] Obj = new Object[rowcount][cellcount];
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				Obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return Obj;

	}
	FileInputStream fi;
	FileOutputStream fos;
	 XSSFWorkbook wb;
	 XSSFSheet sheet;
	 XSSFRow row;
	 XSSFCell cell ;
	public void writeExcelData(int rownum, int cellnum,String value) throws IOException
	{
		File xlfile= new File("./src/main/resources/test2.xlsx");
		if(!xlfile.exists())
		{
			 wb = new XSSFWorkbook();
			 fos= new FileOutputStream("./src/main/resources/test2.xlsx");
			 wb.write(fos);
		}
		 fi=new FileInputStream("./src/main/resources/test2.xlsx");
		 wb=new XSSFWorkbook();
		 if(wb.getSheetIndex("Sheet2")==-1)
			sheet= wb.createSheet("Sheet2");
		 
		 
		if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum);
		 row = sheet.getRow(rownum);
		 
		 cell = row.createCell(cellnum);
		 cell.setCellValue(value);
		 fos=new FileOutputStream("./src/main/resources/test2.xlsx");
		 wb.write(fos);
		 wb.close();
		 fi.close();
		 fos.close();
		
	}
	
	public int getRandomNum()
	{
		int num= (int)(Math.random()*100);
		return num;
	}
	public String getTime()
	{
		String stamp=LocalDateTime.now().toString().replaceAll(":", "-");
		return stamp;
	}
	
	    FileInputStream fi1;
	    FileOutputStream fos1;
	    XSSFWorkbook wb1;
	    XSSFSheet sheet1;
	    XSSFRow row1;
	    XSSFCell cell1;

	    public void writeExcelData1(int rownum, int cellnum, String value) throws IOException {
	        File xlfile = new File("./src/main/resources/test2.xlsx");
	        if (!xlfile.exists()) {
	            // If the file doesn't exist, create a new workbook and sheet
	            wb = new XSSFWorkbook();
	            sheet = wb.createSheet("Sheet2");
	        } else {
	            // If the file exists, open it for reading
	            fi = new FileInputStream("./src/main/resources/test2.xlsx");
	            wb = new XSSFWorkbook(fi);

	            // Check if "Sheet2" exists; if not, create it
	            if (wb.getSheetIndex("Sheet2") == -1)
	                sheet = wb.createSheet("Sheet2");
	            else
	                sheet = wb.getSheet("Sheet2");
	        }

	        // Create a new row if it doesn't exist
	        row = sheet.getRow(rownum);
	        if (row == null)
	            row = sheet.createRow(rownum);

	        // Create a new cell and set its value
	        cell = row.createCell(cellnum);
	        cell.setCellValue(value);

	        // Close input stream
	        if (fi != null) {
	            fi.close();
	        }

	        // Write changes to the Excel file
	        fos = new FileOutputStream("./src/main/resources/test2.xlsx");
	        wb.write(fos);
	        fos.close();
	    }

	    

}
