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

public class MusicTurnOnOffNextPreviousTrackTest {
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
	public void musicturnonofnextprevioustrack() {
		for (WebDriver driver : drivers) {
			driver.get(util.getBaseUrl());
			driver.manage().window().setSize(new Dimension(1345, 854));
			driver.findElement(By.id("app")).click();
			driver.findElement(By.xpath("//li/div/div/div/a")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Skip to next\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Skip to next\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Skip to previous\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Shuffle\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Skip to next\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Repeat track\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Skip to next\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Repeat track\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Repeat track\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Shuffle\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Toggle mute\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Toggle mute\')]")).click();
			driver.findElement(By.xpath("//button[contains(.,\'Pause current\')]")).click();
		}
	}
}