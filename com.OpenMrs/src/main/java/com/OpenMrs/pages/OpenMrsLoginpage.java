package com.OpenMrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenMrs.Base.Testbase;
import com.gargoylesoftware.htmlunit.WebClient;

public class OpenMrsLoginpage extends Testbase {

	@FindBy(xpath="//input[@id='username']") WebElement username;
	@FindBy(xpath="//input[@id='password']")  WebElement password;
	@FindBy(xpath="//li[@id='Isolation Ward']") WebElement Location;
	@FindBy (xpath="//input[@id='loginButton']") WebElement login;
	
	
	public OpenMrsLoginpage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginPage(){
		username.sendKeys("Admin");
		password.sendKeys("Admin123");
		Location.click();
		login.click();
	}
	public void verifytheTitle(){
		String actualTitle = driver.getTitle();
		String ExpectedTitle="Login";
		Assert.assertEquals(actualTitle, ExpectedTitle,"True");
		if (actualTitle.equals(ExpectedTitle)){
			System.out.println("Pass=TitleMatch");
		}
		else{
			System.out.println("Fail=Title not Match");
		}
	}
	
}
