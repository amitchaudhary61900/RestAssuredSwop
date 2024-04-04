package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
static ExtentReports extent;
	
	public static ExtentReports getReporterObject() {
		
		//ExtentReports, ExtentSparkReporter
		String path= System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Swopper API Automation Report");
		reporter.config().setDocumentTitle("Automation Report");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation API Framework Build by : ", "Amit Kumar Chaudhary");
		return extent;
			
		
	}

}
