package selenium.mobile;

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
	void testShowRestaurantList() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/homepagemobileuser.html");
		
		WebElement searchButton = driver.findElement(By.id("u623_img"));
		Thread.sleep(2000);
		searchButton.click();
		ExpectedConditions.visibilityOf(driver.findElement(By.id("u636")));

		Thread.sleep(2000);
		
		WebElement searchBar =  driver.findElement(By.id("u637_input"));
		searchBar.clear();
		searchBar.sendKeys("boston");
		
		
		WebElement goToEatButton = driver.findElement(By.id("u638"));
		goToEatButton.click();// go to restaurant
	    ExpectedConditions.urlToBe("https://wd1gdz.axshare.com/restaurantlistsmobile.html");
	}
	@Test
	void testTabSelection() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/restaurantlistsmobile.html");
		
		WebElement searchButton = driver.findElement(By.id("u839"));
		Thread.sleep(2000);
		searchButton.click();
		ExpectedConditions.visibilityOf(driver.findElement(By.id("u790")));

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 5); 
	    //wait until tab appear.
		WebElement asianTab = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("u791"))));
		asianTab.click();
		ExpectedConditions.visibilityOf(driver.findElement(By.id("u811")));
		
		Thread.sleep(2000);
		
		WebElement americanTab = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("u807"))));
		americanTab.click();
		ExpectedConditions.visibilityOf(driver.findElement(By.id("u827")));
	}
	@Test
	void testShowRestaurant() throws InterruptedException {
	
		driver.get("https://wd1gdz.axshare.com/restaurantmobile.html");
		Thread.sleep(2000);
		WebElement addToCart = driver.findElement(By.id("u886"));
		addToCart.click();
		ExpectedConditions.urlToBe("https://wd1gdz.axshare.com/shoppingcartmobile.html");
		
		
	}

}
