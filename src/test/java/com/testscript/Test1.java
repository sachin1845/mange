package com.testscript;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.pom.HomePage1;

import generic.Baseclass;
import generic.Lib;


public class Test1  extends Baseclass{



	@Test
	public void test() throws EncryptedDocumentException, IOException
	{
	HomePage1 ha = new HomePage1(driver);
	ha.userLogin();
	}

}
