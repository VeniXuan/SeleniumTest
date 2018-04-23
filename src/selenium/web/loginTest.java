package selenium.web;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
class loginTest {

	WebDriver driver;

	public loginTest() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./chromedriver");
	}

	@Test
	void testSignInButtonOnHomePage() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/homepage.html");

		// home page, check sign-in button
		WebElement loginButton = driver.findElement(By.id("u4"));
		Thread.sleep(2000);
		loginButton.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u42_input")));
		System.out.println("Page Url Now: " + driver.getCurrentUrl());

	}

	@Test
	void testSignInSucceedd() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/signin.html");

		System.out.println("signing in with right username and password...");
		WebElement username = driver.findElement(By.id("u42_input"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("u43_input"));
		password.sendKeys("admin");

		// click on login button
		WebElement login = driver.findElement(By.id("u44"));
		Thread.sleep(2000);
		login.click();
		// verify login successfully.
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u163_text")));
		System.out.println("Page Url Now: " + driver.getCurrentUrl());

		ExpectedConditions.textToBe(By.id("u163_text"), "admin");
		System.out.println("signed in successfully.");
	}

	@Test
	void testSignInFailed() throws InterruptedException {
		// nav back to login page.
		driver.get("https://wd1gdz.axshare.com/signin.html");
		WebElement wrongUsername = driver.findElement(By.id("u42_input"));
		wrongUsername.clear();
		wrongUsername.sendKeys("haha");
		WebElement wrongPassword = driver.findElement(By.id("u43_input"));
		wrongPassword.clear();
		wrongPassword.sendKeys("hehe");

		// click on login button
		System.out.println("try loging in with wrong username and password...");
		WebElement wrongPWLogin = driver.findElement(By.id("u44"));
		Thread.sleep(2000);
		wrongPWLogin.click();

		// wait until login failed page loaded.
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u70_text")));
		System.out.println("Page Url Now: " + driver.getCurrentUrl());

		String loginFailedAlert = driver.findElement(By.id("u70_text")).getText();
		Assert.assertEquals("Sorry, the username doesn't match the password", loginFailedAlert);
		System.out.println("login failed as expected.");
	}
	


}
