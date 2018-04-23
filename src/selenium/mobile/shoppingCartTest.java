package selenium.mobile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class shoppingCartTest {
	WebDriver driver;

	public shoppingCartTest() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./chromedriver");
	}

	@Test
	void testZeroItemCheckout() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/shoppingcartmobile.html");

		WebElement itemNumInput = driver.findElement(By.id("u917_input"));
		itemNumInput.clear();
		Thread.sleep(2000);
		itemNumInput.sendKeys("0");

		WebElement checkout = driver.findElement(By.id("u915"));
		checkout.click();
		ExpectedConditions.textToBe(By.id("u940_input"), "Cannot check out with an empty bag!");

	}

	@Test
	void testEmptyCartAndFiveItemsCheckout() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/shoppingcartmobile.html");

		WebElement itemNumInput = driver.findElement(By.id("u917_input"));
		itemNumInput.clear();
		itemNumInput.sendKeys("5");
		Thread.sleep(2000);

		// empty cart
		WebElement emptyCart = driver.findElement(By.id("u913"));
		emptyCart.click();
		ExpectedConditions.textToBePresentInElement(itemNumInput, "0");

		Thread.sleep(2000);
		// checkout with 5 items
		itemNumInput.clear();
		for (int i = 0; i <= 4; i++) {
			driver.findElement(By.id("u919")).click();
		}
		Thread.sleep(2000);
		WebElement checkout = driver.findElement(By.id("u915"));
		checkout.click();
		ExpectedConditions.urlContains("review___checkoutmobile.html");
		
		//expense amount matches.
		ExpectedConditions.textToBe(By.id("u448_input"), "12.80");
		
		Thread.sleep(2000);
		//change tip rate
		WebElement tipRate20 = driver.findElement(By.id("u436"));
		tipRate20.click();
		ExpectedConditions.textToBe(By.id("u448_input"), "14.80");
	}
	
	@Test
	void testOrderConfirm() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/review___checkoutmobile.html");
		Thread.sleep(3000);
		WebElement confirmOrderButton = driver.findElement(By.id("u463"));
		confirmOrderButton.click();
		ExpectedConditions.urlContains("ordercomplete.html");
		
		Thread.sleep(2000);
        //go to order track
		WebElement trackOrder = driver.findElement(By.id("u616_text"));
		trackOrder.click();
		ExpectedConditions.urlContains("ordertrack.html");
	
		Thread.sleep(2000);
		
		//order track page and click contact.
		WebElement contactButton = driver.findElement(By.id("u565"));
		contactButton.click();
		
		ExpectedConditions.visibilityOfElementLocated(By.id("u571"));
		
		Thread.sleep(2000);
		WebElement callButton  = driver.findElement(By.id("u574"));
		callButton.click();
		ExpectedConditions.invisibilityOfElementLocated(By.id("u571"));
		
	}
	
}
