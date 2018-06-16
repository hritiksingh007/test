package Com.Crm.ContactTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Com.Crm.Commonlib.ExcelLib;

public class ContactTest {
	public static void main(String args[]) throws Throwable
	{
		ExcelLib lib=new ExcelLib();
		String uname=lib.getExcelData("Contact", 1, 2);
		String pwd =lib.getExcelData("Contact", 1, 3);
		String fName=lib.getExcelData("Contact", 1, 4);
		String lName=lib.getExcelData("Contact", 1, 5);
		//Login to crm
				WebDriver driver=new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
				
				driver.get("http://localhost:8081/");
				driver.findElement(By.xpath("//form[@id='form']//input[@name='user_name']")).sendKeys(uname);
				driver.findElement(By.xpath("//form[@id='form']//input[@name='user_password']")).sendKeys(pwd);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				//create contact with given value
				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fName);
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lName);
				//Save
				driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
				//Capture contact ID
				String conID=driver.findElement(By.xpath("//div[@id='tblContactInformation']/table/tbody/tr[1]/td[4]")).getText();
				System.out.println("CONTACT ID=="+conID);
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				//SEARCHING through FIRST NAME
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(fName);
				WebElement wb=driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield' and @name='search_field']"));
				Select sel=new Select(wb);
			    sel.selectByVisibleText("First Name");
			    //click on search button
			    driver.findElement(By.xpath("//input[@name='submit']")).click();
			    Thread.sleep(2000);
			    //Verification
			    WebElement wb2=driver.findElement(By.xpath("//form[@id='massdelete']/table[1]/tbody/tr[1]/td/table[@class='layerPopupTransport']/tbody/tr[1]/td[1]"));
		        String sResult=wb2.getText();
		        if(sResult.contains("Showing"))
		        {
		        	System.out.println("DATA FOUND through first name TC==Pass");
		        }
		        else
		        {
		        	System.out.println("DATA NOT FOUND TC==FAIL");
		        }
		        
		      //SEARCHING through LAST NAME
		      		driver.findElement(By.xpath("//input[@name='search_text']")).clear();
		      		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(lName);
		      		WebElement wb3=driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield' and @name='search_field']"));
		      		Select sel2=new Select(wb3);
		      	    sel2.selectByVisibleText("Last Name");
		      	    //click on search button
		      	    driver.findElement(By.xpath("//input[@name='submit']")).click();
		      	    //varification
		      	    WebElement wb4=driver.findElement(By.xpath("//form[@id='massdelete']/table[1]/tbody/tr[1]/td/table[@class='layerPopupTransport']/tbody/tr[1]/td[1]"));
		              String sResult2=wb4.getText();
		              if(sResult2.contains("Showing"))
		              {
		              	System.out.println("DATA FOUND through last name TC==Pass");
		              }
		              else
		              {
		              	System.out.println("DATA NOT FOUND TC==FAIL");
		              }
		              
		            //SEARCHING through CONTACT ID
		        		driver.findElement(By.xpath("//input[@name='search_text']")).clear();
		        		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(conID);
		        		WebElement wb5=driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield' and @name='search_field']"));
		        		Select sel3=new Select(wb5);
		        	    sel3.selectByVisibleText("Contact Id");
		        	    //click on search button
		        	    driver.findElement(By.xpath("//input[@name='submit']")).click();
		        	    Thread.sleep(2000);
		        	    //varification
		        	    WebElement wb6=driver.findElement(By.xpath("//form[@id='massdelete']/table[1]/tbody/tr[1]/td/table[@class='layerPopupTransport']/tbody/tr[1]/td[1]"));
		                String sResult3=wb6.getText();
		                if(sResult3.contains("Showing"))
		                {
		                	System.out.println("DATA FOUND through CONTAct id TC==Pass");
		                }
		                else
		                {
		                	System.out.println("DATA NOT FOUND TC==FAIL");
		                }
		                
		              //SEARCHING through NEGATIVE SCENARIO        	
		                driver.findElement(By.xpath("//input[@name='search_text']")).clear();
		        		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("123ghgf");
		        		WebElement wb7=driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield' and @name='search_field']"));
		        		Select sel4=new Select(wb7);
		        	    sel4.selectByVisibleText("First Name");
		        	    //click on search button
		        	    driver.findElement(By.xpath("//input[@name='submit']")).click();
		        	    Thread.sleep(2000);
		        	    //varification
		        	    WebElement wb8=driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
		                String sResult4=wb8.getText();
		                System.out.println("FOR NEGATIVE"+sResult4);
		                if(sResult4.contains("No"))
		                {
		                	System.out.println("DATA FOUND through NEGATIVE  TC==Pass");
		                }
		                else
		                {
		                	System.out.println("DATA NOT FOUND TC==FAIL");
		                }
		                Actions act= new Actions(driver);
		        	    WebElement wbOut=driver.findElement(By.xpath("//a[@name='top']/following-sibling::table[1]/tbody/tr[1]/td[3]/table/tbody/tr/td[2]"));
		        	    act.moveToElement(wbOut).perform();
		        	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		        		driver.close();
	}

}
