package com.pom;

import static org.testng.Assert.assertTrue;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.Lib;

public class CreateAccountPage {

	Lib	l=new Lib();
	@FindBy(xpath = "//span[text()='Create an Account']")
	private WebElement createanaccountbtn;

	@FindBy(id = "firstname")
	private WebElement firstnametxtf;
	@FindBy(id="middlename")
	private WebElement middlenametxtf;
	@FindBy(id="lastname")
	private WebElement lastnametxtf;
	@FindBy (id = "email_address")
	private WebElement emailtxtf;
	@FindBy(xpath = "//input[@title='Password']")
	private WebElement passwordtxtf;
	@FindBy(xpath = "//input[@title='Confirm Password']")
	private WebElement confirmpasswordtxtf;
	@FindBy(xpath = "//span[text()='Register']")
	private WebElement Registerbtn;
	@FindBy(xpath="//div/ul/li/ul/li/span")
	private WebElement Registrationconfirmmed;




	public CreateAccountPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	public void registerNewCustomer() throws IOException
	{
		createanaccountbtn.click();
		firstnametxtf.sendKeys("sachin"+l.getRandomNum());
		middlenametxtf.sendKeys("sachin"+l.getRandomNum());
		lastnametxtf.sendKeys("sachin"+l.getRandomNum());
		String email1 = "sachin"+l.getRandomNum()+"@gmail.com";

		emailtxtf.sendKeys(email1);
		String password = "sachin"+l.getRandomNum()+"q";


		passwordtxtf.sendKeys(password);
	//	l.writeExcelData(0, 1, password);
	//	l.writeExcelData(0, 2, email1);
		
		l.writeExcelData1(0, 1, password);
		l.writeExcelData1(0, 0, email1);
		

		confirmpasswordtxtf.sendKeys(password);

		Registerbtn.click();

		boolean comfirm=Registrationconfirmmed.isDisplayed();

		assertTrue(comfirm);
		Reporter.log(Registrationconfirmmed.getText(),true);
	}
}
