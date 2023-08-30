package com.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.Lib;

public class MobilePage {
	Lib l1=new Lib();

	@FindBy(xpath = "//select[@title='Sort By']")
	private WebElement sortby;

	@FindBy(xpath = "//h1")
	private WebElement headingcompare;
	@FindBy(xpath = "//ul[@class]/li/a[@title]")
	private List<WebElement> allitemsTitle;

	@FindBy(xpath = "//span[@class='regular-price']")
	private WebElement sonyXperiaprice;

	@FindBy(xpath = "//a[text()='Sony Xperia']")
	private WebElement sonXperialink;

	@FindBy(xpath="//span[@class='price']")
	private WebElement SonyXperiaPrice;

	@FindBy(xpath = "//a[text()='Sony Xperia'and @title]/../..//button")
	private WebElement addtoCartSony;

	@FindBy(xpath = "//input[@title='Qty']")
	private WebElement qtyValue;

	@FindBy(xpath = "//button[@class='button btn-update']")
	private WebElement UpdateButton;

	@FindBy(xpath="//p[@class='item-msg error']")
	private WebElement ItemErrorMess;

	@FindBy(id="empty_cart_button")
	private WebElement EmptyCartBtn;

	@FindBy(xpath = "//h1")
	private WebElement AfterEmpty;
	
	@FindBy(xpath = "//a[text()='Sony Xperia']/../..//a[text()='Add to Compare']")
	private WebElement compareSony;
	
	@FindBy(xpath="//a[text()='IPhone']/../..//a[text()='Add to Compare']")
	private WebElement compareIphone;
	@FindBy(xpath = "//button[@title='Compare']")
	private WebElement compareBtn;
	
	@FindBy(xpath = "//button[@title='Close Window']")
private WebElement PopUpCloseWindowbtn;

	@FindBy(xpath = "//h1")
	private WebElement headingCompare;

	public MobilePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}



	public List<WebElement> getAllitemsTitle() {
		return allitemsTitle;
	}



	public WebElement getSortby() {
		return sortby;
	}


	public WebElement getHeadingcompare() {
		return headingcompare;
	}

	public void comparepricem()
	{
		String a = sonyXperiaprice.getText();
		System.out.println(a);
	}
	public void Sonyx()
	{
		String a = sonyXperiaprice.getText();
		sonXperialink.click();
		String aa = SonyXperiaPrice.getText();
		assertEquals(a, aa);
	}
	public void AddproductCart()
	{
		addtoCartSony.click();
		qtyValue.sendKeys("2000");
		UpdateButton.click();
		String err = ItemErrorMess.getText();
		Reporter.log(err,true);
		EmptyCartBtn.click();
		String sa = AfterEmpty.getText();
		String ee="SHOPPING CART IS EMPTY";
		assertEquals(sa, ee);
	}
public void comapareTwoProduct(WebDriver driver) throws EncryptedDocumentException, IOException
{
	compareSony.click();
	compareIphone.click();
	compareBtn.click();
	Set<String> windows = driver.getWindowHandles();
	
	boolean count=(windows.size()>1);
	assertTrue(count,"The window is not opened in new window");
	String tst=l1.getExcelData("sheet1", 0, 1);
	
	for(String win:windows)
	{
		 driver.switchTo().window(win).getTitle();
	
			if(headingCompare.equals(tst))
			{
				assertEquals(tst,headingCompare.getText(),"HEADING IS NOT MATCHING");
				driver.close();
				
				Set<String> count1 = driver.getWindowHandles();
				boolean cond2 = (count1.size()==1);
				assertTrue(cond2);
			}
		
	}
	
}
	

}