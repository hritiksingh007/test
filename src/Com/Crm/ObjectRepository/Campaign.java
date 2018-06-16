package Com.Crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Campaign {
	private @FindBy(xpath="//img[@title='Create Campaign...']")
	WebElement createCampaign ;
	private @FindBy(xpath="//input[@name='search_text']")
	WebElement searchEditBox;
	private @FindBy(xpath="(//input[@class='crmbutton small create'])[1]")
    WebElement searchButton;
	private @FindBy(xpath="(//input[@class='crmbutton small delete'])[1]")
	WebElement deleteButton;

public void createCampaign()
{
	createCampaign.click();
}
}