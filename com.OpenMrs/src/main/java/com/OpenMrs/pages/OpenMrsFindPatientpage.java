package com.OpenMrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.OpenMrs.Base.Testbase;

public class OpenMrsFindPatientpage extends Testbase {
	@FindBy(xpath="//input[@id='patient-search']") WebElement patientSearch;
	@FindBy (xpath="//span[contains(text(),'100GHA')]") WebElement PatientId;
	@FindBy(xpath="//td[contains(text(),'Mary Smith')]") WebElement clickOnPatient;
	
	public OpenMrsFindPatientpage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void FindpatientEMR(){
		patientSearch.sendKeys(prop.getProperty("PatientName"));
		clickOnPatient.click();
		
		
		
	}
	public void validationPatient(){
      String id = PatientId.getText();
	  Assert.assertEquals(id, prop.getProperty("patientId"));
	  if (id.equals(prop.getProperty("patientId"))){
		  System.out.println("ID match");
		  
	  }
	  else{
		  System.out.println("Id does not match");
	  }
	  
	}
	
	

}
