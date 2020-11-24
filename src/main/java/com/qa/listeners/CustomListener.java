package com.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.voyager.qa.base.TestBase;

public class CustomListener  extends TestBase implements ITestListener {


	//@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FailedTestCaes");
	failed(result.getMethod().getMethodName());
	
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}