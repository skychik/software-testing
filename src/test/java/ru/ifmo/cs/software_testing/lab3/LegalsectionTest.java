package ru.ifmo.cs.software_testing.lab3;// Generated by Selenium IDE

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class LegalsectionTest {
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
	public void legalsection() {
		for (WebDriver driver : drivers) {
			driver.get("https://soundcloud.com/discover");
			driver.manage().window().setSize(new Dimension(1345, 854));
			driver.findElement(By.xpath("//a[contains(.,\'Legal\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Terms Of Use\')]")).click();
			driver.findElement(By.xpath("(//a[contains(text(),\'Privacy Policy\')])[8]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Cookies Policy\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Community Guidelines\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Law Enforcement Guidelines\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Network Enforcement Act reports\')]")).click();
			driver.findElement(By.xpath("//li[contains(.,\'Report illegal content\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Report illegal content\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Learn about copyright\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Report Copyright Infringement\')]")).click();
			{
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),\'Report illegal content\')]"));
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();
			}
			driver.findElement(By.xpath("//a[contains(text(),\'About SoundCloud\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Company Information\')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),\'Press Information\')]")).click();
		}
	}
}
