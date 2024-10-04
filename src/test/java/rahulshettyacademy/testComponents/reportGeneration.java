package rahulshettyacademy.testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reportGeneration {
	public	static ExtentReports extent;
	 static String methodName = new Exception().getStackTrace()[1].getMethodName();
	public static ExtentReports extentReportConfig()
	{
		String reportPath=System.getProperty("user.dir")+"\\Reports";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Creating first report");
		reporter.config().setDocumentTitle("Test Execution");
		reporter.config().setReportName(methodName);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester","Saptarsi");
		return extent;
	}
}
