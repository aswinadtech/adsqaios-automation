package twc.android.app.pages;

import org.openqa.selenium.By;
import org.testng.Assert;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import twc.Automation.General.DeviceStatus;
import twc.Automation.General.Functions;
import twc.Automation.HandleWithCharles.CharlesProxy;
import twc.Automation.ReadDataFromFile.read_excel_data;

public class AirQualityCardContentScreen extends Functions {
	private CharlesProxy proxy;
	static AppiumDriver<MobileElement> Ad;
	
	
static String aQCardContentPageHeader_Name = "Air Quality";
	
	

	static By byAQCardContentPageHeader = MobileBy.name(aQCardContentPageHeader_Name);
	
	
	

	static MobileElement aQCardContentPageHeader = null;
	

	public AirQualityCardContentScreen(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}
	
	@Step("Wait For AirQuality Card Content Page")
	public static void waitForAirQualityCardContentPage() throws Exception {
		Functions.waitForVisibilityOfElementLocated(Ad, 80, byAQCardContentPageHeader);
		aQCardContentPageHeader = Ad.findElement(byAQCardContentPageHeader);
		attachScreen();
				
	}
	
	
	/**
	 * Verifies Pixel Call
	 * @param excelName
	 * @param sheetName
	 * @throws Exception
	 */
	public static void verifyPixel_Call_When_Navigated_To_AQDetails_Page_From_Feed1_Card(String excelName, String sheetName) throws Exception {
		String[][] data = read_excel_data.exceldataread(sheetName);
		String host = data[2][1];	
		String path = data[3][1];
		boolean flag = verifyAPICallWithHostandPath(host, path);
		if (flag) {
			System.out.println(host + path + " call is present in Charles session");
			logStep(host + path + " call is present in Charles session");
			System.out.println(host + path + " :Call Verification is successful");
			logStep(host + path + " :Call Verification is successful");

		} else {
			System.out.println(host + path + " call is not present in Charles session");
			logStep(host + path + " call is not present in Charles session");
			System.out.println(host + path + " :Call Verification is failed");
			logStep(host + path + " :Call Verification is failed");
			Assert.fail(host + path + " call is not present in Charles session");

		}
	}
	
	/**
	 * Verifies Pixel Call
	 * @param excelName
	 * @param sheetName
	 * @param expected
	 * @throws Exception
	 */
	public static void verifyPixel_Call_When_Navigated_To_AQDetails_Page_From_Feed1_Card(String excelName, String sheetName, boolean expected)
			throws Exception {
		
		String[][] data = read_excel_data.exceldataread(sheetName);
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		//readExcelValues.excelValues(excelName, sheetName);
		String host = data[2][1];
	
		String path = data[3][1];
		boolean flag = verifyAPICallWithHostandPath(host, path);
		if (flag) {
			System.out.println(host + path + " call is present in Charles session");
			logStep(host + path + " call is present in Charles session");

		} else {
			System.out.println(host + path + " call is not present in Charles session");
			logStep(host + path + " call is not present in Charles session");
		}
		if (expected == flag) {
			System.out.println(host + path + " :Call Verification is successful");
			logStep(host + path + " :Call Verification is successful");

		} else {
			System.out.println(host + path + " :Call Verification is failed");
			logStep(host + path + " :Call Verification is failed");
			if (expected) {
				System.out.println(host + path + " :Call expected to present but it not exists");
				logStep(host + path + " :Call expected to present but it not exists");
				Assert.fail(host + path + " :API Call expected to present but it not exists");
			} else {
				System.out.println(host + path + " :Call is not expected to present but it exists");
				logStep(host + path + " :Call is not expected to present but it exists");
				Assert.fail(host + path + " :Call is not expected to present but it exists");
			}
		}

	}
	
}
