package Com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogOut {
	
	@FindBy(xpath="//a[@name='top']/following-sibling::table[1]/tbody/tr[1]/td[3]/table/tbody/tr/td[2]")
	WebElement logOutImg;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logOutLink;
	public void logOut(WebDriver d)
	{
		Actions act=new Actions(d);
		act.moveToElement(logOutImg).perform();
		logOutLink.click();
	}
}
