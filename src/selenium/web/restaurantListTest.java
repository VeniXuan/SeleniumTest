package selenium.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class restaurantListTest {
	WebDriver driver;

	public restaurantListTest() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./chromedriver");
	}
	@Test
	void testShowRestaurant() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/restaurant_lists.html");
		
		WebElement searchButton = driver.findElement(By.id("u234"));
		Thread.sleep(2000);
		searchButton.click();
		ExpectedConditions.visibilityOf(driver.findElement(By.id("u235")));

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		WebElement restaur_list = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("u240_img"))));
		restaur_list.click();// go to restaurant
	    ExpectedConditions.urlToBe("https://wd1gdz.axshare.com/restaurant.html");
	}
	@Test
	void testTabSelection() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/restaurant_lists.html");
		
		WebElement searchButton = driver.findElement(By.id("u234"));
		Thread.sleep(2000);
		searchButton.click();
		ExpectedConditions.visibilityOf(driver.findElement(By.id("u235")));

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 5); 
	    
		WebElement asianTab = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("u236"))));
		asianTab.click();
		ExpectedConditions.visibilityOf(driver.findElement(By.id("u256")));
		
		Thread.sleep(2000);
		
		WebElement americanTab = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("u252"))));
		americanTab.click();
		ExpectedConditions.visibilityOf(driver.findElement(By.id("u272")));
	}
	

}
