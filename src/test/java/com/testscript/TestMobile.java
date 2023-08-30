package com.testscript;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.HomePage1;
import com.pom.MobilePage;

import generic.Baseclass;

public class TestMobile  extends Baseclass{
	@Test(priority = 1)

	public void testMobileList()
	{

		HomePage1 h = new HomePage1(driver);
		String aa = h.getHPtitle().getText().trim();
		String ee="THIS IS DEMO SITE FOR";
		assertEquals(aa, ee);
		h.getMobilelink().click();

		MobilePage m = new MobilePage(driver);
		String a1 = m.getHeadingcompare().getText();
		String e1="MOBILE";
		assertEquals(a1, e1);

		Select s1 = new Select(m.getSortby());
		s1.selectByIndex(1);

		ArrayList<String> arr1=new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();

		List<WebElement> allmobile = m.getAllitemsTitle();
		for(WebElement mb:allmobile)
		{
			String text = mb.getAttribute("title");
			arr1.add(text);
			arr2.add(text);
			System.out.println(text);
		}

		Collections.sort(arr2);

		boolean sorted=arr1.equals(arr2);
		Assert.assertTrue(sorted);
	}


	@Test(priority = 2)
	public void PriceComapreSonyXperia()
	{
		HomePage1 ha = new HomePage1(driver);
		MobilePage ma = new MobilePage(driver);
		ha.getMobilelink().click();
		ma.Sonyx();
	}
	
	@Test(priority = 3)
	
	public void AddtoCart()
	{
		HomePage1 ha = new HomePage1(driver);
		MobilePage ma=new MobilePage(driver);
		ha.getMobilelink().click();
		ma.AddproductCart();	
	}
	
	@Test(priority = 4)
	public void  compareProducts() throws EncryptedDocumentException, IOException
	{
		
		HomePage1 haa = new HomePage1(driver);
		MobilePage maa=new MobilePage(driver);
		haa.getMobilelink().click();
		maa.comapareTwoProduct(driver);
	}
}
