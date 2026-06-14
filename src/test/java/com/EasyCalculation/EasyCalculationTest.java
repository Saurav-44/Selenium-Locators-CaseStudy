package com.EasyCalculation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EasyCalculationTest {

	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.easycalculation.com/");
	}
	
	@Test
	public void ageCalculatorTest() throws Exception {
		driver.findElement(By.linkText("Age Calculator")).click();
		
		//count links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links: " + links.size());
		
		
		System.out.println("First 10 Links:");
		for(int i = 0; i < 10 && i < links.size(); i++) {
			System.out.println((i+1) + ". " + links.get(i).getAttribute("href"));
		}
		
		//count images
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total Images: " + images.size());
		
		
		System.out.println("First 5 Images:");
		for(int i = 0; i < 5 && i < links.size(); i++) {
			System.out.println((i+1) + ". " + images.get(i).getAttribute("src"));
		}
		
		//enter DOB
		driver.findElement(By.id("i21")).sendKeys("1");
		driver.findElement(By.id("i22")).sendKeys("7");
		driver.findElement(By.id("i23")).sendKeys("2004");
		
		//click Go
		driver.findElement(By.xpath("//input[@name='but']")).click();
		
		Thread.sleep(3000);
		
		System.out.println();
		String r1 = driver.findElement(By.id("r1")).getAttribute("value");
		String r2 = driver.findElement(By.id("r4")).getAttribute("value");
		String r3 = driver.findElement(By.id("r3")).getAttribute("value");
		String r4 = driver.findElement(By.id("r2")).getAttribute("value");
		
		driver.findElement(By.xpath("//input[@value='Reset']")).click();
		Thread.sleep(3000);
		
		System.out.println("Your Age is: " + r1);
		System.out.println("Your Age in Days: " + r2);
		System.out.println("Your Age in Hours: " + r3);
		System.out.println("Your Age in Minutes: " + r4);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
