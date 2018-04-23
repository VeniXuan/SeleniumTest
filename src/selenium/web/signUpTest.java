package selenium.web;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class signUpTest {

	WebDriver driver;

	public signUpTest() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./chromedriver");
	}
	@Test
	void testSignUpFailedWithUnMatchPassword() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/signin.html");
		
		WebElement pw = driver.findElement(By.id("u57_input"));
		pw.clear();
		pw.sendKeys("haha");
		WebElement confirmpw = driver.findElement(By.id("u49_input"));
		confirmpw.clear();
		confirmpw.sendKeys("hehe");
		
		WebElement email= driver.findElement(By.id("u59_input"));
		email.sendKeys("testSignUp@gmail.com");
		
		WebElement phone = driver.findElement(By.id("u61_input"));
		phone.sendKeys("123456789");
		
		WebElement signUpButton = driver.findElement(By.id("u58"));
		Thread.sleep(1500);
		
		signUpButton.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u77_text")));
		
	    ExpectedConditions.textToBe(By.id("u77_text"), "Please input the same password");
		System.out.println("SignUp with unmatched password failed as expected.");
	}
	@Test
	void testSignUpFailedWithNoInput() {
		driver.get("https://wd1gdz.axshare.com/signin.html");
		
		WebElement signUpButton = driver.findElement(By.id("u58"));
		signUpButton.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u77_text")));
		
		ExpectedConditions.textToBe(By.id("u77_text"), "Please Fill out all information then sign up");

		System.out.println("SignUp with no input failed as expected.");
	}
	@Test
	void testSignUpSucceed() {
		driver.get("https://wd1gdz.axshare.com/signin.html");
		
		String usernameInput = "testSignUp";
		
		WebElement username = driver.findElement(By.id("u50_input"));
		username.clear();
		username.sendKeys(usernameInput);
		
		WebElement email= driver.findElement(By.id("u59_input"));
		email.sendKeys("testSignUp@gmail.com");
		
		WebElement phone = driver.findElement(By.id("u61_input"));
		phone.sendKeys("123456789");
		
		WebElement signUpButton = driver.findElement(By.id("u58"));
		signUpButton.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u163_text")));
		ExpectedConditions.urlToBe("https://wd1gdz.axshare.com/homepage_user.html");
		ExpectedConditions.textToBe(By.id(""), usernameInput);
		
		System.out.println("SignUp Succeed as expected.");
	}
	
	
}
