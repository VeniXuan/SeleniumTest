package selenium.mobile;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
class homePageAndloginTest {

	WebDriver driver;

	public homePageAndloginTest() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./chromedriver");
	}

	@Test
	void testSignInButtonOnHomePage() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/homepagemobile.html");

		// home page, check sign-in button
		WebElement loginButton = driver.findElement(By.id("u361_img"));
		Thread.sleep(2000);
		loginButton.click();
		ExpectedConditions.urlToBe("https://wd1gdz.axshare.com/signinmobile.html");

	}

	@Test
	void testSignInSucceedd() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/signinmobile.html");

		System.out.println("signing in with right username and password...");
		WebElement username = driver.findElement(By.id("u490_input"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("u491_input"));
		password.sendKeys("admin");

		// click on login button
		WebElement loginButton = driver.findElement(By.id("u492"));
		Thread.sleep(2000);
		loginButton.click();
		// verify login successfully.
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u678_text")));

		ExpectedConditions.textToBe(By.id("u678_text"), "admin");
		System.out.println("signed in successfully.");
	}

	@Test
	void testSignInFailed() throws InterruptedException {
		// nav back to login page.
		driver.get("https://wd1gdz.axshare.com/signinmobile.html");
		WebElement wrongUsername = driver.findElement(By.id("u490_input"));
		wrongUsername.clear();
		wrongUsername.sendKeys("haha");
		WebElement wrongPassword = driver.findElement(By.id("u491_input"));
		wrongPassword.clear();
		wrongPassword.sendKeys("hehe");

		// click on login button
		System.out.println("try loging in with wrong username and password...");
		WebElement wrongPWLogin = driver.findElement(By.id("u492"));
		Thread.sleep(2000);
		wrongPWLogin.click();

		// wait until login failed page loaded.
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u486_text")));
		ExpectedConditions.textToBe(By.id("u486"), "Sorry, the username doesn't match the password");

		System.out.println("login failed as expected.");
	}
	


}
