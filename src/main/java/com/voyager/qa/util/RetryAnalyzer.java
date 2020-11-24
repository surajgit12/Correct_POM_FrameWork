package com.voyager.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0; // it will start from zero
	int RetryLimit =2; // we have to given 2 more chances failures test cases

	
	

	public boolean retry(ITestResult result) {

		if (counter < RetryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}


//there are two ways we can execute failed test cases 1)At test level and 2 ) At run time

// 1)
/*@Test(retryAnalyzer = RetryAnalyzer.class)
public void test() {
	
}*/


// 2) At runtime (Using retry class with IAnnotationTransformer interface)


