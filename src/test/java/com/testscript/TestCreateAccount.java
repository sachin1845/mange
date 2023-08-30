package com.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.CreateAccountPage;

import com.pom.HomePage1;
import com.pom.TV;

import generic.Baseclass;

public class TestCreateAccount extends Baseclass{
	@Test
	
	public void testCreateAcc() throws IOException {
		
		HomePage1 h1 = new HomePage1(driver);
		CreateAccountPage c1=new CreateAccountPage(driver);
		TV T1 = new TV(driver);
		h1.getAccountbtn().click();;
		h1.getMyaccountbtn().click();
		c1.registerNewCustomer();
		//h1.getTVlink().click();
		//T1.Sharetowishlist();
		
	}

}
//sachisachi45@gmail.com
//sachin45