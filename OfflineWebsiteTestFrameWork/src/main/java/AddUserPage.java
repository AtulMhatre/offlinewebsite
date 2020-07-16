import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddUserPage {
	WebDriver driver;
	@FindBy(id = "email")
	WebElement Email;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginButton;
	@FindBy(xpath = "//a[contains(@href,'users.html')]")
	WebElement Users;
	@FindBy(xpath = "//th")
	WebElement Header;
	@FindBy(xpath = "//button[text()='Add User']")
	WebElement AddUser;
	@FindBy(xpath = "//label[contains(text(),'Username')]")
	WebElement Username;
	@FindBy(xpath = "//label[contains(text(),'Courses')]")
	WebElement Courses;

	public AddUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void NavigateToAddUserPage() {
		Email.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		LoginButton.click();
		Users.click();
	}

	public void clickOnUsers() {
		Users.click();

	}

	public void verifyHeader() {
		ArrayList<String> expList = new ArrayList<String>();
		expList.add("#");
		expList.add("Username");
		expList.add("Email");
		expList.add("Mobile");
		expList.add("Course");
		expList.add("Gender");
		expList.add("State");
		expList.add("Actions");
		boolean flag = Header.getText().equals("#");
		Assert.assertTrue(flag);
		// List<WebElement> headerList = driver.findElements(Header);
		// for (int i = 0; i < headerList.size(); i++)
		// headerList.get(i).getText().equals(expList.get(i));

	}

	public void clickOnAddUser() {
		AddUser.click();
	}
	public void verifyEmail(WebDriver driver) {
		String exp = "@gmail.com";

		List<WebElement> expList = driver.findElements(By.xpath("//td[3]"));

		System.out.println(expList.size());// 4

		for (int i = 1; i < expList.size(); i++) {
			System.out.println(expList.get(i).getText());// kiran@gmail.com,
															// sagar@gmail.com
			boolean flag = expList.get(i).getText().contains(exp);
			Assert.assertTrue(flag);
		}
	}

	public void verifyGender(WebDriver driver) {
		String exp = "Male";
		String exp1 = "Female";
		List<WebElement> expList = driver.findElements(By.xpath("//td[6]"));
		System.out.println(expList.size());
		for (int i = 1; i < expList.size(); i++) {
			System.out.println(expList.get(i).getText());// Male
			boolean flag = (expList.get(i).getText().contains(exp) || expList.get(i).getText().contains(exp1));
			Assert.assertTrue(flag);
		}
	}

	public void verifyDeleteButton(WebDriver driver) {
		List<WebElement> Delete = driver.findElements(By.xpath("//td[8]"));
		for (int i = 1; i < Delete.size(); i++) {
			boolean flag = Delete.get(i).isEnabled();
			Assert.assertTrue(flag);

		}

	}
}