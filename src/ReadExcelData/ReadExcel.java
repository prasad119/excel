package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcel 
{

	public static void main(String[] args) throws Exception 
	{
		List <Map<String,String>> details = ReadExcel.getData("C:\\Users\\Chaitanya\\Desktop\\TestData.xls","Sheet1");
		
		for (Map<String, String> rowData : details) 
		{
			String userId = rowData.get("UserID");
			String password = rowData.get("Password");
		}
		

		System.out.println(details);

	}

	public static List <Map<String,String>> getData(String filePath, String sheetName) throws IOException {

		File src=new File(filePath);
		FileInputStream fis =new FileInputStream(src);

		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sheet1=wb.getSheet(sheetName);
		int rowCount =sheet1.getLastRowNum();
		System.out.println(rowCount);

		List<Map<String, String>> details = new ArrayList<Map<String, String>>();
		
		Map<String, String> [] details1;
		
		Row keyRow = sheet1.getRow(0);

		for(int i=1;i<=rowCount;i++)
		{
			Row row = sheet1.getRow(i);
			Map<String,String> rowDetails = new HashMap<>();
			//			if(row.getCell(0).toString().equals(testcaseName)) {
			int colCount = row.getLastCellNum();
			for (int j = 1; j<colCount; j++) {
				
				rowDetails.put(keyRow.getCell(j).toString(),row.getCell(j).toString());
			}
			details.add(rowDetails);
		}

		//			HSSFRichTextString data=sheet1.getRow(i).getCell(0).getRichStringCellValue();
		//			System.out.println("Data from row  "+ i +"  is :"+data);

		//		}

		return details;

	}


}
