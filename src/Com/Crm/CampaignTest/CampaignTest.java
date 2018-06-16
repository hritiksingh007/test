package Com.Crm.CampaignTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import Com.Crm.Commonlib.ExcelLib;
import Com.Crm.ObjectRepository.Campaign;
import Com.Crm.ObjectRepository.CreateCampaign;
import Com.Crm.ObjectRepository.Home;
import Com.Crm.ObjectRepository.LogOut;
import Com.Crm.ObjectRepository.Login;



public class CampaignTest {
	public static void main(String args[]) throws Throwable
	{
		
		ExcelLib lib=new ExcelLib();
		String uname=lib.getExcelData("Campaign", 1, 2);
		String pwd =lib.getExcelData("Campaign", 1, 3);
		String cn=lib.getExcelData("Campaign", 1, 4);
		//Login to crm
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/");

		//Login By method as per POM
		Login l=PageFactory.initElements(driver, Login.class);
		l.loginToApp(uname, pwd);
		
		//navigate To campaign page
		Home h=PageFactory.initElements(driver, Home.class);
		h.navigateToCampaign(driver);
		
		//Click on create campaign... 
	    Campaign cp=PageFactory.initElements(driver, Campaign.class);
		cp.createCampaign();
		//create campaign
		CreateCampaign cc=PageFactory.initElements(driver, CreateCampaign.class);
		cc.createCampaign(cn);
		
		
		
		//Logout Code
		LogOut lo=PageFactory.initElements(driver, LogOut.class);
		lo.logOut(driver);
		
		
		
		
		
		
		/*driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get("http://localhost:8081/");
		driver.findElement(By.xpath("//form[@id='form']//input[@name='user_name']")).sendKeys(uname);
		driver.findElement(By.xpath("//form[@id='form']//input[@name='user_password']")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
			WebElement wb=driver.findElement(By.xpath("//a[text()='More']"));
			Actions act=new Actions(driver);
		    act.moveToElement(wb).perform();
		    wb=driver.findElement(By.xpath("//a[@id='more' and @name='Campaigns']"));
		    wb.click();
		    driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		    
		   
		    driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(cn);
		    driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		    String s1=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		    String s2=driver.findElement(By.xpath("//span[@class='small']")).getText();
		    String actTxt=s1+s2;
		    String expectedTxt="Campaign InformationUpdated today";
		    if(actTxt.contains(expectedTxt))
		    {
		    	System.out.print("CREATED CAMPAIGN Successfully");
		    }
		    else
		    {
		    	System.out.print("TC FAIL");
		    	
		    }
		  //sign out 
		    WebElement wbOut=driver.findElement(By.xpath("//a[@name='top']/following-sibling::table[1]/tbody/tr[1]/td[3]/table/tbody/tr/td[2]"));
		    act.moveToElement(wbOut).perform();
		    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			driver.close();
			*/
	}

}
