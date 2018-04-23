package selenium.web;

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
		driver.get("https://wd1gdz.axshare.com/shoppingcart.html");

		WebElement itemNumInput = driver.findElement(By.id("u310_input"));
		itemNumInput.clear();
		Thread.sleep(2000);
		itemNumInput.sendKeys("0");

		WebElement checkout = driver.findElement(By.id("u307"));
		checkout.click();
		ExpectedConditions.textToBe(By.id("u333_input"), "Cannot check out with an empty bag!");

	}

	@Test
	void testEmptyCartAndFiveItemsCheckout() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/shoppingcart.html");

		WebElement itemNumInput = driver.findElement(By.id("u310_input"));
		itemNumInput.clear();
		itemNumInput.sendKeys("5");
		Thread.sleep(2000);

		// empty cart
		WebElement emptyCart = driver.findElement(By.id("u305"));
		emptyCart.click();
		ExpectedConditions.textToBePresentInElement(itemNumInput, "0");

		Thread.sleep(2000);
		// checkout with 5 items
		itemNumInput.clear();
		for (int i = 0; i <= 4; i++) {
			driver.findElement(By.id("u312")).click();
		}
		Thread.sleep(2000);
		WebElement checkout = driver.findElement(By.id("u307"));
		checkout.click();
		ExpectedConditions.urlContains("review___checkout.html");
		
		//expense amount matches.
		ExpectedConditions.textToBe(By.id("u116_input"), "12.80");
		
		Thread.sleep(2000);
		//change tip rate
		WebElement tipRate20 = driver.findElement(By.id("u104"));
		tipRate20.click();
		ExpectedConditions.textToBe(By.id("u116_input"), "14.80");
	}
	
	@Test
	void testOrderConfirm() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/review___checkout.html");
		Thread.sleep(3000);
		WebElement confirmOrderButton = driver.findElement(By.id("u131"));
		confirmOrderButton.click();
		ExpectedConditions.urlContains("ordercomplete.html");
		
		Thread.sleep(2000);
        
		WebElement trackOrder = driver.findElement(By.id("u88"));
		trackOrder.click();
		ExpectedConditions.urlContains("ordertrack.html");
		
	}
	
}
