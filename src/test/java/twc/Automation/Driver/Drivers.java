package twc.Automation.Driver;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class Drivers extends read_Property_File_Info {
	@SuppressWarnings("rawtypes")
	protected static AppiumDriver Ad ;
	public static WebDriver driver = null;
	public static WebDriverWait wait=null;

	@Step("{0}")
	public static void logStep(String stepName) {
	}

	/*@Attachment("Screenshot")
    public static byte[] attachScreen() {
        logStep("Taking screenshot");
        return (((TakesScreenshot)Ad).getScreenshotAs(OutputType.BYTES));
    }*/
	
	@Step("Generating Screenshot")
	public static void attachScreen() {
		captureScreenShot();
	}
	
	@Attachment("Screenshot")
	public static byte[] captureScreenShot() {
		// public static byte[] attachScreen() {
		try {
			System.out.println("Generating Screenshot");
			logStep("Generating Screenshot");
			// logStep("Taking screenshot");
			return (((TakesScreenshot) Ad).getScreenshotAs(OutputType.BYTES));
		} catch (Exception e) {
			System.out.println("Failed to capture Screenshot");
			logStep("Failed to capture Screenshot");
			e.printStackTrace();
			System.out.println(e.getMessage());
			logStep(e.getMessage());
			return null;
		}

	}
}
