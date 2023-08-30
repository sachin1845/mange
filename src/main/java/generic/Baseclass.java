package generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	static 
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	}
	public static WebDriver driver;
	@BeforeTest


	public void open() throws IOException {
		driver=new ChromeDriver();
		Lib l1 = new Lib();
		String url = l1.getPropertyData("url");
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}

	

}
