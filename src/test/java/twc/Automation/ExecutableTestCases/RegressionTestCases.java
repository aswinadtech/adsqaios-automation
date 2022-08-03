package twc.Automation.ExecutableTestCases;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Description;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import twc.android.app.pages.AirQualityCardContentScreen;
import twc.android.app.pages.FeedOneCardScreen;

import twc.Automation.Driver.Drivers;
import twc.Automation.General.DeviceStatus;
import twc.Automation.General.loginModule;
import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.HandleWithCharles.CharlesProxy;
import twc.Automation.ReadDataFromFile.read_excel_data;
import twc.Automation.ReadDataFromFile.read_xml_data_into_buffer;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import twc.Automation.Driver.Drivers;
import twc.Automation.General.loginModule;
import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;
import twc.Automation.General.Functions;
import twc.Automation.General.TwcAndroidBaseTest;
import twc.Automation.General.Utils;

public class RegressionTestCases extends  TwcAndroidBaseTest {
//	protected String email;
	public static String CurrentWifiName=null;
	
	private static final String CONFIG_FILE_PATH = "charles_common.config";
	private static final String BN_SEVERE1_CONFIG_FILE_PATH = "BNSevere1charles_common.config";
	private static final String BN_SEVERE2_CONFIG_FILE_PATH = "BNSevere2charles_common.config";
	// public static CharlesProxy proxy;
	public File configFile;
	private CharlesProxy proxy;



	@BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception {	
	this.configFile = this.charlesGeneralConfigFile(CONFIG_FILE_PATH);
	proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);
	proxy.startCharlesProxyWithUI();
	proxy.disableRewriting();
    proxy.stopRecording();
	proxy.disableMapLocal();
	proxy.startRecording();
	proxy.clearCharlesSession();
	AppiumFunctions.LaunchAppWithFullReset();
	Thread.sleep(90000);
	
}
	
	
	@Test(priority = 250,   enabled = true)
	@Description("Segment Parameter Verificatiion when background launch the app from hourly tab")
	public void seg_Parameter_Verification_When_Navigated_To_Hourly_Tab() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Segment Parameter Verificatiion when background launch the app from hourly tab test case Started");
		logStep("****** Segment Parameter Verificatiion when background launch the app from hourly tab test case Started");
		proxy.clearCharlesSession();
	 	AppFunctions.Kill_Launch_App();
		proxy.clearCharlesSession();
		CharlesFunctions.archive_folder("Charles");
		   AppFunctions.click_hourly_element();
		AppFunctions.Kill_Launch_App();
		proxy.getXml();
		Utils.createXMLFileForCharlesSessionFile();
		Utils.verify_Lotame_Call_Segment_Parameter("Smoke", "Lotame", "seg=Hourly");
	
	}
	
	@Test(priority = 251,   enabled = true)
	@Description("Segment Parameter Verificatiion when background launch the app from daily tab")
	public void seg_Parameter_Verification_When_Navigated_To_Daily_Tab() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Segment Parameter Verificatiion when background launch the app from daily tab test case Started");
		logStep("****** Segment Parameter Verificatiion when background launch the app from daily tab test case Started");
		proxy.clearCharlesSession();
		CharlesFunctions.archive_folder("Charles");
	Functions.clickdailydetails();
		 	AppFunctions.Kill_Launch_App();
		proxy.getXml();
		CharlesFunctions.createXMLFileForCharlesSessionFile();
		Utils.verify_Lotame_Call_Segment_Parameter("Smoke", "Lotame", "seg=Daily");

		
	
	}
	
	@Test(priority = 252,   enabled = true)
	@Description("Segment Parameter Verificatiion when background launch the app from radar tab")
	public void seg_Parameter_Verification_When_Navigated_To_Radar_Tab() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Segment Parameter Verificatiion when background launch the app from radar tab test case Started");
		logStep("****** Segment Parameter Verificatiion when background launch the app from radar tab test case Started");
		proxy.clearCharlesSession();
		CharlesFunctions.archive_folder("Charles");
		  AppFunctions.click_radar_element();
			AppFunctions.Kill_Launch_App();
		proxy.getXml();
		Utils.createXMLFileForCharlesSessionFile();
		Utils.verify_Lotame_Call_Segment_Parameter("Smoke", "Lotame", "seg=Radar");
	
	}
	
	@Test(priority = 253,   enabled = true)
	@Description("Segment Parameter Verificatiion when background launch the app from video tab")
	public void seg_Parameter_Verification_When_Navigated_To_Video_Tab() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Segment Parameter Verificatiion when background launch the app from video tab test case Started");
		logStep("****** Segment Parameter Verificatiion when background launch the app from video tab test case Started");
		proxy.clearCharlesSession();
		CharlesFunctions.archive_folder("Charles");
		  AppFunctions.click_video_element();
		  AppFunctions.Kill_Launch_App();
		proxy.getXml();
		Utils.createXMLFileForCharlesSessionFile();
		Utils.verify_Lotame_Call_Segment_Parameter("Smoke", "Lotame", "seg=Video");
	
	}
	
	
	/**
	 * This Script Enable preconfiguration for ThirdParty Tracking Pixe Into The AQ Details Page
	 * @throws Exception    
	 */
	@Test(priority = 1001, enabled = true)
	@Description("Enabling Preconfiguration for ThirdParty Tracking Pixel Into The AQ Details Page")
	public void enable_PreConfiguration_for_ThirdParty_Tracking_Pixel_Into_AQ_Details_Page() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Enable Preconfiguration for ThirdParty Tracking Pixel Into The AQ Details Page");
		logStep("Enable Preconfiguration for ThirdParty Tracking Pixel Into The AQ Details Page ");
		AppiumFunctions.clickOnHomeTab();
		AppFunctions.enterRequiredUserGroup("ANDFLAG-8424");
    AppFunctions.Kill_Launch_App();
		proxy.clearCharlesSession();
		CharlesFunctions.archive_folder("Charles");
		AppFunctions.waitForMilliSeconds(5000);
		AppFunctions.enter_requiredLocation("99833");
		AppFunctions.waitForMilliSeconds(20000);
		try {
		Utils.navigateTofeedCard("feedcard1");
		AppFunctions.waitForMilliSeconds(20000);
		FeedOneCardScreen.navigateToFeedOneCardContentPage();
			AirQualityCardContentScreen.waitForAirQualityCardContentPage();
			Functions.clickonBackbutton();
		
		} catch (Exception e) {
			System.out.println("There is an exception while navigting to feed1 card");
			logStep("There is an exception while navigting to feed1 card");
		} finally {
			proxy.getXml();
			Utils.createXMLFileForCharlesSessionFile();
		}
	}
	
	@Test(priority = 1002, enabled = true)
	@Description("Verify Third Party Pixel Call When Navigated to AQ Detaills Page From Feed1 Card")
	public void Verify_ThirdParty_Pixel_Call_When_Navigated_To_AQDetails_Page_From_Feed1_Card() throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== Third Party Pixel Call ====================");

		System.out.println("****** Third Party Pixel Call validation Started");
		logStep("****** Third Party Pixel Call validation Started");
		
AirQualityCardContentScreen.verifyPixel_Call_When_Navigated_To_AQDetails_Page_From_Feed1_Card("Smoke", "Air Quality(Content)");

	}
	
	/*Validata content URL Test cases*/
	
	
	
	

	

}
