package com.example;

import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class NewTest {
	private static final WebDriver driver = null;
	WebDriver wd=null;
	@BeforeTest
	public void intiate() {
		System.out.println("config intiated");
		//register the webdriver =>browser vendor 
				WebDriverManager.chromedriver().setup();
				//creating an object to the object
				 wd=new ChromeDriver();
				//maximize the browser
				wd.manage().window().maximize();
	}
	@Test
    public void flipkartPageLoad() {
  	  long start = System.currentTimeMillis();
  	  wd.get("https://www.flipkart.com/");
  	  long finish = System.currentTimeMillis();
  	  long totalTime = finish - start;
  	  System.out.println("Total Time for page load - "+totalTime);
    }
  
	@Test
  public void searchiPhone() {
	  wd.get("https://www.flipkart.com/");
	 wd.findElement(By.className("_2doB4z")).click();
	  wd.findElement(By.linkText("Mobiles & Tablets")).click();
	  wd.findElement(By.className("_3704LK")).sendKeys("iPhone 13");
	  wd.findElement(By.className("L0Z3Pu")).click();
     
   //load image
	  WebElement image = wd.findElement(By.className("_3exPp9"));
	  Boolean p =(Boolean) ((JavascriptExecutor)wd) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0",image);
	  if(p) {
	  System.out.println("Image present");
	  }else {
		  System.out.println("Image not present");
	  }
//	  
//	  //Scrolling page and frequency
  JavascriptExecutor js = (JavascriptExecutor)wd;
	  js.executeScript("window.scrollTo(0,1000)");
  }
//
//	// position and gets displayed in time
//	@Test
//	public void imageLoad() throws InterruptedException {
//		wd.get("https://www.flipkart.com/");
//		  wd.findElement(By.className("_2doB4z")).click();
//		WebDriverWait wait = new WebDriverWait(wd, 10);
//		JavascriptExecutor js = (JavascriptExecutor) wd;
//		int elementCount = wd.findElements(elementlocator).size();
//		while (true) {
//			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//			wait.ignoreAll(NoSuchElementException.class)
//					.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
//			Thread.sleep(2000);
//			if (wd.findElements(elementLocator).size() == elementCount)
//				break;
//			elementCount = wd.findElements(elementLocator).size();
//		}
//	}
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	// Quit the driver
	driver.quit();
	  
  }


}
  