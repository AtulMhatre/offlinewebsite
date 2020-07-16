import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddUserTest {
	WebDriver driver;
	AddUserPage AU;

	@BeforeMethod
	public void OpenBrowser() {
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Atul/Desktop/Selenium/Offline%20Website/index.html");
		// driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		// driver.findElement(By.id("password")).sendKeys("123456");
		// driver.findElement(By.xpath("//button")).click();
		AU = new AddUserPage(driver);
		AU.NavigateToAddUserPage();
	}

	@AfterMethod
	public void CloseBrowser() {

		driver.close();
	}

	 @Test(priority = 1)
	 public void verifyClickOnUsers() {
	 AU.clickOnUsers();
	 String Actual = driver.getTitle();
	 String Expected = "JavaByKiran | User";
	Assert.assertEquals(Actual, Expected);
	}
	
	 @Test(priority = 2)
	 public void verifyHeaderFirstRow() {
	 AU.verifyHeader();
	 }
	
	 @Test(priority = 3)
	public void verifyClickOnAddUser() {
	AU.clickOnAddUser();
	 String Actual = driver.getTitle();
	String Exptected = "JavaByKiran | Add User";
	 Assert.assertEquals(Actual, Exptected);
	 }

	@Test
	public void checkDomainOfEmail() {
		AU.verifyEmail(driver);
	}

	@Test
	public void checkGender() {
		AU.verifyGender(driver);
}

	@Test
	public void checkDeleteButton(){ 
		AU.verifyDeleteButton(driver);
	}
}