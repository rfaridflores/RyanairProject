package testRyanairUtilities;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class RyanairSuiteListener implements ISuiteListener{
	
	public static RyanairParameter parameter = new RyanairParameter();
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub		
	}
	
	public void onStart(ISuite suite) {
		
		parameter.setDriverType(suite.getParameter("driverType"));
		parameter.setUrl(suite.getParameter("url"));
		parameter.setUser(suite.getParameter("user"));
		parameter.setPass(suite.getParameter("pass"));
	}
}
