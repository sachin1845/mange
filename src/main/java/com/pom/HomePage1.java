package com.pom;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Lib;

public class HomePage1 {

	Lib l1=new Lib();
	@FindBy(xpath = "//a[text()='Mobile']")
	private WebElement mobilelink;
	@FindBy(xpath = "//h2")
	private WebElement HPtitle;

	@FindBy(xpath = "//span[text()='Account']")
	private WebElement accountbtn;

	@FindBy(xpath="//a[text()='My Account']")
	private WebElement myaccountbtn;

	@FindBy(xpath = "//a[text()='TV']")
	private WebElement TVlink;


	@FindBy(id = "email")
	private WebElement emailtxtfi;
	@FindBy(id = "pass")
	private WebElement passtxtf;

	@FindBy(id="send2")
	private WebElement loginbtn;

	@FindBy(xpath = "//a[text()='My Wishlist']")
	private WebElement mywishlistlink;

	@FindBy(xpath = "//span[text()='Add to Cart']")
	private WebElement addtocartbtn;

	@FindBy(xpath = "//span[text()='Proceed to Checkout']")
	private WebElement proceedBtn;
	@FindBy(xpath = "//label[text()='Ship to different address']")
	private WebElement shipptodifferentradiobtn;

	@FindBy(xpath = "//button[@title='Continue']")
	private WebElement continuebtn;

	@FindBy(xpath="//select[@name='shipping[country_id]']")
	private WebElement countrydropdown;
	@FindBy(xpath = "//select[@name='shipping[region_id]']")
	private WebElement statedropdown;
	@FindBy(xpath = "//input[@name='shipping[postcode]']")
	private WebElement zipcode;
	@FindBy(xpath = "//input[@id='shipping:street1']")
	private WebElement shippingaddress;
	@FindBy(xpath = "//input[@name='shipping[city]']")
	private WebElement shippingcity;
	@FindBy(xpath ="//input[@name='billing[telephone]']")
	private WebElement billingtelephonenum1;

	@FindBy(xpath = "//select[@name='country_id']")
	private WebElement countrydd;
	@FindBy(xpath = "//select[@name='region_id']")
	private WebElement statedd;
	@FindBy(xpath = "//input[@id='postcode']")
	private WebElement zipcoDD;

	@FindBy(xpath="//span[text()='Estimate']")
	private WebElement estimatebtn;
	@FindBy(xpath = "//dt[text()='Flat Rate']/../..//span[@class='price']")
	private WebElement flatrate;
	@FindBy(xpath = "//input[@name='estimate_method']")
	private WebElement flatrateradiobtn;
	@FindBy(xpath = "//span[text()='Update Total']")
	private WebElement updatetotalbtn;
	@FindBy(xpath = "//strong/span[@class='price']")
	private WebElement shippingcostadded;
	@FindBy(xpath = "//input[@name='billing[street][]']")
	private WebElement billingaddress;
	@FindBy(xpath = "//input[@name='billing[city]']")
	private WebElement billingcity;
	@FindBy(xpath = "//select[@name='billing[region_id]']")
	private WebElement billingstateDropDown;
	@FindBy(xpath = "//input[@name='billing[postcode]']")
	private WebElement billingzipcode;
	@FindBy(xpath = "//input[@name='billing[telephone]']")
	private WebElement billingtelephonenum;
	@FindBy(xpath = "//button[@onclick='billing.save()']")
	private WebElement billingcontinebbtn;
	@FindBy(xpath = "//button[@onclick='shippingMethod.save()']")
	private WebElement shippingMethodcontinuebtn;


	@FindBy(xpath = "//input[@value='checkmo']")
	private WebElement moneyOrderRadiobtn;
	@FindBy(xpath = "//button[@onclick='payment.save()']")
	private WebElement paymentcontinuebtn;

	@FindBy(xpath = "//span[text()='Place Order']")
	private WebElement placeOrderbtn;

	@FindBy(xpath = "//p[text()='Your order # is: ']//a")
	private WebElement orderNumcomf;

	@FindBy(xpath = "//button[@onclick='billing.save()']")
	private WebElement billingcontinuebtn;

	public HomePage1(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	public WebElement getTVlink() {
		return TVlink;
	}

	public void setTVlink(WebElement tVlink) {
		TVlink = tVlink;
	}

	public WebElement getMobilelink() {
		return mobilelink;
	}

	public WebElement getHPtitle() {
		return HPtitle;
	}

	public WebElement getAccountbtn() {
		return accountbtn;
	}

	public WebElement getMyaccountbtn() {
		return myaccountbtn;
	}

	public void userLogin() throws EncryptedDocumentException, IOException 
	{
		accountbtn.click();
		myaccountbtn.click();
		//String un = l1.getExcelData("Sheet1", 1, 0);
		//String pwd = l1.getExcelData("Sheet1", 1, 1);		
		String un = l1.getExcelData("Sheet1", 4, 0);
		String pwd = l1.getExcelData("Sheet1",4, 1);	
		emailtxtfi.sendKeys(un);
		passtxtf.sendKeys(pwd);
		Reporter.log(pwd);		
		loginbtn.click();

		mywishlistlink.click();
		addtocartbtn.click();

		//Select cdd = new Select(countrydd);
		//	cdd.selectByValue("United States");
		Select sdd = new Select(statedd);
		sdd.selectByValue("43");
		zipcoDD.sendKeys("542896");
		estimatebtn.click();
		String ft = flatrate.getText();
		assertEquals(ft,"$5.00");

		Reporter.log(ft);
		flatrateradiobtn.click();
		updatetotalbtn.click();
		String sa = shippingcostadded.getText();
		Assert.assertEquals(sa,"$705.00");
		Reporter.log(sa);
		proceedBtn.click();
		billingaddress.sendKeys("ABC");
		billingcity.sendKeys("New York");
		Select bsdd = new Select(billingstateDropDown);
		bsdd.selectByVisibleText("New York");
		billingzipcode.sendKeys("54896");
		
		billingtelephonenum1.sendKeys("12345678");
		billingcontinebbtn.click();
		shippingMethodcontinuebtn.click();
	
		moneyOrderRadiobtn.click();
		paymentcontinuebtn.click();
		placeOrderbtn.click();
		String orderID = orderNumcomf.getText();
		Reporter.log(orderID);

	}

}
