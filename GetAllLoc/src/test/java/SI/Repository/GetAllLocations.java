package SI.Repository;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetAllLocations {

	public static SI.Repository.SingletonClass singleton1 = SI.Repository.SingletonClass.getInstanceOfSingletonBrowserClass();
		public static WebDriver driver1 = singleton1.getDriver();
		public static DbConnection dbobj = new DbConnection();
		
		@DataProvider
		public Object[] dp() throws IOException {
			String[] data = readXLSXFile();
			return data;
		}
		
			@Test
			public void Locationget() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException, URISyntaxException, ClassNotFoundException
			{
				String urls = "https://gyms.anytimefitness.co.in/";
				driver1.manage().window().maximize();
				boolean error;
				int a=0;
				String baseUrl = urls;
				driver1.get(baseUrl);
				URI uri = new URI(urls);
				String host = uri.getHost();
				System.out.println("Host = "+host);
				Thread.sleep(1000);
				String Link ="";    
				String cunturl = driver1.getCurrentUrl();
				int sum=500;
				int k=2;
				for(k=2;k<sum;k++) {
					driver1.get(cunturl+"?page="+k);
					Thread.sleep(1000);
					if(driver1.getPageSource().contains("No results found. Please search by state/city.")
							||driver1.getPageSource().contains("No stores are available!!")
							||driver1.getPageSource().contains("No gyms are available!!")
							||driver1.getPageSource().contains("Your search did not return any results.")
							||driver1.getPageSource().contains("Please try advanced search.")
							||driver1.getPageSource().contains("Your search did not return any results. Please try advanced search.")) {
						System.out.println("null");
						break;
					} else {
						//write code again - get link value
						List<WebElement> internaldata = driver1.findElements(By.cssSelector(".outlet-list > .store-info-box"));
						for(WebElement dp:internaldata) {
							Link = dp.findElement(By.cssSelector("a.btn.btn-website")).getAttribute("href");
							System.out.println(Link);
							//db connection
							//dbobj.database(host, Link);
						}
					}
				}
			}
			
			
			// this code is to read an excel file..
			public static String[] readXLSXFile() throws IOException {
				System.out.println("a");
				InputStream excelFileName = new FileInputStream(System.getProperty("user.dir")+
						"\\src\\test\\java\\SI\\excel\\locationsheet.xlsx");
		
				XSSFWorkbook wb = new XSSFWorkbook(excelFileName);
				int sheets = wb.getNumberOfSheets();
				System.out.println(sheets);
				XSSFSheet sheet = wb.getSheetAt(0);
				XSSFRow row;
				XSSFCell cell;
		
				Iterator<Row> rows = sheet.rowIterator();
		
				String[] arrUrls = new String[sheet.getLastRowNum() + 1];
				int rowNum = sheet.getLastRowNum() + 1;
				System.out.println("Total Number of Rows in the excel is : " + rowNum);
				int rowIndex = 0;
				while (rows.hasNext()) {
					row = sheet.getRow(rowIndex);
					row = (XSSFRow) rows.next();
					Iterator<Cell> cells = row.cellIterator();
					while (cells.hasNext()) {
						cell = (XSSFCell) cells.next();
		
						if (cell.getCellType() == CellType.STRING) {
							arrUrls[rowIndex] = cell.getStringCellValue();
						}
					}
					rowIndex++;
				}
				return arrUrls;
			}
			
}
