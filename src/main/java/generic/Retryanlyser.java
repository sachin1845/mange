package generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanlyser extends Baseclass implements IRetryAnalyzer{
	 
	int count=0;
	int maxcount=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxcount)
		{
			count++;
			return true;
		}
		return false;
	}

}
