package ParameterizedTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class Parameterization {

	public static void main(String[] args) {
		//making connection to xls-reader class-get data from excel
				Xls_Reader reader = new Xls_Reader("C:/Users/aishwarya.pathak/workspace/TestNGworkspace/SeleniumPractice/src/com/testdata/TestData.xlsx");		
						//calling methods
				String SearchingText1 = reader.getCellData("SearchText", "Searchbelowtext", 2);
				//System.out.println(SearchingText1);
				String SearchingText2 = reader.getCellData("SearchText", "Searchbelowtext", 3);
				//System.out.println(SearchingText2);
				String SearchingText3 = reader.getCellData("SearchText", "Searchbelowtext", 4);
				//System.out.println(SearchingText3);
				
				//launch chrome and open url for google search-webdriver code
				System.setProperty("webdriver.chrome.driver", "C:/jars/Drivers/chromedriver.exe");
				WebDriver driver = new ChromeDriver(); //launch chrome
				
				//apply implicit wait
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				driver.get("https://www.google.com/");//enter url
				
				
				//Data driven framework (Parameterization) - driving test data from excel files or other files
				//enter data
				int rows =reader.getRowCount("SearchText");
				
				
				for(int i=2; i<=rows; i++)
				
				{
				driver.findElement(By.name("q")).sendKeys(reader.getCellData("SearchText", "Searchbelowtext", i));
				driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
				driver.findElement(By.name("q")).clear();
				}
				
				//close browser	
				//driver.quit();

	}

}
