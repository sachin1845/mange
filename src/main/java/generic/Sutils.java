package generic;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sutils {
	public void waitforPagetoload(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains(title));
	}
	public String getDateStamp()
	{
		String stamp=LocalDateTime.now().toString().replace(":", "");
		return stamp;
		
	}

}
