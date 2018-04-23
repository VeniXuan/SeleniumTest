package selenium.mobile;

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
		driver.get("https://wd1gdz.axshare.com/signinmobile.html");
		Thread.sleep(2000);
		WebElement signupButton = driver.findElement(By.id("u503"));
		signupButton.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("u505")));
		
		WebElement pw = driver.findElement(By.id("u518_input"));
		pw.clear();
		pw.sendKeys("haha");
		WebElement confirmpw = driver.findElement(By.id("u510_input"));
		confirmpw.clear();
		confirmpw.sendKeys("hehe");
		
		WebElement email= driver.findElement(By.id("u519_input"));
		email.sendKeys("testSignUp@gmail.com");
		
		WebElement phone = driver.findElement(By.id("u521_input"));
		phone.sendKeys("123456789");
		
		WebElement signUpButton = driver.findElement(By.id("u524"));
		Thread.sleep(1500);
		
		signUpButton.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u529_text")));
		
	    ExpectedConditions.textToBe(By.id("u529_text"), "Please input the same password");
		System.out.println("SignUp with unmatched password failed as expected.");
	}
	@Test
	void testSignUpFailedWithNoInput() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/signinmobile.html");
		Thread.sleep(2000);
		//go to signup
		WebElement signupButton = driver.findElement(By.id("u503"));
		signupButton.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("u505")));
		Thread.sleep(2000);
		
		//sign up 
		WebElement signupButtonWithinSignUp = driver.findElement(By.id("u524"));
		signupButtonWithinSignUp.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("u529_text")));
		
		ExpectedConditions.textToBe(By.id("u529_text"),"Please Fill out all information then sign up" );
		System.out.println("SignUp with no input failed as expected.");
	}
	@Test
	void testSignUpSucceed() throws InterruptedException {
		driver.get("https://wd1gdz.axshare.com/signinmobile.html");
		Thread.sleep(2000);
		//go to signup
		WebElement signupButton = driver.findElement(By.id("u503"));
		signupButton.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("u505")));
		Thread.sleep(2000);
		
		String usernameInput = "testSignUp";
		
		WebElement username = driver.findElement(By.id("u516_input"));
		username.clear();
		username.sendKeys(usernameInput);
		
		WebElement email= driver.findElement(By.id("u519_input"));
		email.sendKeys("testSignUp@gmail.com");
		
		WebElement phone = driver.findElement(By.id("u521_input"));
		phone.sendKeys("123456789");
		Thread.sleep(2000);
		WebElement signUpButtonWithinSignup = driver.findElement(By.id("u524"));
		signUpButtonWithinSignup.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("https://wd1gdz.axshare.com/homepagemobileuser.html"));
		
		ExpectedConditions.textToBe(By.id("u678_text"),usernameInput);
	
		System.out.println("SignUp Succeed as expected.");
	}
	
	
}
