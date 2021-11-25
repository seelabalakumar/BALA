package framework;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReporterUtil {
	private ExtentReports extentReports;
	private ExtentTest extentTest;
	
	public void initializeReport(String reportFilePath) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(reportFilePath));
		sparkReporter.config().setDocumentTitle("Execution report ");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("User", System.getProperty("user.name"));
		extentReports.setSystemInfo("Browser", System.getProperty("chrome"));
	}
	
	public void createTest(String testCaseName) {
		extentTest = extentReports.createTest(testCaseName);
	}
	
	public void writeLog(Status status, String stepInfo) {
		extentTest.log(status, stepInfo);
	}
	
	public void writeLog(Status status, String stepInfo, String screenShot) {
		extentTest.log(status, stepInfo);
	}
	
	public void finalizeReport() {
		extentReports.flush();
	}
	

}
