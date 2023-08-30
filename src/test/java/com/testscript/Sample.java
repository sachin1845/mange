package com.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.CreateExcel;

public class Sample {
	@Test
	public void testdata() throws IOException
	{
		CreateExcel aa = new CreateExcel();
		aa.writeExcelData(1, 1, "sachindd");
		aa.writeExcelData(1, 2,"sachin45556666");
	}
	
}
