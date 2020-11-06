package Com.Listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Com.Qa.Util.JiraServiceProvider;
import Com.Qa.Util.jirapolicy;

public class TestJiraListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		jirapolicy jirapolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(jirapolicy.class);		
		boolean isticketready = jirapolicy.logTicketReady();
		
		if(isticketready) {
			
			System.out.println("is ticket ready for jira"+isticketready);
			JiraServiceProvider jirasp = new JiraServiceProvider("https://pavansofwareautomationtester.atlassian.net", "pavanggowda28@gmail.com" , "dAzN1bYevgCJvoETFeBK14A3" ,  "CC");		
			String issuesummary = result.getMethod().getConstructorOrMethod().getMethod().getName()+"got failed due to some assertions or exception";
			String issuedescription = result.getThrowable().getMessage();	
			issuedescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			
			jirasp.createjiraticket("Bug", issuesummary, issuedescription, "PAVAN ");
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
