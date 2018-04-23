package selenium.web;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

class homePageSearchTest {
	WebDriver driver;

	public homePageSearchTest() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./chromedriver");
	}

	@Test
	void testHoverSoundPic() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/homepage_user.html");

		// sound pic hover
		WebElement soundButton = driver.findElement(By.id("u176"));
		System.out.println("style before hover:"+driver.findElement(By.id("u180")).getCssValue("visibility"));
		assertFalse(driver.findElement(By.id("u180")).isDisplayed());
		Thread.sleep(1000); 
		
        Actions action = new Actions(driver);
        action.moveToElement(soundButton).build().perform();
        System.out.println("sytle after hover:"+ driver.findElement(By.id("u180")).getCssValue("visibility"));
        assertTrue(driver.findElement(By.id("u180")).isDisplayed());
        Thread.sleep(2000);
		
		WebElement picButton = driver.findElement(By.id("u177"));
		action.moveToElement(picButton).build().perform();
		Thread.sleep(2000);
		//new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u42_input")));
		//System.out.println("Page Url Now: " + driver.getCurrentUrl());
		

	}
	@Test
	void testSearchFoodInstead() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/homepage_user.html");

		// hover on raio buttion
		WebElement soundButton = driver.findElement(By.id("u176"));
		System.out.println("style before hover:"+driver.findElement(By.id("u180")).getCssValue("visibility"));
		assertFalse(driver.findElement(By.id("u180")).isDisplayed());
		Thread.sleep(1000); 
		
        Actions action = new Actions(driver);
        action.moveToElement(soundButton).build().perform();
        System.out.println("sytle after hover:"+ driver.findElement(By.id("u180")).getCssValue("visibility"));
        ExpectedConditions.visibilityOf(driver.findElement(By.id("u180")));
        Thread.sleep(2000);
		
	}
	@Test
	void testSearchLocation() throws InterruptedException{
		driver.get("https://wd1gdz.axshare.com/homepage_user.html");
		// hover on raio buttion
		WebElement searchBar = driver.findElement(By.id("u179_input"));
		searchBar.sendKeys("boston");
		Thread.sleep(2000);
		
		WebElement goToEatButton = driver.findElement(By.id("u178"));
		goToEatButton.click();
		ExpectedConditions.urlToBe("https://wd1gdz.axshare.com/restaurant_lists.html");
		
	}
	@Test
	void testSearchFood() throws InterruptedException{
		driver.get("https://wd1gdz.axshare.com/homepage_user.html");
		// hover on raio buttion
		WebElement searchBar = driver.findElement(By.id("u179_input"));
		searchBar.sendKeys("fries");
		Thread.sleep(2000);
		
		WebElement goToEatButton = driver.findElement(By.id("u178"));
		goToEatButton.click();
		ExpectedConditions.urlToBe("https://wd1gdz.axshare.com/homepagesearcherror.html");
		
	}
	


}
