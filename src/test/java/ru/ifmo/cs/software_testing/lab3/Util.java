package ru.ifmo.cs.software_testing.lab3;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Util {
	private String baseUrl;

	String getBaseUrl() {
		return baseUrl;
	}

	String getCorrectLogin() {
		return "kir-esakov@mail.ru";
	}

	String getCorrectPassword() {
		return "^Mpx35AYv8ny";
	}

	Util() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
		baseUrl = "https://www.soundcloud.com/";
	}

	void prepare(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(getBaseUrl());
	}

	void tryClick(WebDriver driver, By selector) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));

		element.sendKeys(Keys.ENTER);
	}

	void waitPresent(WebDriver driver, By selector) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	}

	String getRandomString(int length) {
		byte[] array = new byte[length];
		new Random().nextBytes(array);
		return new String(array, StandardCharsets.UTF_8);
	}

	void authenticate(WebDriver driver) {
		driver.findElement(By.xpath("//div[@id=\'content\']/div/div/div/div/div[2]/button")).click();
		{
			WebElement element = driver.findElement(By.xpath("//div[@id=\'content\']/div/div/div/div/div[2]/button"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		{
			WebElement element = driver.findElement(By.xpath("//button[contains(.,\'Continue with Google\')]"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.xpath("//div/input")).sendKeys(getCorrectLogin());
		driver.findElement(By.xpath("//form/div/div/div/button")).click();
		driver.findElement(By.xpath("//div[2]/div/div[2]/div/input")).sendKeys(getCorrectPassword());
		driver.findElement(By.xpath("//form/div/div[2]/div/button")).click();
	}
}