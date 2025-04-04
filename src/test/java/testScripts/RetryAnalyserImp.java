package testScripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyserImp implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if(retryCount < maxRetryCount) {
				retryCount++;
				return true;
			}
		}
		return false;
	}
  
}
