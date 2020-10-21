package Excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testExcle {

	
	public static void testRead() throws Exception{
		/*
		 * XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx
		 * XSSFWorkbook x = new XSSFWorkbook(new File("C:\\Users\\11360\\Desktop\\123.xlsx")); 
		 */
		
		//HSSFWorkbook操作Excel2003以前（包括2003）的版本，扩展名是.xls
		HSSFWorkbook w = new HSSFWorkbook(new NPOIFSFileSystem(new File("C:\\Users\\11360\\Desktop\\京东单据.xls")));
		//拿到第一个sheet页
		HSSFSheet sheet = w.getSheetAt(0);
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			for(int j= 0;j<12;j++) {
				//拿到对应行的对应列
				HSSFCell cell = sheet.getRow(i).getCell(j);
				try {
					if("STRING".equals(cell.getCellTypeEnum().name())) {
						System.out.print(cell.getStringCellValue()+"	");
					}else if("NUMERIC".equals(cell.getCellTypeEnum().name())) {
						System.out.print(cell.getNumericCellValue()+"	");
					}else {
						System.out.print("非字符串且非数字类型");
					}
				} catch (NullPointerException n) {
					System.out.print("null"+"	");
				}
			}
			System.out.println();
		}
		
		
	}
	
	/**
	 * 将读取到的内容写入到excel文件中
	 * @throws Exception
	 */
	
	public static void testWrite() throws Exception{
		HSSFWorkbook w = new HSSFWorkbook(new NPOIFSFileSystem(new File("C:\\Users\\11360\\Desktop\\京东单据.xls")));
		HSSFSheet sheetAt = w.getSheetAt(0);
		XSSFWorkbook x = new XSSFWorkbook();
	
		XSSFSheet createSheet = x.createSheet("第一个sheet页");
		createSheet.setVerticallyCenter(true);
		
		for(int i=0;i<sheetAt.getPhysicalNumberOfRows();i++) {
			HSSFRow row = sheetAt.getRow(i);
			XSSFRow createRow = createSheet.createRow(i);
			for(int j=0;j<12;j++) {
				HSSFCell cell = row.getCell(j);
				try {
					if("STRING".equals(cell.getCellTypeEnum().name())) {
		
						createRow.createCell(j).setCellValue(cell.getStringCellValue());
						
					}else if("NUMERIC".equals(cell.getCellTypeEnum().name())) {
						
						createRow.createCell(j).setCellValue(cell.getNumericCellValue());
					}else {
						
					}
				} catch (NullPointerException n) {
					createRow.createCell(j).setCellValue("");
				}
			}
		}
		w.close();
		x.write(new FileOutputStream(new File("C:\\Users\\11360\\Desktop\\132131.xlsx")));
		x.close();
		
	}
	
	public static void main(String[] args) throws Exception {
		//testWrite();
		testRead();
		
	}
}
