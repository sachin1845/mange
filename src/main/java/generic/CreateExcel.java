package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcel {

	public void writeExcelData(int rownum, int cellnum,String value) throws IOException

	{
			String path="./src/test/resources/test3.xlsx";
			FileOutputStream fo;
			XSSFWorkbook wb;
			FileInputStream fi;
			File f= new File(path);
			if(!f.exists())
			{
				wb = new XSSFWorkbook();
				fo = new FileOutputStream(path);
				wb.write(fo);
			}

			fi = new FileInputStream(path);
			wb=new XSSFWorkbook(fi);

			if(wb.getSheetIndex("Sheet1")==-1)
				wb.createSheet("Sheet1");
			XSSFSheet sheet = wb.getSheet("Sheet1");

			if(sheet.getRow(rownum)==null)
				sheet.createRow(rownum);
			XSSFRow row = sheet.getRow(rownum);
			
		XSSFCell cell = row.createCell(cellnum);
		cell.setCellValue(value);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

		}
	}

