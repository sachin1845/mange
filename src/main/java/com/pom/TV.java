package com.pom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TV {
	@FindBy(xpath = "//a[text()='LG LCD']/../..//a[text()='Add to Wishlist']")
private WebElement addLGLCDwishList;
	
	@FindBy(xpath = "//span[text()='Share Wishlist']")
	private WebElement shareTowishlist;
	@FindBy(xpath = "//textarea[@id='email_address']")
	private WebElement emailtxtarea;
	
	@FindBy(xpath = "//textarea[@id='message']")
	private WebElement messagetextarea;
	
	@FindBy(xpath = "//button[@title='Share Wishlist']")
	private WebElement sharewishlistbtn;
	
	@FindBy(xpath = "//span[text()='Your Wishlist has been shared.']")
	private WebElement sharemessage;
	
	public TV(WebDriver driver)
	{
		PageFactory.initElements( driver,this);	
	}
	public void Sharetowishlist()
	{
		addLGLCDwishList.click();
		shareTowishlist.click();
		emailtxtarea.sendKeys("sachin18@gmail.com");
		messagetextarea.sendKeys("jhgfghjkkjhhgvhj");
		sharewishlistbtn.click();
		boolean message1 = sharemessage.isDisplayed();
		assertTrue(message1,"the message is not there");
	}
}
