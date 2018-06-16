package Com.Crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCampaign {
	private @FindBy(xpath="//input[@name='campaignname']")
	 WebElement nameEdt;
	private @FindBy(xpath="//input[@class='crmButton small save']")
	 WebElement saveBtn;
	private @FindBy(xpath="(//input[@class='crmbutton small cancel'])[1]")
	 WebElement cancelBtn;
	public void createCampaign(String cName)
	{
		nameEdt.sendKeys(cName);
		saveBtn.click();
	}

}
