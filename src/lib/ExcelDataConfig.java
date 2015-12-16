package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataConfig
{
	HSSFWorkbook wb;
	HSSFSheet sheet1;

	public ExcelDataConfig(String excelPath) throws Exception
	{
		File src=new File(excelPath);
		FileInputStream fis =new FileInputStream(src);
	    wb=new HSSFWorkbook(fis);
		sheet1=wb.getSheetAt(0);
		
	}
	
}
