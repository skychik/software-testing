package ru.ifmo.cs.software_testing.lab3;// Generated by Selenium IDE

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class AllButtonTest {
	private List<WebDriver> drivers;
	Util util;

	@Before
	public void setUp() {
		util = new Util();
		drivers = new ArrayList<>();
		drivers.add(new ChromeDriver());
		drivers.add(new FirefoxDriver());
		for (WebDriver driver : drivers) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	@After
	public void tearDown() {
		for (WebDriver driver : drivers) {
			driver.quit();
		}
	}

	@Test
	public void allbuttontest() {
		for (WebDriver driver : drivers) {
			driver.get(util.getBaseUrl());
			driver.manage().window().setSize(new Dimension(1345, 854));
			util.authenticate(driver);
			driver.findElement(By.linkText("Library")).click();
			{
				WebElement element = driver.findElement(By.linkText("Library"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();
			}
			{
				WebElement element = driver.findElement(By.tagName("body"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element, 0, 0).perform();
			}
			driver.findElement(By.linkText("Stream")).click();
			{
				WebElement element = driver.findElement(By.linkText("Home"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Home\')]")).click();
			{
				WebElement element = driver.findElement(By.tagName("body"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element, 0, 0).perform();
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Stream\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Library\')]")).click();
			{
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),\'Library\')]"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();
			}
			{
				WebElement element = driver.findElement(By.tagName("body"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element, 0, 0).perform();
			}
			driver.findElement(By.xpath("//a[contains(text(),\'Likes\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Playlists\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Albums\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Stations\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Following\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'History\')]")).click();
		}
	}
}