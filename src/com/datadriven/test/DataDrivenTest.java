package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

import SeleniumPracticePackage.DataClass;

public class DataDrivenTest {

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
		String SearchingText4 = reader.getCellData("SearchText", "Searchbelowtext", 5);
		//System.out.println(SearchingText4);
		String SearchingText5 = reader.getCellData("SearchText", "Searchbelowtext", 6);
		//System.out.println(SearchingText5);
		
		//launch chrome and open url for google search-webdriver code
		System.setProperty("webdriver.chrome.driver", "C:/jars/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch chrome
		
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");//enter url
		
		
		driver.findElement(By.name("q")).sendKeys(reader.getCellData("SearchText", "Searchbelowtext", 2));
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(reader.getCellData("SearchText", "Searchbelowtext", 3));
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(reader.getCellData("SearchText", "Searchbelowtext", 4));
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(reader.getCellData("SearchText", "Searchbelowtext", 5));
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(reader.getCellData("SearchText", "Searchbelowtext", 6));
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("q")).clear();
		
		//close browser	
		//driver.quit();
		
	}

}
