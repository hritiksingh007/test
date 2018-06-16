package Com.Crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(name="user_name")
	WebElement userNameEdt;
	@FindBy(name="user_password")
	WebElement passwordEdt;
	@FindBy(id="submitButton")
	WebElement login;
	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		login.click();
	}

}
