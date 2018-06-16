package Com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home {
private @FindBy(xpath="//a[text()='More']")
 WebElement more;
private @FindBy(linkText="Products")
 WebElement products;
private @FindBy(linkText="Contacts")
 WebElement contacts;
private @FindBy(linkText="Calendar")
 WebElement calendar;
private @FindBy(linkText="Leads")
 WebElement leads;
private @FindBy(linkText="Organizations")
 WebElement organizations;
private @FindBy(linkText="Documents")
 WebElement documents;
private @FindBy(linkText="Opportunities")
 WebElement opportunities;
private @FindBy(linkText="Trouble Tickets")
 WebElement troubleTickets;
private @FindBy(linkText="Dashboard")
 WebElement dashboard;


		//LINKS INSIDE MORE
			private @FindBy(linkText="Campaigns")
			WebElement campaignLink;
			private @FindBy(linkText="SMSNotifier")
			WebElement smsNotifierLink;
			private @FindBy(linkText="Our Sites")
			WebElement ourSitesLink;
			private @FindBy(linkText="Integration")
			WebElement integrationLink;
			private @FindBy(linkText="Mail Manager")
			WebElement mailManagerLink;
			private @FindBy(linkText="PBX Manager")
			WebElement pbxManagerLink;
			private @FindBy(linkText="Comments")
			WebElement commentsLink;
			private @FindBy(linkText="Recycle Bin")
			WebElement recycleBinLink;
			private @FindBy(linkText="RSS")
			WebElement rssLink;
			private @FindBy(linkText="Service Contracts")
			WebElement serviceContractsLink;
			private @FindBy(linkText="Reports")
			WebElement reportsLink;
			private @FindBy(linkText="Project Milestones")
			WebElement projectMilestonesLink;
			private @FindBy(linkText="Project Tasks")
			WebElement projectTasksLink;
			private @FindBy(linkText="Projects")
			WebElement projectsLink;
			private @FindBy(linkText="FAQ")
			WebElement faqLink;
			private @FindBy(linkText="Services")
			WebElement servicesLink;


//NavigateTo Campaign
public void navigateToCampaign(WebDriver driver)
{
Actions act=new Actions(driver);
act.moveToElement(more).perform();
campaignLink.click();
}
}