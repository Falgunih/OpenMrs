package com.OpenMrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.OpenMrs.Base.Testbase;

public class OpenMrsHomepage extends Testbase{
	
	@FindBy(xpath="//i[@class='icon-search']") WebElement FindPatientRecord;
	@FindBy(xpath="//a[@id='org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension'] ") WebElement ActiveVisits;

	
	
	
	public OpenMrsHomepage(){
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void OpenMrsHomePageverify(){
		FindPatientRecord.click();
		
			
	}
	public void verifytheTitle(){
		String actualTitle = driver.getTitle();
		String ExpectedTitle="OpenMRS Electronic Medical Record";
		Assert.assertEquals(actualTitle, ExpectedTitle,"True");
		if (actualTitle.equals(ExpectedTitle)){
			System.out.println("Pass=TitleMatch");
		}
		else{
			System.out.println("Fail=Title not Match");
		}
}
}


