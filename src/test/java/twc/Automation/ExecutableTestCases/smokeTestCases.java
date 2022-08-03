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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.twc.ios.app.general.TestBase;

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

public class smokeTestCases extends  TwcAndroidBaseTest {
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
	// Preconditions
	Functions.capabilities();
	Functions.Appium_Autostart();
	AppiumFunctions.LaunchAppWithFullReset();
	AppFunctions.gettingApkVersion() ;
}
	
	

	@AfterClass(alwaysRun = true)
	@Description("AfterClass")
	public void afterClass() throws Exception {
		System.out.println("****** After Class Started");
		logStep("****** After Class Started");	
		if (Ad != null) {		
				Ad.quit();
		System.out.println("****** Smoke Test Ended");
		logStep("****** Smoke Test Ended");
	}
	}
	@Test(priority = 2, enabled = true)
	@Description("Verifying Home screen marquee ad call on FTL")
	public void Smoke_Test_CaseVerify_Homescreen_marquee_adCall_FTL() throws Exception {
		System.out.println(
				"================= verifying iu value for home screen marquee test case started =========================");	
		System.out.println("going to all feed cards and details pages");
		logStep("going to all feed cards and details pages");	 		
		Thread.sleep(90000);
			Thread.sleep(90000);
		//AppiumFunctions.SwipeUp_Counter_feedcards(35);
			CharlesFunctions.archive_folder("Charles");
		this.proxy.getXml();
		CharlesFunctions.createXMLFileForCharlesSessionFile();
		Utils.verifyPubadCal("Smoke", "Marquee");
		System.out.println("================= verifying iu value for home screen marquee test case End =========================");				
	}
	
	
	 
	@Test(priority = 6, enabled = true)
	@Description("Verify Alert Center ad on My Alerts Page")
	public void Verify_AlertCenterAd() throws Exception {
		System.out.println("==============================================");
		System.out.println("===========================Aleret Center page Adcal iu====================");
		System.out.println("****** Alert Center ad test case Started");
		logStep("****** Alert Center ad test case Started");
		Utils.verifyPubadCal("Smoke", "MyAlerts");
	}
	

	@Test(priority = 8, enabled = true)
	@Description("Verifying feed_1 ad call on FTL")
	public void Smoke_Test_verifying_feed_1adcall_FTL() throws Exception {
		System.out.println("================= Verifying feed_1 ad call tescase Started =========================");
		Utils.verifyPubadCal("Smoke", "Feed1");
		System.out.println("================= Verifying feed_1 ad call tescase End =========================");
	}
	
	
	
	@Test(priority = 10, enabled = true)
	@Description("Verifying radar&maps details page ad call On FTL")
	public void Smoke_Test_Case_Verify_Radar_Maps_deatailspage_adCall_FTL() throws Exception {
		System.out.println(
				"================= verifying iu value for Radar&Maps deatail card started =========================");
		Utils.verifyPubadCal("Smoke", "Map");
		System.out.println(
				"================= verifying iu value for Radar&Maps deatail card  End =========================");
	}
	
	@Test(priority = 12, enabled = true)
	@Description("Verifying iu value Today details Page on FTL")
	public void Smoke_Test_CaseVerify_Today_details_page_iu_FTL() throws Exception {
		System.out.println(
				"================= verifying iu value for Today_details_page_iu started =========================");
		Utils.verifyPubadCal("Smoke", "Today",false);
		System.out.println(
				"================= verifying iu value for Today_details_page_iu End =========================");
	}
	
	
	@Test(priority = 14, enabled = true)
	@Description("Verifying  Air Quality content page ad call on FTL")
	public void Smoke_Test_Verify_Air_Quality_contentpage_adCall_FTL() throws Exception {
		System.out.println(
				"================= Verifying iu value for Air Quality content page testcase  started =========================");
		Utils.verifyPubadCal("Smoke", "Air Quality(Content)");
		System.out.println(
				"================= Verifying iu value for Air Quality content page testcase  End =========================");
	}
	
	@Test(priority = 16, enabled = true)
	@Description("Verify Safety And Preparedness Card iu")
	public void Verify_SafetyAndPreparednessCard_AdCall() throws Exception {
		System.out.println("==============================================");
		System.out.println("===========================Safety And Preparedness Card Adcal iu====================");

		System.out.println("****** Safety And Preparedness card ad test case Started");
		logStep("****** Safety And Preparedness card ad test case Started");
		Utils.verifyPubadCal("Smoke", "SafetyAndPreparedness");
	}
	
	@Test(priority = 18, enabled = true)
	@Description("Verifying  outdoor conditions  detailed page ad call on FTL")
	public void Smoke_Test_Verify_outdoor_detailpage_adcall_FTL() throws Exception {
		System.out
				.println("================= Verifying outdoor detailpage_adcall iu Started =========================");
		Utils.verifyPubadCal("Smoke", "SeasonalHub(Details)",false);
		System.out.println("================= Verifying outdoor detailpage adcall iu End =========================");
	}
	
    @Test(priority = 7, enabled = true)
	@Description("Verifying Running content page ad call  FTL")
	public void Smoke_Test_Verify_health_and_activities_Running_contenPage_adcall_FTL() throws Exception {
	System.out.println("================= Verify_health_and_activities_Running_contenPage_adcall_iu Started =========================");
		Utils.verifyPubadCal("Smoke", "Health(goRun)",false);
		System.out.println("================= Verify_health_and_activities_Running_contenPage_adcall_iu End =========================");
						
			}
    
    @Test(priority = 9, enabled = true)
	@Description("Verifying Boat&Beach content page ad call on FTL")
	public void Smoke_Test_Verify_health_and_activities_Bot_Beach_contenPage_adcall_FTL() throws Exception {
		System.out.println(
				"================= Verify_health_and_activities_Bot&beach_contenPage_adcall_iu Started =========================");
		Utils.verifyPubadCal("Smoke", "Health(boatAndBeach)",false);
	
		System.out.println(
				"================= Verify_health_and_activities_Bot&beach_contenPage_adcall_iu End =========================");
	}

    @Test(priority = 11, enabled = true)
	@Description("Verifying Cold&Flu content page ad call on FTL")
	public void Smoke_Test_Verify_health_and_activities_coldFlu_contenPage_adcall_FTL() throws Exception {
		System.out.println(
				"================= Verify_health_and_activities_coldFlu_contenPage_adcall_iu Started =========================");
		Utils.verifyPubadCal("Smoke", "Health(coldAndFlu)");
		System.out.println(
				"================= Verify_health_and_activities_coldFlu_contenPage_adcall_iu End =========================");
	}
    
    @Test(priority = 13, enabled = true)
	@Description("Verifying  Allergy content page ad call on FTL")
	public void Smoke_Test_Verify_health_and_activities_Allergy_contenPage_adcall_FTL() throws Exception {
		System.out.println(
				"================= Verify_health_and_activities_Allergy_contenPage_adcall_iu Started =========================");
		Utils.verifyPubadCal("Smoke", "allergycontentpage");
		System.out.println(
				"================= Verify_health_and_activities_Allergy_contenPage_adcall_iu End =========================");
	}
    
    @Test(priority = 16, enabled = true)
	@Description("Verifying pos custum param for Allergy spotlight ad call")
	public void Smoke_Test_Verify_health_and_activities_Allergy_spotlight_pos_custumparam() throws Exception {
		System.out.println(
				"================= Verify_health_and_activities_Allergy_spotlight_adcall_pos custumparam Started =========================");
		Utils.validate_custom_param_val_of_gampad("Smoke", "Health(allergy_spotlight)", "pos", "app_sl");
		System.out.println(
				"================= Verify_health_and_activities_Allergy_spotlight_adcall_pos custumparamEnd =========================");
	}
    
    
	@Test(priority = 18, enabled = true)
	@Description("Verifying iu value Covid details Page on FTL")
	public void Smoke_Test_CaseVerify_Covid_details_page_iu_FTL() throws Exception {
		System.out.println(
				"================= verifying iu value for Covid_details_page_iu started =========================");
		Utils.verifyPubadCal("Smoke", "Covid");
		System.out.println(
				"================= verifying iu value for Covid_details_page_iu End =========================");
	}
	
    
    @Test(priority = 68, enabled = true)
	@Description("Verifying sz value for Home screen marquee ad call on FTL")
	public void Smoke_Test_CaseVerify_sz_Homescreen_marquee_adCall_FTL() throws Exception {
		System.out.println(
				"================= verifying sz value for home screen marquee test case started =========================");	
		
		Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "sz", "360x180");

		System.out.println(
				"================= verifying sz value for home screen marquee test case End =========================");
	}
    
    @Test(priority = 72, enabled = true)
	@Description("Verify sz value for  Alert Center ad on My Alerts Page")
	public void Verify_sz_AlertCenterAd() throws Exception {
		System.out.println("==============================================");
		System.out.println("===========================Alert Center sz value ====================");
		logStep("****** Alert Center sz value test case Started");
		Utils.validate_Noncustom_param_val_of_gampad("Smoke", "MyAlerts", "sz", "320x50");
	}
    
    @Test(priority = 74, enabled = true)
	@Description("Verifying sz value for feed_1 ad call on FTL")
	public void Smoke_Test_verifying_sz_feed_1_adcall_FTL() throws Exception {
		System.out.println("================= Verifying sz value feed_1 ad call tescase Started =========================");
		Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "sz", "300x250%7C320x400");
		System.out.println("================= Verifying sz value feed_1 ad call tescase End =========================");
	}
    @Test(priority = 84, enabled = true)
	@Description("Verifying sz value for radar&maps details page ad call On FTL")
	public void Smoke_Test_Case_Verify_sz_Radar_Maps_deatailspage_adCall_FTL() throws Exception {
		System.out.println(
				"================= verifying sz  value for Radar&Maps deatail card started =========================");
		Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Map", "sz", "320x50");
		System.out.println(
				"================= verifying sz value for Radar&Maps deatail card  End =========================");
	}
    
    @Test(priority = 88, enabled = true)
	@Description("Verifying  sz value for Air Quality content page ad call on FTL")
	public void Smoke_Test_Verify_sz_AirQuality_contentpage_adCall_FTL() throws Exception {
		System.out.println(
				"================= Verifying sz value for Air Quality content page testcase  started =========================");
		Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Air Quality(Content)", "sz", "320x50");
		System.out.println(
				"================= Verifying sz value for Air Quality content page testcase  End =========================");
	}
    
    

	/* =======================================hourly details ad calls test cases started======================================================================================*/
	
	@Test(priority = 200, enabled = true)
	@Description("Verifying  hourly detailpage al call on FTL")
	public void Smoke_Test_Verify_hourly_detailpage_adcall_FTL() throws Exception {
		System.out.println("================= Verifying hourly_detailpage_adcall_iu test case  Started =========================");
		proxy.clearCharlesSession();
	   AppFunctions.click_hourly_element();
	   attachScreen();
	   AppFunctions.swipeinhourlydetailspage();
		CharlesFunctions.archive_folder("Charles");
		this.proxy.getXml();
	CharlesFunctions.createXMLFileForCharlesSessionFile();
      Utils.verifyPubadCal("Smoke", "Hourly");
		
		System.out.println("================= Verifying hourly_detailpage_adcall_iu  test case  End =========================");
	}
				
	@Test(priority = 202, enabled = true)
@Description("Verifying  hourly1  detailpage bigad ad call on FTL")
public void Smoke_Test_Verify_hourly1_detailpage_bigad_adcall_FTL() throws Exception {
System.out.println(
	"================= Verifying hourly1 big ad detailpage_adcall_iu  test case Started =========================");
Utils.verifyPubadCal("Smoke", "Hourly1");
System.out.println(
	"================= Verifying hourly1 big ad detailpage_adcall_iu test case  End =========================");
}

@Test(priority = 204, enabled = true)
@Description("Verifying  hourly2  detailpage bigad ad call on FTL")
public void Smoke_Test_Verify_hourly2_detailpage_bigad_adcall_FTL() throws Exception {
System.out.println(
	"================= Verifying hourly2 bigad detailpage_adcall_iu test case Started =========================");
Utils.verifyPubadCal("Smoke", "Hourly2");

System.out.println(
	"================= Verifying hourly2 bigad detailpage_adcall_iu test case End =========================");
}

@Test(priority = 206, enabled = true)
@Description("Verifying  hourly3  detailpage bigad ad call on FTL")
public void Smoke_Test_Verify_hourly3__bigad_detailpage_adcall_FTL() throws Exception {
System.out.println(
	"================= Verifying hourly3 bigad detailpage_adcall_iu test case  Started =========================");

Utils.verifyPubadCal("Smoke", "Hourly3");

System.out.println(
	"================= Verifying hourly3 bigad detailpage_adcall_iu test case  End =========================");
}


@Test(priority = 208, enabled = true)
@Description("Verifying sz value for  hourly detailpage al call on FTL")
public void Smoke_Test_Verify_sz_hourly_detailpage_adcall_FTL() throws Exception {
System.out.println("================= Verifying sz value for hourly detailpage adcall test case  Started =========================");
CharlesFunctions.createXMLFileForCharlesSessionFile();
Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "sz", "320x50");
System.out.println("================= Verifying sz value for hourly detailpage adcall test case End =========================");
}
	
@Test(priority = 210, enabled = true)
@Description("Verifying  sz value for hourly1  detailpage bigad ad call on FTL")
public void Smoke_Test_Verify_sz_hourly1_detailpage_bigad_adcall_FTL() throws Exception {
System.out.println(
	"================= Verifying sz value for hourly1 big ad detailpage adcall  test case Started =========================");
Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly1", "sz", "300x250");
System.out.println(
	"================= Verifying sz value for hourly1 big ad detailpage adcall  test case  End =========================");
}

@Test(priority = 212, enabled = true)
@Description("Verifying  sz value hourly2  detailpage bigad ad call on FTL")
public void Smoke_Test_Verify_sz_hourly2_detailpage_bigad_adcall_FTL() throws Exception {
System.out.println(
	"================= Verifying sz value for hourly2 bigad detailpage_adcall test case Started =========================");
Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly2", "sz", "300x250");
System.out.println(
	"================= Verifying sz value for hourly2 bigad detailpage_adcall test case End =========================");
}

@Test(priority = 214, enabled = true)
@Description("Verifying  sz value for hourly3  detailpage bigad ad call on FTL")
public void Smoke_Test_Verify_sz_hourly3__bigad_detailpage_adcall_FTL() throws Exception {
System.out.println(
	"================= Verifying sz value for hourly3 bigad detailpage_adcall test case  Started =========================");

Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly3", "sz", "300x250");

System.out.println(
	"================= Verifying sz value for hourly3 bigad detailpage_adcall test case  End =========================");
}
		 
		
@Test(priority = 250, enabled = true)
@Description("Verifying new daily details day1 ad call on FTL")
public void Smoke_Test_Verifying_newdailydetails_day1adcall_FTL() throws Exception {
	System.out.println(
			"================= Verifying new daily details day1 ad call tescase Started =========================");
	
	proxy.clearCharlesSession();	
	Functions.clickdailydetails();
	attachScreen();
	Thread.sleep(15000);
	Functions.verifyingdailydetrailsday1today7();
	this.proxy.getXml();
	CharlesFunctions.createXMLFileForCharlesSessionFile();
	Utils.verifyPubadCal("Smoke", "DailyDetails");
		
	System.out.println("=================  Verifying new daily details day1 ad call tescase  End =========================");
}
			 
			 /*
			  * This method validates fcnd custom parameter of daily details call
			  */
			  @Test(priority = 251, enabled = true)
			 @Description("Validating 'fcnd' custom parameter of daily details call ")
			 public void Validate_dailydetails_fcnd_Custom_param() throws Exception {
			 	System.out.println("==============================================");
			 	System.out.println("****** Validating fcnd custom parameter of daily details call");
			 	logStep("Validating fcnd custom parameter of daily details call ");
			 	Utils.validate_custom_param_val_of_gampad("Smoke", "DailyDetails", "fcnd", "NotNull");

			 }
			  
			  /*
			   * This method validates fcnd custom parameter of daily details call
			   */
			   @Test(priority = 252, enabled = true)
			  @Description("Validating 'dt' custom parameter of daily details call ")
			  public void Validate_dailydetails_dt_Custom_param() throws Exception {
			  	System.out.println("==============================================");
			  	System.out.println("****** Validating dt custom parameter of daily details call");
			  	logStep("Validating dt custom parameter of daily details call ");
			  	Utils.validate_custom_param_val_of_gampad("Smoke", "DailyDetails", "dt", "NotNull");
			  }

			   /*
			    * This method validates fcnd custom parameter of daily details call
			    */
			    @Test(priority = 253, enabled = true)
			   @Description("Validating 'mnth' custom parameter of daily details call ")
			   public void Validate_dailydetails_mnth_Custom_param() throws Exception {
			   	System.out.println("==============================================");
			   	System.out.println("****** Validating mnth custom parameter of daily details call");
			   	logStep("Validating mnth custom parameter of daily details call ");
			   	Utils.validate_custom_param_val_of_gampad("Smoke", "DailyDetails", "mnth", "NotNull");

			   }

			    
			    /*
			     * This method validates fcnd custom parameter of daily details call
			     */
			     @Test(priority = 254, enabled = true)
			    @Description("Validating 'dynght' custom parameter of daily details call ")
			    public void Validate_dailydetails_dynght_Custom_param() throws Exception {
			    	System.out.println("==============================================");
			    	System.out.println("****** Validating dynght custom parameter of daily details call");
			    	logStep("Validating dynght custom parameter of daily details call ");
			    	Utils.validate_custom_param_val_of_gampad("Smoke", "DailyDetails", "fdynght", "NotNull");

			    }

			     
			     @Test(priority = 257, enabled = true)
			     @Description("Verifying new daily details day2 ad call on FTL")
			     public void Smoke_Test_Verifying_newdailydetails_day2adcall_FTL() throws Exception {
			     System.out.println(
			     	"================= Verifying new daily details day2 ad call test case Started=========================");
			     CharlesFunctions.archive_folder("Charles");
			     proxy.clearCharlesSession();
			     Functions.clickonday2();
			     attachScreen();
			     Thread.sleep(10000);
			     Functions.verifyingdailydetrailsday1today7();
			     this.proxy.getXml();
			     CharlesFunctions.createXMLFileForCharlesSessionFile();
			     Utils.verifyPubadCal("Smoke", "DailyDetails");

			     System.out.println(
			     	"================= Verifying new daily details day2 ad call test case End =========================");
			     }

		

			     @Test(priority = 259, enabled = true)
			     @Description("Verifying sz value for new daily details day2 ad call on FTL")
			     public void Smoke_Test_sz_Verifying_newdailydetails_day2adcall_FTL() throws Exception {
			     System.out.println(
			     	"================= Verifying sz value for new daily details day2 ad call tescase Started =========================");

			     Utils.validate_Noncustom_param_val_of_gampad("Smoke", "DailyDetails", "sz", "360x210%7C300x250");
			     System.out.println(
			     	"=================  Verifying sz value for new daily details day2 ad call tescase  End =========================");
			     }

			     


			     @Test(priority = 260, enabled = true)
			     @Description("Verifying new daily details day3 ad call on FTL")
			     public void Smoke_Test_Verifying_newdailydetails_day3adcall_FTL() throws Exception {
			     System.out.println(
			     	"================= Verifying new daily details day3 ad call test case Started =========================");

			     CharlesFunctions.archive_folder("Charles");
			     proxy.clearCharlesSession();
			     //Functions.finding_newDailyBidadcall_day2();
			     Functions.clickonday3();
			     attachScreen();
			     Thread.sleep(10000);
			     Functions.verifyingdailydetrailsday1today7();
			     this.proxy.getXml();
			     CharlesFunctions.createXMLFileForCharlesSessionFile();
			     Utils.verifyPubadCal("Smoke", "DailyDetails");
			     System.out.println(
			     	"================= Verifying new daily details day3 ad call test case End =========================");
			     }

			     

			     @Test(priority = 262, enabled = true)
			     @Description("Verifying sz value for new daily details day3 ad call on FTL")
			     public void Smoke_Test_sz_Verifying_newdailydetails_day3adcall_FTL() throws Exception {
			     System.out.println(
			     	"================= Verifying sz value for new daily details day3 ad call tescase Started =========================");
              Utils.validate_Noncustom_param_val_of_gampad("Smoke", "DailyDetails", "sz", "360x210%7C300x250");
			     System.out.println(
			     	"=================  Verifying sz value for new daily details day3 ad call tescase  End =========================");
			     }


			     @Test(priority = 263, enabled = true)
			     @Description("Verifying new daily details day4 ad call on FTL")
			     public void Smoke_Test_Verifying_newdailydetails_day4adcall_FTL() throws Exception {
			     System.out.println(
			     	"================= Verifying new daily details day4 ad call tescase Started =========================");
			     CharlesFunctions.archive_folder("Charles");
			     proxy.clearCharlesSession();
			     Functions.clickonday4();
			     Thread.sleep(10000);
			     attachScreen();
			     Functions.verifyingdailydetrailsday1today7();
			     this.proxy.getXml();
			     CharlesFunctions.createXMLFileForCharlesSessionFile();
			     Utils.verifyPubadCal("Smoke", "DailyDetails");

			     System.out.println(
			     	"================= Verifying new daily details day4 ad call tescase End =========================");
			     }

			    

			     @Test(priority = 265, enabled = true)
			     @Description("Verifying sz value for new daily details day4 ad call on FTL")
			     public void Smoke_Test_sz_Verifying_newdailydetails_day4adcall_FTL() throws Exception {
			     System.out.println(
			     	"================= Verifying sz value for new daily details day4 ad call tescase Started =========================");

			     Utils.validate_Noncustom_param_val_of_gampad("Smoke", "DailyDetails", "sz", "360x210%7C300x250");
			     System.out.println(
			     	"=================  Verifying sz value for new daily details day4 ad call tescase  End =========================");
			     }



			     @Test(priority = 266, enabled = true)
			     @Description("Verifying new daily details day5 ad call on FTL")
			     public void Smoke_Test_Verifying_newdailydetails_day5adcall_FTL() throws Exception {
			     System.out.println(
			     	"================= Verifying new daily details day5 ad call tescase Started =========================");
			     CharlesFunctions.archive_folder("Charles");
			     proxy.clearCharlesSession();
			     Functions.clickonday5();
			     Thread.sleep(25000);
			     attachScreen();
			     Functions.verifyingdailydetrailsday1today7();
			     this.proxy.getXml();
			     CharlesFunctions.createXMLFileForCharlesSessionFile();
			     Utils.verifyPubadCal("Smoke", "DailyDetails");

			     System.out.println(
			     	"================= Verifying new daily details day5 ad call tescase End =========================");
			     }




			     @Test(priority = 268, enabled = true)
			     @Description("Verifying sz value for new daily details day5 ad call on FTL")
			     public void Smoke_Test_sz_Verifying_newdailydetails_day5adcall_FTL() throws Exception {
			     System.out.println(
			     	"================= Verifying sz value for new daily details day5 ad call tescase Started =========================");
			     Utils.validate_Noncustom_param_val_of_gampad("Smoke", "DailyDetails", "sz", "360x210%7C300x250");
			     System.out.println(
			     	"=================  Verifying sz value for new daily details day5 ad call tescase  End =========================");
			     }

			     @Test(priority = 270, enabled = true)
			     @Description("Verifying new daily details day6 ad call on FTL")
			     public void Smoke_Test_Verifying_newdailydetails_day6adcall_FTL() throws Exception {
			     	System.out.println(
			     			"================= Verifying new daily details day6 ad call tescase Started =========================");
			     	CharlesFunctions.archive_folder("Charles");
			     	proxy.clearCharlesSession();
			     	Functions.clickonday6();
			     	Thread.sleep(25000);
			     	attachScreen();
			     	Functions.verifyingdailydetrailsday1today7();
			     	this.proxy.getXml();
			     CharlesFunctions.createXMLFileForCharlesSessionFile();
			     Utils.verifyPubadCal("Smoke", "DailyDetails");
			     		
			     	System.out.println(
			     			"================= Verifying new daily details day6 ad call tescase End =========================");
			     }


			  

			     @Test(priority = 274, enabled = true)
			     @Description("Verifying sz value for new daily details day6 ad call on FTL")
			     public void Smoke_Test_sz_Verifying_newdailydetails_day6adcall_FTL() throws Exception {
			     	System.out.println(
			     			"================= Verifying sz value for new daily details day6 ad call tescase Started =========================");

			     	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "DailyDetails", "sz", "360x210%7C300x250");
			     	System.out.println(
			     			"=================  Verifying sz value for new daily details day6 ad call tescase  End =========================");
			     }



			     @Test(priority = 276, enabled = true)
			     @Description("Verifying new daily details day7 ad call on FTL")
			     public void Smoke_Test_Verifying_newdailydetails_day7adcall_FTL() throws Exception {
			     	System.out.println(
			     			"================= Verifying new daily details day7 ad call tescase Started =========================");
			     	CharlesFunctions.archive_folder("Charles");
			     	proxy.clearCharlesSession();
			     	Functions.clickonday7();
			     	Thread.sleep(25000);
			     	attachScreen();
			     	Functions.verifyingdailydetrailsday1today7();
			     	this.proxy.getXml();
			     CharlesFunctions.createXMLFileForCharlesSessionFile();
			     Utils.verifyPubadCal("Smoke", "DailyDetails");
			     	
			     	System.out.println(
			     			"================= Verifying new daily details day7 ad call tescase End =========================");
			     }
			     
			           @Test(priority = 280, enabled = true)
			           @Description("Verifying sz value for new daily details day7 ad call on FTL")
			           public void Smoke_Test_sz_Verifying_newdailydetails_day7adcall_FTL() throws Exception {
			           	System.out.println(
			           			"================= Verifying sz value for new daily details day7 ad call tescase Started =========================");

			           Utils.validate_Noncustom_param_val_of_gampad("Smoke", "DailyDetails", "sz", "360x210%7C300x250");
			           	System.out.println(
			           			"=================  Verifying sz value for new daily details day7 ad call tescase  End =========================");
			           }
	
    /* =======================================api  calls test cases started======================================================================================*/
    // Verifying Api and feed card and amazon aax prerol calls verification
    @Test(priority = 350, enabled = true)
    @Description("Verifying wfxtg trigger api call url on KillLaunch")
    public void Smoke_Test_CaseVerify_WeatherFXAPI_url_KillLaunch() throws Exception {
    	System.out.println("================= Verifying WeatherFX API url started =========================");
    	CharlesFunctions.archive_folder("Charles");
    	proxy.clearCharlesSession();
    	AppFunctions.Kill_Launch_App();
    	attachScreen();
       AppiumFunctions.ClickonIUnderstand();
    	Thread.sleep(25000);
    	Thread.sleep(125000);
    	attachScreen();
    	this.proxy.getXml();
    	CharlesFunctions.createXMLFileForCharlesSessionFile();
    	Utils.verifyAPICal("Smoke", "WFXTrigger",true);
    	System.out.println("================= Verifying WeatherFX API url End =========================");
    }

          @Test(priority =352,enabled = true)  
     @Description("Verifying Factual location.wfxtriggers.com api call supressing")  
    public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing() throws Exception {	  
     System.out. println("=================Verifying Factual location.wfxtriggers.com api call supressing =========================" ); 
    Utils.verifyAPICal("Smoke", "LocationWFX", false);
      System.out. println("================= Verifying Factual location.wfxtriggers.com api call supressing  =========================" );
      }

    @Test(priority = 354, enabled = true)
    @Description("Verifying turbo call api url on KillLaunch")
    public void Smoke_Test_CaseVerify_turbo_url_KillLaunch() throws Exception {
    	System.out.println("================= Verifying Turbo call  API url started =========================");
    	Utils.verifyAPICal("Smoke", "TurboApi",true);
    	System.out.println("================= Verifying Turbo call API url End =========================");
    }

      @Test(priority = 356, enabled = true)	  
      @Description("Verifying bcp.crwdcntrl call on killLaunch" )
      public void Smoke_Test__Verifying_Bcp_apicall_URL_killLaunch() throws  Exception { 
      logStep("Verifying bcp.crwdcntrl call" ); 
      System.out.println("=================Verifying  bcp.crwdcntrl call testcase started =========================");	  
  	Utils.verifyAPICal("Smoke", "Lotame", true);
      System.out.println("================= Verifying  bcp.crwdcntrl call testcase End =========================" );
      
      }
    	/* =======================================api calls test cases End======================================================================================*/

      
      
    	/* =======================================amazon preroll   ad calls test cases started======================================================================================*/
      
    @Test(priority = 358, enabled = true)
    @Description("Verifying amazon Slot Id for hourly details preroll ad call on killLaunch")
    public void Smoke_Test_amazon_aax_Hourly_preroll_adcall_killLaunch() throws Exception {
    	System.out.println(
    			"================= Verify amazon aax Hourly details preroll adcall Started =========================");

    	logStep(" Verifying preload amazon aax for  hourly details");
    	Utils.verifyAAX_SlotId("Smoke", "Hourly");
    	System.out.println(
    			"================= Verify amazon aax Hourly details preroll adcall End =========================");

    }

      @Test(priority =360, enabled = true)
    	@Description("Verifying amazon Slot Id for hourly1 big ad details preroll call on killLaunch")
    	public void Smoke_Test_amazon_aax_Hourly1_bigaddetails_preroll_adcall_killLaunch() throws Exception {
    		System.out.println(
    				"================= Verify amazon aax Hourly1 details big  adcall  test case Started =========================");
    		Utils.verifyAAX_SlotId("Smoke", "Hourly1");
    		System.out.println("================= Verify amazon aax Hourly1 big ad details  test case  End =========================");

    	}
    	


    	@Test(priority = 362, enabled = true)
    	@Description("Verifying amazon Slot Id for hourly2 big ad details preroll call on killLaunch")
    	public void Smoke_Test_amazon_aax_Hourly2_bigaddetails_preroll_adcall_killLaunch() throws Exception {
    		System.out.println(
    				"================= Verifying  amazon aax Hourly2 details big  adcall  test case Started =========================");
    		Utils.verifyAAX_SlotId("Smoke", "Hourly2");
    		System.out.println("================= Verifying  amazon aax Hourly2  big ad details  test case  End =========================");

    	}



    	@Test(priority = 364, enabled = true)
    	@Description("Verifying amazon Slot Id for hourly3 big ad details preroll call on killLaunch")
    	public void Smoke_Test_amazon_aax_Hourly3_bigaddetails_preroll_adcall_killLaunch() throws Exception {
    		System.out.println(
    				"================= Verify amazon aax Hourly3 details big  ad call test case  Started =========================");
    		Utils.verifyAAX_SlotId("Smoke", "Hourly3");
    		System.out.println("================= Verify amazon aax Hourly3 big ad call test case End =========================");
    	}
    	  


    @Test(priority = 366, enabled = true)
    @Description("Verifying amazon Slot Id for maps details preroll ad call on killLaunch")
    public void Smoke_Test_amazon_aax_mapsdetails_preload_adcall() throws Exception {
    	System.out.println(
    			"================= Verify amazon aax Maps card preroll adcall Started =========================");

    	logStep(" Verifying preload amazon aax for  map details");
    	Utils.verifyAAX_SlotId("Smoke", "Map");
    	System.out
    			.println("================= Verify amazon aax Maps card preroll adcall End =========================");

    }
     
    	@Test(priority = 368, enabled = true)
    	@Description("Verifying amazon Slot Id for feed1 prerol ad call on killLaunch")
    	public void Smoke_Test_amazon_aaxSlot_feed1_preroladcall_killLaunch() throws Exception {
    		System.out.println(
    				"================= Verify amazon aax slot  Id for feed1 prerol adcall  testcase Started =========================");
    		logStep(" Verifying amazon aax slot Id for feed1");
    		Utils.verifyAAX_SlotId("Smoke", "Feed1");
    		System.out.println(
    				"================= Verify amazon aax slot Id for feed1 prerol adcall testcase End =========================");

    	}
    @Test(priority = 370, enabled = true)
    @Description("Verifying amazon Slot Id  video ad call preload")
    public void Smoke_Test_amazon_aax_preload_video_adcall() throws Exception {
    	System.out.println("================= Verify amazon aax video adcall Started =========================");
    	logStep(" Verifying preload amazon aax for  video details");
    	Utils.verifyAAX_SlotId("Smoke", "PreRollVideo");
    	System.out.println("================= Verify amazon aax video  adcall End =========================");
    }


    @Test(priority = 374, enabled = true)
    @Description("Verifying amazon Slot Id for daily details preroll ad call")
    public void Smoke_Test_amazon_aax_Daily_details_preroll_adcall() throws Exception {
    	System.out.println(
    			"================= Verify amazon aax Daily details  preroll adcall Started =========================");
    	logStep(" Verifying preload amazon aax for  daily details");
    	Utils.verifyAAX_SlotId("Smoke", "DailyDetails");
    	System.out.println(
    			"================= Verify amazon aax Daily details preroll adcall End =========================");
    }
       
    
    /*
    * This method validates cmsid custom parameter of video call
    */
    @Test(priority = 600, enabled = true)
    @Description("Validating 'cmsid' custom parameter of Video call ")
    public void Validate_PreRollVideo_cmsid_Custom_param() throws Exception {
    System.out.println("==============================================");
    System.out.println("****** Validating cmsid custom parameter of Video call");
    logStep("Validating cmsid custom parameter of Video call ");
    proxy.clearCharlesSession();     
    AppiumFunctions.clickOnVideoElementt() ;
    Thread.sleep(80000);
	CharlesFunctions.archive_folder("Charles");
    this.proxy.getXml();
    CharlesFunctions.createXMLFileForCharlesSessionFile();
    Utils.validate_Noncustom_param_val_of_gampad("Smoke", "PreRollVideo", "cmsid", "NotNull");

    }

    /*
    * This method validates ttid custom parameter of video call
    */
    @Test(priority = 602, enabled = true)
    @Description("Validating 'ttid' custom parameter of Video call ")
    public void Validate_PreRollVideo_ttid_Custom_param() throws Exception {
    System.out.println("==============================================");
    System.out.println("****** Validating ttid custom parameter of Video call");
    logStep("Validating ttid custom parameter of Video call ");
    Utils.validate_Noncustom_param_val_of_gampad("Smoke", "PreRollVideo", "ttid", "NotNull");

    }

    /*
    * This method validates vid custom parameter of video call
    */
    @Test(priority = 604, enabled = true)
    @Description("Validating 'vid' custom parameter of Video call ")
    public void Validate_PreRollVideo_lnid_Custom_param() throws Exception {
    System.out.println("==============================================");
    System.out.println("****** Validating lnid custom parameter of Video call");
    logStep("Validating lnid custom parameter of Video call ");
    Utils.validate_Noncustom_param_val_of_gampad("Smoke", "PreRollVideo", "lnid",  "NotNull");

    }

    /*
    * This method validates vid custom parameter of video call
    */
    @Test(priority = 606, enabled = true)
    @Description("Validating 'vid' custom parameter of Video call ")
    public void Validate_PreRollVideo_vid_Custom_param() throws Exception {
    System.out.println("==============================================");
    System.out.println("****** Validating vid custom parameter of Video call");
    logStep("Validating vid custom parameter of Video call ");
    Utils.validate_Noncustom_param_val_of_gampad("Smoke", "PreRollVideo", "vid",  "NotNull");

    }


    /*
    * This method validates vid custom parameter of video call
    */
    @Test(priority = 608, enabled = true)
    @Description("Validating 'plist' custom parameter of Video call ")
    public void Validate_PreRollVideo_plist_Custom_param() throws Exception {
    System.out.println("==============================================");
    System.out.println("****** Validating plist custom parameter of Video call");
    logStep("Validating plist custom parameter of Video call ");
    Utils.validate_Noncustom_param_val_of_gampad("Smoke", "PreRollVideo", "plist", "NotNull");

    }

    /*
    * This method validates descritpion url of video call
    */
    @Test(priority = 610, enabled = true)
    @Description("Validating 'description url' of Video call ")
    public void Validate_PreRollVideo_description_url_Custom_param() throws Exception {
    System.out.println("==============================================");
    System.out.println("****** Validating description url of Video call");
    logStep("Validating description url of Video call ");
    Utils.validate_Noncustom_param_val_of_gampad("Smoke", "PreRollVideo", "description_url", "NotNull");

    }


    /*
    * This method validates descritpion url of video call
    */
    @Test(priority = 612, enabled = true)
    @Description("Validating 'content url' of Video call ")
    public void Validate_PreRollVideo_content_url_Custom_param() throws Exception {
    System.out.println("==============================================");
    System.out.println("****** Validating content url of Video call");
    logStep("Validating content url of Video call ");
    Utils.validate_Noncustom_param_val_of_gampad("Smoke", "PreRollVideo", "content_url", "NotNull");

    }


    /*
    * This method validates Google Interactive Media Ads SDK version i.e. IMA SDK
    */
    @Test(priority = 614, enabled = true)
    @Description("Validating Google Interactive Media Ads SDK version of Preroll video call ")
    public void Validate_IMA_SDK_version() throws Exception {
    System.out.println("==============================================");
    System.out.println("****** Validating Google Interactive Media Ads SDK version i.e. 'js' parameter of Preroll video call");
    logStep("Validating Google Interactive Media Ads SDK version i.e. 'js' parameter of Preroll video call");

    Utils.validate_Noncustom_param_val_of_gampad("Smoke", "PreRollVideo", "js", properties.getProperty("IMASDKVersion"));
    CharlesFunctions.archive_folder("Charles");

    }
    
    
    /*
     * This method validates wfxtg custom parameter of Hourly details call
     */
    @Test(priority = 3002, enabled = true)
    @Description("Validating 'wfxtg' custom parameter of Hourly details call ")
    public void Validate_Videos_wfxtg_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating wfxtg custom parameter of Hourly details call");
    	logStep("Validating wfxtg custom parameter of Hourly details call ");
    	//CharlesFunctions.createXMLFileForCharlesSessionFile();
    	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "wfxtg", "30124");

    }




/*
     * This method validates cxtg custom parameter of Hourly details call
     */
    @Test(priority = 3006, enabled = true)
    @Description("Validating 'cxtg' custom parameter of Hourly details call ")
    public void Validate_Videos_cxtg_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating cxtg custom parameter of Hourly details call");
    	logStep("Validating cxtg custom parameter of Hourly details call ");
    	//CharlesFunctions.createXMLFileForCharlesSessionFile();
    	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "cxtg", "30124");

    }




/*
     * This method validates zcs custom parameter of Hourly details call
     */
    @Test(priority = 3012, enabled = true)
    @Description("Validating 'zcs' custom parameter of Hourly details call ")
    public void Validate_Videos_zcs_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating zcs custom parameter of Hourly details call");
    	logStep("Validating zcs custom parameter of Hourly details call ");
    	Utils.validate_custom_param_val_of_gampad_with_zip( "Hourly", "zcs", "30124");

    }


/*
     * This method validates hzcs custom parameter of Hourly details call
     */
    @Test(priority = 3018, enabled = true)
    @Description("Validating 'hzcs' custom parameter of Hourly details call ")
    public void Validate_Videos_hzcs_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating hzcs custom parameter of Hourly details call");
    	logStep("Validating hzcs custom parameter of Hourly details call ");
    	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "hzcs", "30124");

    }



    
    
    
    
    
    /*
     * This method validates plat custom parameter of Marquee call
     */
    @Test(priority = 700, enabled = true)
    @Description("Validating 'plat' custom parameter of Marquee call ")
    public void Validate_Marquee_plat_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating plat custom parameter of Marquee call");
    	logStep("Validating plat custom parameter of Marquee call ");
    	proxy.clearCharlesSession();
       	AppFunctions.Kill_Launch_App();
    	Thread.sleep(30000);
    	Thread.sleep(100000);
            AppiumFunctions.SwipeUp_Counter(5);
     	   AppFunctions.click_hourly_element();
            Thread.sleep(30000);
            this.proxy.getXml();	
    	CharlesFunctions.createXMLFileForCharlesSessionFile();
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "plat", "wx_droid_phone");

    }

    /*
     * This method validates plat custom parameter of Feed1 call
     */
    @Test(priority = 702, enabled = true)
    @Description("Validating 'plat' custom parameter of Feed1 call ")
    public void Validate_Feed1_plat_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating plat custom parameter of Feed1 call");
    	logStep("Validating plat custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "plat", "wx_droid_phone");

    }

    /*
     * This method validates plat custom parameter of Hourly details call
     */
    @Test(priority = 704, enabled = true)
    @Description("Validating 'plat' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_plat_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating plat custom parameter of Hourly details call");
    	logStep("Validating plat custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "plat", "wx_droid_phone");

    }



    /*
     * This method validates pos custom parameter of Marquee call
     */
    @Test(priority = 706, enabled = true)
    @Description("Validating 'pos' custom parameter of Marquee call ")
    public void Validate_Marquee_pos_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating pos custom parameter of Marquee call");
    	logStep("Validating pos custom parameter of Marquee call ");
    	CharlesFunctions.createXMLFileForCharlesSessionFile();
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "pos", "top300");

    }

    /*
     * This method validates pos custom parameter of Feed1 call
     */
    @Test(priority = 708, enabled = true)
    @Description("Validating 'pos' custom parameter of Feed1 call ")
    public void Validate_Feed1_pos_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating pos custom parameter of Feed1 call");
    	logStep("Validating pos custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "pos", "top300");

    }

    /*
     * This method validates pos custom parameter of Hourly details call
     */
    @Test(priority = 710, enabled = true)
    @Description("Validating 'pos' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_pos_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating pos custom parameter of Hourly details call");
    	logStep("Validating pos custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "pos", "top300");

    }



    /*
     * This method validates tile custom parameter of Marquee call
     */
    @Test(priority = 706, enabled = true)
    @Description("Validating 'tile' custom parameter of Marquee call ")
    public void Validate_Marquee_tile_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating tile custom parameter of Marquee call");
    	logStep("Validating tile custom parameter of Marquee call ");
    	CharlesFunctions.createXMLFileForCharlesSessionFile();
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "tile", "1");

    }

    /*
     * This method validates tile custom parameter of Feed1 call
     */
    @Test(priority = 708, enabled = true)
    @Description("Validating 'tile' custom parameter of Feed1 call ")
    public void Validate_Feed1_tile_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating tile custom parameter of Feed1 call");
    	logStep("Validating tile custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "tile", "1");

    }

    /*
     * This method validates tile custom parameter of Hourly details call
     */
    @Test(priority = 710, enabled = true)
    @Description("Validating 'tile' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_tile_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating tile custom parameter of Hourly details call");
    	logStep("Validating tile custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "tile", "1");

    }




    /*
     * This method validates sod custom parameter of HomeScreen Today Call
     */
    @Test(priority = 712, enabled = true)
    @Description("Validating 'sod' custom parameter of marquee hour Call")
    public void validate_HomeScreen_marquee_sod_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating sod custom parameter of HomeScreen marqueeay call");
    	logStep("Validating sod custom parameter of HomeScreen marquee call");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "sod", "yes");
    }

    /*
     * This method validates sod custom parameter of Feed1 call
     */
    @Test(priority = 714, enabled = true)
    @Description("Validating 'sod' custom parameter of Feed1 call ")
    public void Validate_Feed1_sod_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating sod custom parameter of Feed1 call");
    	logStep("Validating sod custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "sod", "yes");

    }

    /*
     * This method validates sod custom parameter of Hourly details call
     */
    @Test(priority = 716, enabled = true)
    @Description("Validating 'sod' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_sod_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating sod custom parameter of Hourly Details call");
    	logStep("Validating sod custom parameter of Hourly Details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "sod", "yes");

    }


    /*
     * This method validates lang custom parameter of Marquee call
     */
    @Test(priority = 718, enabled = true)
    @Description("Validating 'lang' custom parameter of Marquee call ")
    public void Validate_Marquee_lang_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating lang custom parameter of Marquee call");
    	logStep("Validating lang custom parameter of Marquee call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "lang", "en");

    }

    /*
     * This method validates lang custom parameter of Feed1 call
     */
    @Test(priority = 720, enabled = true)
    @Description("Validating 'lang' custom parameter of Feed1 call ")
    public void Validate_Feed1_lang_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating lang custom parameter of Feed1 call");
    	logStep("Validating lang custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "lang", "en");

    }

    /*
     * This method validates lang custom parameter of Hourly details call
     */
    @Test(priority = 722, enabled = true)
    @Description("Validating 'lang' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_lang_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating lang custom parameter of Hourly details call");
    	logStep("Validating lang custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "lang", "en");

    }




    /*
     * This method validates DayNight custom parameter of Hourly details call
     */
    @Test(priority = 726, enabled = true)
    @Description("Validating 'tf' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_tf_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating tf custom parameter of Hourly details call");
    	logStep("Validating tf custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "tf", "hourly");

    }


    /*
     * This method validates DayNight custom parameter of Marquee call
     */
    @Test(priority = 734, enabled = true)
    @Description("Validating 'adid' custom parameter of Marquee call ")
    public void Validate_Marquee_adid_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating adid custom parameter of Marquee call");
    	logStep("Validating adid custom parameter of Marquee call ");

    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "adid", "NotNull");

    }


    /*
     * This method validates DayNight custom parameter of Feed1 call
     */
    @Test(priority = 736, enabled = true)
    @Description("Validating 'adid' custom parameter of Feed1 call ")
    public void Validate_Feed1_adid_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating adid custom parameter of Feed1 call");
    	logStep("Validating adid custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "adid", "NotNull");

    }

    /*
     * This method validates DayNight custom parameter of Hourly details call
     */
    @Test(priority = 738, enabled = true)
    @Description("Validating 'adid' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_adid_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating adid custom parameter of Hourly details call");
    	logStep("Validating adid custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "adid", "NotNull");

    }



    /*
     * This method validates DayNight custom parameter of Marquee call
     */
    @Test(priority = 740, enabled = true)
    @Description("Validating 'aid' custom parameter of Marquee call ")
    public void Validate_Marquee_aid_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating aid custom parameter of Marquee call");
    	logStep("Validating aid custom parameter of Marquee call ");

    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "aid", "NotNull");

    }


    /*
     * This method validates DayNight custom parameter of Feed1 call
     */
    @Test(priority = 742, enabled = true)
    @Description("Validating 'aid' custom parameter of Feed1 call ")
    public void Validate_Feed1_aid_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating adid custom parameter of Feed1 call");
    	logStep("Validating adid custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "aid", "NotNull");

    }

    /*
     * This method validates DayNight custom parameter of Hourly details call
     */
    @Test(priority = 746, enabled = true)
    @Description("Validating 'adid' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_aid_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating adid custom parameter of Hourly details call");
    	logStep("Validating adid custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "aid", "NotNull");

    }




    /*
     * This method validates ltv custom parameter of Marquee call
     */
    @Test(priority = 748, enabled = true)
    @Description("Validating 'ltv' custom parameter of Marquee call ")
    public void Validate_Marquee_ltv_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating ltv custom parameter of Marquee call");
    	logStep("Validating ltv custom parameter of Marquee call ");

    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "ltv", "NotNull");

    }


    /*
     * This method validates DayNight custom parameter of Feed1 call
     */
    @Test(priority = 750, enabled = true)
    @Description("Validating 'ltv' custom parameter of Feed1 call ")
    public void Validate_Feed1_ltv_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating ltv custom parameter of Feed1 call");
    	logStep("Validating ltv custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "ltv", "NotNull");

    }

    /*
     * This method validates DayNight custom parameter of Hourly details call
     */
    @Test(priority = 752, enabled = true)
    @Description("Validating 'ltv' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_ltv_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating ltv custom parameter of Hourly details call");
    	logStep("Validating ltv custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampadurl("Smoke", "Hourly", "ltv", "NotNull");

    }



    /*
     * This method validates ord custom parameter of Marquee call
     */
    @Test(priority = 754, enabled = true)
    @Description("Validating 'ord' custom parameter of Marquee call ")
    public void Validate_Marquee_ord_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating ord custom parameter of Marquee call");
    	logStep("Validating ord custom parameter of Marquee call ");

    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "ord", "NotNull");

    }


    /*
     * This method validates DayNight custom parameter of Feed1 call
     */
    @Test(priority = 756, enabled = true)
    @Description("Validating 'ord' custom parameter of Feed1 call ")
    public void Validate_Feed1_ord_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating ord custom parameter of Feed1 call");
    	logStep("Validating ord custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "ord", "NotNull");

    }

    /*
     * This method validates DayNight custom parameter of Hourly details call
     */
    @Test(priority = 758, enabled = true)
    @Description("Validating 'ord' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_ord_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating ord custom parameter of Hourly details call");
    	logStep("Validating ord custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "ord", "NotNull");

    }

    /*
     * This method validates ord custom parameter of Marquee call
     */
    @Test(priority = 760, enabled = true)
    @Description("Validating 'ver' custom parameter of Marquee call ")
    public void Validate_Marquee_ver_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating ver custom parameter of Marquee call");
    	logStep("Validating ver custom parameter of Marquee call ");

    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "ver", "NotNull");

    }


    /*
     * This method validates DayNight custom parameter of Feed1 call
     */
    @Test(priority = 762, enabled = true)
    @Description("Validating 'ver' custom parameter of Feed1 call ")
    public void Validate_Feed1_ver_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating ver custom parameter of Feed1 call");
    	logStep("Validating ver custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "ver", "NotNull");

    }

    /*
     * This method validates DayNight custom parameter of Hourly details call
     */
    @Test(priority = 764, enabled = true)
    @Description("Validating 'ver' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_ver_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating ver custom parameter of Hourly details call");
    	logStep("Validating ver custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "ver", "NotNull");

    }


    /*
     * This method validates ord custom parameter of Marquee call
     */
    @Test(priority = 766, enabled = true)
    @Description("Validating 'slotName' custom parameter of Marquee call ")
    public void Validate_Marquee_slotName_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating slotName custom parameter of Marquee call");
    	logStep("Validating slotName custom parameter of Marquee call ");

    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "slotName", "weather.next_gen_im");

    }



    @Test(priority = 768, enabled = true)
    @Description("Validating 'slotName' custom parameter of Feed1 call ")
    public void Validate_Feed1_slotName_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating slotName custom parameter of Feed1 call");
    	logStep("Validating slotName custom parameter of Feed1 call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Feed1", "slotName", "weather.feed2");

    }

    /*
     * This method validates DayNight custom parameter of Hourly details call
     */
    @Test(priority = 770, enabled = true)
    @Description("Validating 'slotName' custom parameter of Hourly details call ")
    public void Validate_HourlyDetails_slotName_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating slotName custom parameter of slotName details call");
    	logStep("Validating slotName custom parameter of Hourly details call ");
    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Hourly", "slotName", "weather.hourly");

    }

    /*
     * This method validates ord custom parameter of Marquee call
     */
    @Test(priority = 768, enabled = true)
    @Description("Validating 'im' custom parameter of Marquee call ")
    public void Validate_Marquee_im_Custom_param() throws Exception {
    	System.out.println("==============================================");
    	System.out.println("****** Validating im custom parameter of Marquee call");
    	logStep("Validating im custom parameter of Marquee call ");

    	Utils.validate_Noncustom_param_val_of_gampad("Smoke", "Marquee", "im", "y");


    }

	
			        /*
			         * This method validates cnd custom parameter of Marquee call
			         */
			        @Test(priority = 770, enabled = true)
			        @Description("Validating 'cnd' custom parameter of Marquee call ")
			        public void Validate_Marquee_cnd_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating cnd custom parameter of Marquee call");
			        	logStep("Validating cnd custom parameter of Marquee call ");
			        	CharlesFunctions.createXMLFileForCharlesSessionFile();
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "cnd");

			        }

			        /*
			         * This method validates cnd custom parameter of Feed1 call
			         */
			        @Test(priority = 772, enabled = true)
			        @Description("Validating 'cnd' custom parameter of Feed1 call ")
			        public void Validate_Feed1_cnd_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating cnd custom parameter of Feed1 call");
			        	logStep("Validating cnd custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "cnd");

			        }


			        /*
			         * This method validates cnd custom parameter of Hourly details call
			         */
			         @Test(priority = 774, enabled = true)
			        @Description("Validating 'cnd' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_cnd_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating cnd custom parameter of Hourly details call");
			        	logStep("Validating cnd custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "cnd");

			        }




			        /*
			         * This method validates dma custom parameter of Marquee call
			         */
			        @Test(priority = 776, enabled = true)
			        @Description("Validating 'dma' custom parameter of Marquee call ")
			        public void Validate_Marquee_dma_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating dma custom parameter of Marquee call");
			        	logStep("Validating dma custom parameter of Marquee call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "dma");

			        }

			        /*
			         * This method validates dma custom parameter of Feed1 call
			         */
			        @Test(priority = 778, enabled = true)
			        @Description("Validating 'dma' custom parameter of Feed1 call ")
			        public void Validate_Feed1_dma_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating dma custom parameter of Feed1 call");
			        	logStep("Validating dma custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "dma");

			        }

			        /*
			         * This method validates dma custom parameter of Hourly details call
			         */
			        @Test(priority = 780, enabled = true)
			        @Description("Validating 'dma' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_dma_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating dma custom parameter of Hourly details call");
			        	logStep("Validating dma custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "dma");

			        }




			        /*
			         * This method validates tmpc custom parameter of Marquee call
			         */
			        @Test(priority = 782, enabled = true)
			        @Description("Validating 'tmpc' custom parameter of Marquee call ")
			        public void Validate_Marquee_tmpc_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating tmpc custom parameter of Marquee call");
			        	logStep("Validating tmpc custom parameter of Marquee call ");
			        	//Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "tmpc");

			        }

			        /*
			         * This method validates tmpc custom parameter of Feed1 call
			         */
			        @Test(priority = 784, enabled = true)
			        @Description("Validating 'tmpc' custom parameter of Feed1 call ")
			        public void Validate_Feed1_tmpc_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating tmpc custom parameter of Feed1 call");
			        	logStep("Validating tmpc custom parameter of Feed1 call ");
			        	//Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "tmpc");

			        }

			        /*
			         * This method validates tmpc custom parameter of Hourly details call
			         */
			        @Test(priority = 786, enabled = true)
			        @Description("Validating 'tmpc' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_tmpc_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating tmpc custom parameter of Hourly details call");
			        	logStep("Validating tmpc custom parameter of Hourly details call ");
			        	//Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "tmpc");

			        }



			        /*
			         * This method validates ct custom parameter of Marquee call
			         */
			        @Test(priority = 788, enabled = true)
			        @Description("Validating 'ct' custom parameter of Marquee call ")
			        public void Validate_Marquee_ct_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ct custom parameter of Marquee call");
			        	logStep("Validating ct custom parameter of Marquee call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "ct");

			        }

			        /*
			         * This method validates ct custom parameter of Feed1 call
			         */
			        @Test(priority = 780, enabled = true)
			        @Description("Validating 'ct' custom parameter of Feed1 call ")
			        public void Validate_Feed1_ct_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ct custom parameter of Feed1 call");
			        	logStep("Validating ct custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "ct");

			        }


			        /*
			         * This method validates ct custom parameter of Hourly details call
			         */
			        @Test(priority = 782, enabled = true)
			        @Description("Validating 'ct' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_ct_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ct custom parameter of Hourly details call");
			        	logStep("Validating ct custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "ct");

			        }



			        /*
			         * This method validates locale custom parameter of Marquee call
			         */
			        @Test(priority = 786, enabled = true)
			        @Description("Validating 'locale' custom parameter of Marquee call ")
			        public void Validate_Marquee_locale_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating locale custom parameter of Marquee call");
			        	logStep("Validating locale custom parameter of Marquee call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "locale");

			        }

			        /*
			         * This method validates locale custom parameter of Feed1 call
			         */
			        @Test(priority = 788, enabled = true)
			        @Description("Validating 'locale' custom parameter of Feed1 call ")
			        public void Validate_Feed1_locale_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating locale custom parameter of Feed1 call");
			        	logStep("Validating locale custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "locale");

			        }

			        /*
			         * This method validates locale custom parameter of Hourly details call
			         */
			        @Test(priority = 790, enabled = true)
			        @Description("Validating 'locale' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_locale_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating locale custom parameter of Hourly details call");
			        	logStep("Validating locale custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "locale");

			        }

			        /*
			         * This method validates zip custom parameter of Marquee call
			         */
			        @Test(priority = 792, enabled = true)
			        @Description("Validating 'zip' custom parameter of Marquee call ")
			        public void Validate_Marquee_zip_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating zip custom parameter of Marquee call");
			        	logStep("Validating zip custom parameter of Marquee call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "zip");

			        }

			        /*
			         * This method validates zip custom parameter of Feed1 call
			         */
			        @Test(priority = 794, enabled = true)
			        @Description("Validating 'zip' custom parameter of Feed1 call ")
			        public void Validate_Feed1_zip_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating zip custom parameter of Feed1 call");
			        	logStep("Validating zip custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "zip");

			        }

			        /*
			         * This method validates zip custom parameter of Hourly details call
			         */
			        @Test(priority = 796, enabled = true)
			        @Description("Validating 'zip' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_zip_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating zip custom parameter of Hourly details call");
			        	logStep("Validating zip custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "zip");

			        }


			        /*
			         * This method validates tmp custom parameter of Marquee call
			         */
			        @Test(priority = 798, enabled = true)
			        @Description("Validating 'tmp' custom parameter of Marquee call ")
			        public void Validate_Marquee_tmp_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating tmp custom parameter of Marquee call");
			        	logStep("Validating tmp custom parameter of Marquee call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "tmp");

			        }

			        /*
			         * This method validates tmp custom parameter of Feed1 call
			         */
			        @Test(priority = 800, enabled = true)
			        @Description("Validating 'tmp' custom parameter of Feed1 call ")
			        public void Validate_Feed1_tmp_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating tmp custom parameter of Feed1 call");
			        	logStep("Validating tmp custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "tmp");

			        }

			        /*
			         * This method validates tmp custom parameter of Hourly details call
			         */
			        @Test(priority = 802, enabled = true)
			        @Description("Validating 'tmp' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_tmp_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating tmp custom parameter of Hourly details call");
			        	logStep("Validating tmp custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "tmp");

			        }

			        /*
			         * This method validates tmpr custom parameter of Marquee call
			         */
			        @Test(priority = 804, enabled = true)
			        @Description("Validating 'tmpr' custom parameter of Marquee call ")
			        public void Validate_Marquee_tmpr_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating tmpr custom parameter of Marquee call");
			        	logStep("Validating tmpr custom parameter of Marquee call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "tmpr");

			        }

			        /*
			         * This method validates tmpr custom parameter of Feed1 call
			         */
			        @Test(priority = 806, enabled = true)
			        @Description("Validating 'tmpr' custom parameter of Feed1 call ")
			        public void Validate_Feed1_tmpr_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating tmpr custom parameter of Feed1 call");
			        	logStep("Validating tmpr custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "tmpr");

			        }

			        /*
			         * This method validates tmpr custom parameter of Hourly details call
			         */
			        @Test(priority = 808, enabled = true)
			        @Description("Validating 'tmpr' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_tmpr_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating tmpr custom parameter of Hourly details call");
			        	logStep("Validating tmpr custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "tmpr");

			        }


			        /*
			         * This method validates dynght custom parameter of Marquee call
			         */
			        @Test(priority = 810, enabled = true)
			        @Description("Validating 'dynght' custom parameter of Marquee call ")
			        public void Validate_Marquee_dynght_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating dynght custom parameter of Marquee call");
			        	logStep("Validating dynght custom parameter of Marquee call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "dynght");

			        }

			        /*
			         * This method validates dynght custom parameter of Feed1 call
			         */
			        @Test(priority = 812, enabled = true)
			        @Description("Validating 'dynght' custom parameter of Feed1 call ")
			        public void Validate_Feed1_dynght_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating dynght custom parameter of Feed1 call");
			        	logStep("Validating dynght custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "dynght");

			        }

			        /*
			         * This method validates dynght custom parameter of Hourly details call
			         */
			        @Test(priority = 814, enabled = true)
			        @Description("Validating 'dynght' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_dynght_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating dynght custom parameter of Hourly details call");
			        	logStep("Validating dynght custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "dynght");

			        }



			        /*
			         * This method validates st custom parameter of Marquee call
			         */
			        @Test(priority = 816, enabled = true)
			        @Description("Validating 'st' custom parameter of Marquee call ")
			        public void Validate_Marquee_st_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating st custom parameter of Marquee call");
			        	logStep("Validating st custom parameter of Marquee call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "st");

			        }

			        /*
			         * This method validates st custom parameter of Feed1 call
			         */
			        @Test(priority = 818, enabled = true)
			        @Description("Validating 'st' custom parameter of Feed1 call ")
			        public void Validate_Feed1_st_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating st custom parameter of Feed1 call");
			        	logStep("Validating st custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "st");

			        }

			        /*
			         * This method validates st custom parameter of Hourly details call
			         */
			        @Test(priority = 820, enabled = true)
			        @Description("Validating 'st' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_st_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating st custom parameter of Hourly details call");
			        	logStep("Validating st custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "st");

			        }
			        			@Test(priority = 822, enabled = true)
			        @Description("Validating 'mr' custom parameter of Marquee call ")
			        public void Validate_Marquee_mr_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating mr custom parameter of Marquee call");
			        	logStep("Validating mr custom parameter of Marquee call ");

			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Marquee", "mr", "0");

			        }


			        @Test(priority = 824, enabled = true)
			        @Description("Validating 'mr' custom parameter of Feed1 call ")
			        public void Validate_Feed1_mr_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating mr custom parameter of Feed1 call");
			        	logStep("Validating mr custom parameter of Feed1 call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Feed1", "mr", "0");

			        }


			        @Test(priority = 826, enabled = true)
			        @Description("Validating 'mr' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_mr_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating mr custom parameter of Hourly details call");
			        	logStep("Validating mr custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad("Smoke", "Hourly", "mr", "0");
			        	

			        }
			        @Test(priority = 828, enabled = true)
			        @Description("Validating Google Mobile Ads SDK version of gampad call ")
			        public void Validate_GMA_SDK_version() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating Google Mobile Ads SDK Version i.e. 'js' parameter of gampad call");
			        	logStep("Validating Google Mobile Ads SDK Version i.e. 'js' parameter of gampad call");

			        Utils.validate_Noncustom_param_val_of_gampad( "Marquee", "js", properties.getProperty("GMASDKVersion"));


			        }
			        		
			        @Test(priority = 830, enabled = true)
			        @Description("Validating 'sdkVersion' parameter of Criteo SDK config app call ")
			        public void Validate_Criteo_SDK_config_app_Call_sdkVersion_parameter() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating 'sdkVersion' parameter of Criteo SDK config app call");
			        	logStep("****** Validating 'sdkVersion' parameter of Criteo SDK config app call");
			        Utils.validate_Criteo_SDK_config_app_call_parameter("Criteo", "sdkVersion", "4.6.0");

			        }


			        @Test(priority = 832, enabled = true)
			        @Description("Validating 'cpId' parameter of Criteo SDK config app call")
			        public void Validate_Criteo_SDK_config_app_Call_cpId_parameter() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating 'cpId' parameter of Criteo SDK config app call");
			        	logStep("****** Validating 'cpId' parameter of Criteo SDK config app call");
			        	Utils.validate_Criteo_SDK_config_app_call_parameter("Criteo", "cpId", "B-051673");

			        }
			        @Test(priority = 834, enabled = true)
			        @Description("Validating 'bundleId' parameter of Criteo SDK config app call ")
			        public void Validate_Criteo_SDK_config_app_Call_bundleId_parameter() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating 'bundleId' parameter of Criteo SDK config app call");
			        	logStep("****** Validating 'bundleId' parameter of Criteo SDK config app call");
			        	Utils.validate_Criteo_SDK_config_app_call_parameter("Criteo", "bundleId", "com.weather.Weather");

			        }

			        /*
			         * This method validates Criteo Bidder API (invapp v2) call response code
			         */
			        @Test(priority = 836, enabled = true)
			        @Description("Validating Criteo Bidder API (invapp v2) call response code")
			        public void Validate_Criteo_SDK_Bidder_API_Call_Response_Code() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating Criteo Bidder API (invapp v2) Call Response Code");
			        	logStep("****** Validating Criteo Bidder API (invapp v2) Call Response Code");
			        Utils.verifyCriteo_inapp_v2_Call_ReponseStatusCode("Smoke", "Criteo", "status","200");
			        }


			        /*
			         * This method validates Initialization API (config app) call response code
			         */
			        @Test(priority = 838, enabled = true)
			        @Description("Validating Criteo Initialization API (config app) call response code")
			        public void Validate_Criteo_SDK_Initialization_API_Call_Response_Code() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating Criteo Initialization API (config app) Call Response Code");
			        	logStep("****** Validating Criteo Initialization API (config app) Call Response Code");
			        	Utils.verifyCriteo_config_app_Call_ReponseStatusCode("Smoke", "Criteo", "status","200");
			        }


			        /*
			         * This method validates Initialization API (config app) call response parameter
			         * 'csmEnabled'
			         */
			        @Test(priority = 840, enabled = true)
			        @Description("Validating Criteo Initialization API (config app) call response parameter 'csmEnabled' value")
			        public void Validate_Criteo_SDK_Initialization_API_Call_Response_Parameter_csmEnabled() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println(
			        			"****** Validating csmEnabled parameter value in Criteo Initialization API (config app) Call Response");
			        	logStep("****** Validating csmEnabled parameter value in Criteo Initialization API (config app) Call Response");
			        	Utils.validate_Criteo_SDK_config_app_call_response_parameter("Smoke", "Criteo", "csmEnabled","true");
			        }

			        /*
			         * This method validates Initialization API (config app) call response parameter
			         * 'liveBiddingEnabled'
			         */
			        @Test(priority = 842, enabled = true)
			        @Description("Validating Criteo Initialization API (config app) call response parameter 'liveBiddingEnabled' value")
			        public void Validate_Criteo_SDK_Initialization_API_Call_Response_Parameter_liveBiddingEnabled() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println(
			        			"****** Validating liveBiddingEnabled parameter value in Criteo Initialization API (config app) Call Response");
			        logStep("****** Validating liveBiddingEnabled parameter value in Criteo Initialization API (config app) Call Response");
			        Utils.validate_Criteo_SDK_config_app_call_response_parameter("Smoke", "Criteo", "liveBiddingEnabled","false");
			        Thread.sleep(10000);
			        }
			        
			        
			        /*
			         * Enable Preconditions for WeatherFX API Parameters validation
			         */
			        @Test(priority = 3001, enabled = true)
			        @Description("Verify Enable Preconditions For WeatherFX API Parameters")
			        public void Verify_enable_preConditions_for_WeatherFx_API_Parameters() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Verify Enable Preconditions for WeatherFX API Parameters test started");
			        	logStep("Verify Enable Preconditions for WeatherFX API Parameters test started");
			        	
			        	proxy.clearCharlesSession();
			        	AppFunctions.Kill_Launch_App();
			        	Thread.sleep(2000);
			        	proxy.clearCharlesSession();
		      	AppFunctions.Kill_Launch_App();
			        	Thread.sleep(50000);
			        	// navigate to Hourly tab
			        	AppFunctions.click_hourly_element();
			        	Thread.sleep(2000);
			        	// navigate to Daily tab
			        	Functions.clickdailydetails();
			        	Thread.sleep(2000);
			        	// navigate to Radar tab
			        	AppiumFunctions.clickOnMaps();
			        	Thread.sleep(5000);
			        	CharlesFunctions.archive_folder("Charles");
			        	Thread.sleep(5000);
			        	proxy.getXml();
			        	CharlesFunctions.createXMLFileForCharlesSessionFile();

			        }



			        /*
			         * This method validates wfxtg custom parameter of Hourly details call
			         */
			        @Test(priority = 3002, enabled = true)
			        @Description("Validating 'wfxtg' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_wfxtg_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating wfxtg custom parameter of Hourly details call");
			        	logStep("Validating wfxtg custom parameter of Hourly details call ");
			        	//CharlesFunctions.createXMLFileForCharlesSessionFile();
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "wfxtg", "30124");

			        }

			        /*
			         * This method validates wfxtg custom parameter of Daily details call
			         */
			        @Test(priority = 3003, enabled = true)
			        @Description("Validating 'wfxtg' custom parameter of Daily details call ")
			        public void Validate_DailyDetails_wfxtg_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating wfxtg custom parameter of Daily details call");
			        	logStep("Validating wfxtg custom parameter of Daily details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Daily(10day)", "wfxtg", "30124");

			        }

			        /*
			         * This method validates wfxtg custom parameter of Map details call
			         */
			        @Test(priority = 3004, enabled = true)
			        @Description("Validating 'wfxtg' custom parameter of Map details call ")
			        public void Validate_MapDetails_wfxtg_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating wfxtg custom parameter of Map details call");
			        	logStep("Validating wfxtg custom parameter of Map details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Map", "wfxtg", "30124");

			        }

			        /*
			         * This method validates cxtg custom parameter of Hourly details call
			         */
			        @Test(priority = 3006, enabled = true)
			        @Description("Validating 'cxtg' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_cxtg_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating cxtg custom parameter of Hourly details call");
			        	logStep("Validating cxtg custom parameter of Hourly details call ");
			        	//CharlesFunctions.createXMLFileForCharlesSessionFile();
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "cxtg", "30124");

			        }

			        /*
			         * This method validates cxtg custom parameter of Daily details call
			         */
			        @Test(priority = 3008, enabled = true)
			        @Description("Validating 'cxtg' custom parameter of Daily details call ")
			        public void Validate_DailyDetails_cxtg_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating cxtg custom parameter of Daily details call");
			        	logStep("Validating cxtg custom parameter of Daily details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Daily(10day)", "cxtg", "30124");

			        }

			        /*
			         * This method validates wfxtg custom parameter of Map details call
			         */
			        @Test(priority = 3010, enabled = true)
			        @Description("Validating 'cxtg' custom parameter of Map details call ")
			        public void Validate_MapDetails_cxtg_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating cxtg custom parameter of Map details call");
			        	logStep("Validating cxtg custom parameter of Map details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Map", "cxtg", "30124");

			        }




			        /*
			         * This method validates zcs custom parameter of Hourly details call
			         */
			        @Test(priority = 3012, enabled = true)
			        @Description("Validating 'zcs' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_zcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating zcs custom parameter of Hourly details call");
			        	logStep("Validating zcs custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip( "Hourly", "zcs", "30124");

			        }

			        /*
			         * This method validates zcs custom parameter of Daily details call
			         */
			        @Test(priority = 3014, enabled = true)
			        @Description("Validating 'zcs' custom parameter of Daily details call ")
			        public void Validate_DailyDetails_zcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating zcs custom parameter of Daily details call");
			        	logStep("Validating zcs custom parameter of Daily details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Daily(10day)", "zcs", "30124");

			        }

			        /*
			         * This method validates zcs custom parameter of Map details call
			         */
			        @Test(priority = 3016, enabled = true)
			        @Description("Validating 'zcs' custom parameter of Map details call ")
			        public void Validate_MapDetails_zcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating zcs custom parameter of Map details call");
			        	logStep("Validating zcs custom parameter of Map details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Map", "zcs", "30124");

			        }

			        /*
			         * This method validates hzcs custom parameter of Hourly details call
			         */
			        @Test(priority = 3018, enabled = true)
			        @Description("Validating 'hzcs' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_hzcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating hzcs custom parameter of Hourly details call");
			        	logStep("Validating hzcs custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "hzcs", "30124");

			        }

			        /*
			         * This method validates hzcs custom parameter of Daily details call
			         */
			        @Test(priority = 3020, enabled = true)
			        @Description("Validating 'hzcs' custom parameter of Daily details call ")
			        public void Validate_DailyDetails_hzcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating hzcs custom parameter of Daily details call");
			        	logStep("Validating hzcs custom parameter of Daily details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Daily(10day)", "hzcs", "30124");

			        }

			        /*
			         * This method validates hzcs custom parameter of Map details call
			         */
			        @Test(priority = 3022, enabled = true)
			        @Description("Validating 'hzcs' custom parameter of Map details call ")
			        public void Validate_MapDetails_hzcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating hzcs custom parameter of Map details call");
			        	logStep("Validating hzcs custom parameter of Map details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Map", "hzcs", "30124");

			        }

			        /*
			         * This method validates nzcs custom parameter of Hourly details call
			         */
			        @Test(priority = 3024, enabled = true)
			        @Description("Validating 'nzcs' custom parameter of Hourly details call ")
			        public void Validate_HourlyDetails_nzcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating nzcs custom parameter of Hourly details call");
			        	logStep("Validating nzcs custom parameter of Hourly details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "nzcs", "30124");

			        }

			        /*
			         * This method validates nzcs custom parameter of Daily details call
			         */
			        @Test(priority = 3026, enabled = true)
			        @Description("Validating 'nzcs' custom parameter of Daily details call ")
			        public void Validate_DailyDetails_nzcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating nzcs custom parameter of Daily details call");
			        	logStep("Validating nzcs custom parameter of Daily details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Daily(10day)", "nzcs", "30124");

			        }

			        /*
			         * This method validates nzcs custom parameter of Map details call
			         */
			        @Test(priority = 3028, enabled = true)
			        @Description("Validating 'nzcs' custom parameter of Map details call ")
			        public void Valida0te_MapDetails_nzcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating nzcs custom parameter of Map details call");
			        	logStep("Validating nzcs custom parameter of Map details call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip( "Map", "nzcs", "30124");
			        		

			        }
			           
			        /*
			         * This method validates wfxtg custom parameter of Hourly details call
			         */
			        @Test(priority = 3002, enabled = true)
			        @Description("Validating 'wfxtg' custom parameter of home screen marquee call ")
			        public void Validate_HomescreenMarquee_wfxtg_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating wfxtg custom parameter of home screen marquee call");
			        	logStep("Validating wfxtg custom parameter of home screen marquee call ");
			        	//CharlesFunctions.createXMLFileForCharlesSessionFile();
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "wfxtg", "30124");

			        }

			        
			        /*
			         * This method validates cxtg custom parameter of Hourly details call
			         */
			        @Test(priority = 3006, enabled = true)
			        @Description("Validating 'cxtg' custom parameter of home screen marquee call ")
			        public void Validate_HomescreenMarquee_cxtg_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating cxtg custom parameter of HomescreenMarquee call");
			        	logStep("Validating cxtg custom parameter of HomescreenMarquee call ");
			        	//CharlesFunctions.createXMLFileForCharlesSessionFile();
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "cxtg", "30124");

			        }
			        

			        /*
			         * This method validates zcs custom parameter of Hourly details call
			         */
			        @Test(priority = 3012, enabled = true)
			        @Description("Validating 'zcs' custom parameter of home screen marquee call")
			        public void Validate_HomescreenMarquee_zcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating zcs custom parameter of HomescreenMarquee call");
			        	logStep("Validating zcs custom parameter of HomescreenMarquee  call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip( "Hourly", "zcs", "30124");

			        }
			        /*
			         * This method validates nzcs custom parameter of Hourly details call
			         */
			        @Test(priority = 3024, enabled = true)
			        @Description("Validating 'nzcs' custom parameter of home screen marquee call")
			        public void Validate_HomescreenMarquee_nzcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating nzcs custom parameter of HomescreenMarquee call");
			        	logStep("Validating nzcs custom parameter of HomescreenMarquee call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Hourly", "nzcs", "30124");

			        }

			        /*
			         * This method validates hzcs custom parameter of Map details call
			         */
			        @Test(priority = 3022, enabled = true)
			        @Description("Validating 'hzcs' custom parameter of home screen marquee call ")
			        public void Validate_HomescreenMarquee_hzcs_Custom_param() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating hzcs custom parameter of home screen marquee call");
			        	logStep("Validating hzcs custom parameter of home screen marquee call ");
			        	Utils.validate_custom_param_val_of_gampad_with_zip("Map", "hzcs", "30124");

			        }

			        
			        
			        @Test(priority = 270, enabled = true)
			    	@Description("Enable Preconditions to change region to de_DE")
			    	public void enable_preConditions_toChange_Region_for_de_DE() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** enable Preconditions to change region to de_DE test case Started");
			    		logStep("****** enable Preconditions to change region to de_DE test case Started");
			    		AppFunctions.resetApp();
			    		Functions.Appium_Autostart();
			    		CharlesFunctions.archive_folder("Charles");
			    		proxy.startRecording();
			    		proxy.clearCharlesSession();
			    		AppiumFunctions.launchtheApp_forLocalization("true", "de_DE", true, "de", true);
			    		System.out.println("App launched ");
			    		logStep("App launched ");
			    		proxy.getXml();
			    		CharlesFunctions.archive_folder("Charles");
			    		AppFunctions.Kill_Launch_App();
			    		proxy.clearCharlesSession();
			    		AppFunctions.Kill_Launch_App();;
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    	}

			    	@Test(priority = 271, enabled = true)
			    	@Description("Validating NextGen IM Call for de_DE")
			    	public void validate_NextGen_IM_call_for_de_DE() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** Validating NextGen IM Call for de_DE");
			    		logStep("Validating NextGen IM Call for de_DE");
			    		Utils.verifyPubadCal("iu=%2F3673%2Fm_app_droid_phone_wx%2Fdb_display%2Fhome_screen%2Fmarquee");
			    	
			    	}

			    	@Test(priority = 275, enabled = true)
			    	@Description("Enable Preconditions to change region to es_US")
			    	public void enable_preConditions_toChange_Region_for_es_US() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** enable Preconditions to change region to es_US test case Started");
			    		logStep("****** enable Preconditions to change region to es_US test case Started");
			    		AppFunctions.resetApp();
			    		Functions.Appium_Autostart();
			    		CharlesFunctions.archive_folder("Charles");
			    		proxy.startRecording();
			    		proxy.clearCharlesSession();
			    		AppiumFunctions.launchtheApp_forLocalization("true", "es_US", true, "es", true);
			    		System.out.println("App launched ");
			    		logStep("App launched ");
			    		proxy.getXml();
			    		CharlesFunctions.archive_folder("Charles");
			    		AppFunctions.Kill_Launch_App();
			    		proxy.clearCharlesSession();
			    		AppFunctions.Kill_Launch_App();
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    	}

			    	@Test(priority = 276, enabled = true)
			    	@Description("Validating NextGen IM Call for es_US")
			    	public void validate_NextGen_IM_call_for_es_US() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** Validating NextGen IM Call for es_US");
			    		logStep("Validating NextGen IM Call for es_US");

			    		Utils.verifyPubadCal("iu=%2F7646%2Fapp_android_us_es%2Fdb_display%2Fhome_screen%2Fmarquee");

			    	}

			    	@Test(priority = 280, enabled = true)
			    	@Description("Enable Preconditions to change region to hi_IN")
			    	public void enable_preConditions_toChange_Region_for_hi_IN() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** enable Preconditions to change region to hi_IN test case Started");
			    		logStep("****** enable Preconditions to change region to hi_IN test case Started");
			    	AppFunctions.resetApp();
			    		Functions.Appium_Autostart();
			    		CharlesFunctions.archive_folder("Charles");
			    		proxy.startRecording();
			    		proxy.clearCharlesSession();
			    		AppiumFunctions.launchtheApp_forLocalization("true", "hi_IN", true, "hi", true);
			    		System.out.println("App launched ");
			    		logStep("App launched ");
			    		proxy.getXml();
			    		CharlesFunctions.archive_folder("Charles");
			    		AppFunctions.Kill_Launch_App();
			    		proxy.clearCharlesSession();
			    		AppFunctions.Kill_Launch_App();	    		
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    	}

			    	@Test(priority = 281, enabled = true)
			    	@Description("Validating NextGen IM Call for hi_IN")
			    	public void validate_NextGen_IM_call_for_hi_IN() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** Validating NextGen IM Call for hi_IN");
			    		logStep("Validating NextGen IM Call for hi_IN");

			    		Utils.verifyPubadCal("iu=%2F7646%2Fapp_android_hi_in%2Fdb_display%2Fhome_screen%2Fmarquee");

			    	}

			    	@Test(priority = 285, enabled = true)
			    	@Description("Enable Preconditions to change region to en_IN")
			    	public void enable_preConditions_toChange_Region_for_en_IN() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** enable Preconditions to change region to en_IN test case Started");
			    		logStep("****** enable Preconditions to change region to en_IN test case Started");
			    		AppFunctions.resetApp();
			    		Functions.Appium_Autostart();
			    		CharlesFunctions.archive_folder("Charles");
			    		proxy.startRecording();
			    		proxy.clearCharlesSession();
			    		AppiumFunctions.launchtheApp_forLocalization("true", "en_IN", true, "en", false);
			    		System.out.println("App launched ");
			    		logStep("App launched ");
			    		proxy.getXml();
			    		CharlesFunctions.archive_folder("Charles");
			    		AppFunctions.Kill_Launch_App();	 
			    		proxy.clearCharlesSession();
			    		AppFunctions.Kill_Launch_App();	 
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    	}

			    	@Test(priority = 286, enabled = true)
			    	@Description("Validating NextGen IM Call for en_IN")
			    	public void validate_NextGen_IM_call_for_en_IN() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** Validating NextGen IM Call for en_IN");
			    		logStep("Validating NextGen IM Call for en_IN");

			    		Utils.verifyPubadCal("iu=%2F7646%2Fapp_android_en_in%2Fdb_display%2Fhome_screen%2Fmarquee");

			    	}
			    	
			    	@Test(priority = 290, enabled = true)
			    	@Description("Enable Preconditions to change region to en_GB")
			    	public void enable_preConditions_toChange_Region_for_en_GB() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** enable Preconditions to change region to en_GB test case Started");
			    		logStep("****** enable Preconditions to change region to en_GB test case Started");
			    		AppFunctions.resetApp();
			    		Functions.Appium_Autostart();
			    		CharlesFunctions.archive_folder("Charles");
			    		proxy.startRecording();
			    		proxy.clearCharlesSession();
			    		AppiumFunctions.launchtheApp_forLocalization("true", "en_GB", true, "en", false);
			    		System.out.println("App launched ");
			    		logStep("App launched ");
			    		proxy.getXml();
			    		CharlesFunctions.archive_folder("Charles");
			    		AppFunctions.Kill_Launch_App();	
			    		proxy.clearCharlesSession();
			    		AppFunctions.Kill_Launch_App();	
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    	}

			    	@Test(priority = 291, enabled = true)
			    	@Description("Validating NextGen IM Call for en_GB")
			    	public void validate_NextGen_IM_call_for_en_GB() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** Validating NextGen IM Call for en_GB");
			    		logStep("Validating NextGen IM Call for en_GB");

			    		Utils.verifyPubadCal("iu=%2F7646%2Fapp_android_intl%2Fdb_display%2Fhome_screen%2Fmarquee");

			    	}
			    	
			    	@Test(priority = 295, enabled = true)
			    	@Description("Enable Preconditions to change region to en_CA")
			    	public void enable_preConditions_toChange_Region_for_en_CA() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** enable Preconditions to change region to en_CA test case Started");
			    		logStep("****** enable Preconditions to change region to en_CA test case Started");
			    		AppFunctions.resetApp();
			    		Functions.Appium_Autostart();
			    		CharlesFunctions.archive_folder("Charles");
			    		proxy.startRecording();
			    		proxy.clearCharlesSession();
			    		AppiumFunctions.launchtheApp_forLocalization("true", "en_CA", true, "en", false);
			    		System.out.println("App launched ");
			    		logStep("App launched ");
			    		proxy.getXml();
			       		CharlesFunctions.archive_folder("Charles");
			      		AppFunctions.Kill_Launch_App();	
			    		proxy.clearCharlesSession();
			      		AppFunctions.Kill_Launch_App();	
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    	}

			    	@Test(priority = 296, enabled = true)
			    	@Description("Validating NextGen IM Call for en_CA")
			    	public void validate_NextGen_IM_call_for_en_CA() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** Validating NextGen IM Call for en_CA");
			    		logStep("Validating NextGen IM Call for en_CA");

			    		Utils.verifyPubadCal("iu=%2F7646%2Fapp_iphone_intl%2Fdb_display%2Fhome_screen%2Fmarquee");

			    	}
			    	
			    	@Test(priority = 300, enabled = true)
			    	@Description("Enable Preconditions to change region to fr_FR")
			    	public void enable_preConditions_toChange_Region_for_fr_FR() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** enable Preconditions to change region to fr_FR test case Started");
			    		logStep("****** enable Preconditions to change region to fr_FR test case Started");
			    	AppFunctions.resetApp();
			    		Functions.Appium_Autostart();
			    		CharlesFunctions.archive_folder("Charles");
			    		proxy.startRecording();
			    		proxy.clearCharlesSession();
			    		AppiumFunctions.launchtheApp_forLocalization("true", "fr_FR", true, "fr", true);
			    		System.out.println("App launched ");
			    		logStep("App launched ");
			    		proxy.getXml();
			    		CharlesFunctions.archive_folder("Charles");
			      		AppFunctions.Kill_Launch_App();	
			    		proxy.clearCharlesSession();
			      		AppFunctions.Kill_Launch_App();
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    	}

			    	@Test(priority = 301, enabled = true)
			    	@Description("Validating NextGen IM Call for fr_FR")
			    	public void validate_NextGen_IM_call_for_fr_FR() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** Validating NextGen IM Call for fr_FR");
			    		logStep("Validating NextGen IM Call for fr_FR");

			    		Utils.verifyPubadCal("iu=%2F7646%2Fapp_android_intl%2Fdb_display%2Fhome_screen%2Fmarquee");

			    	}
			    	
			    	@Test(priority = 305, enabled = true)
			    	@Description("Enable Preconditions for en_US")
			    	public void preConditionsTest_for_en_US() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** PreConditions For en_US test case Started");
			    		logStep("****** PreConditions For en_US test case Started");
			    		AppFunctions.resetApp();
			    		Functions.Appium_Autostart();
			    		CharlesFunctions.archive_folder("Charles");
			    		proxy.startRecording();
			    		proxy.clearCharlesSession();
			           AppiumFunctions.LaunchAppWithFullReset();
			    		System.out.println("App launched ");
			    		logStep("App launched ");
			      		AppFunctions.Kill_Launch_App();	
			    		proxy.clearCharlesSession();
			      		AppFunctions.Kill_Launch_App();	
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    	}

			    	@Test(priority = 306, enabled = true)
			    	@Description("Validating NextGen IM Call for en_US")
			    	public void validate_NextGen_IM_call_for_en_US() throws Exception {
			    		System.out.println("==============================================");
			    		System.out.println("****** Validating NextGen IM Call for en_US");
			    		logStep("Validating NextGen IM Call for en_US");

			    		Utils.verifyPubadCal("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee");

			    	}

	
	
	
			    	
			    	
			    	
			    	
			    	
			    	
			    	   /*
			         * This method validates st custom parameter of Marquee call
			         */
			        @Test(priority = 1000, enabled = true)
			        @Description("Preconditions for 'ContentUrl' for  test cases")
			        public void Preconditions_for_contetURl() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** preconditions for contentURL test cases");
			        	logStep("preconditions for contentURL test cases)";
			       		proxy.clearCharlesSession();	
			        	AppFunctions.Kill_Launch_App();
			    		CharlesFunctions.archive_folder("Charles");	    		
			    		Functions.waitForMilliSeconds(5000);
			    		hmTab.clickonHomeTab();	    		
			    		AppiumFunctions.SwipeUp_Counter_feedcards(35);
			    		proxy.getXml();
			    		CharlesFunctions.createXMLFileForCharlesSessionFile();
			    		Utils.getPlaceIdFromAPICall(Utils.placeId);		
		    		
			        }
			        
			        @Test(priority = 1002, enabled = true)
			        @Description("Validating 'ContentUrl' for Feed1 ad call ")
			        public void Validate_ContentUrl_for_Feed1_adcall() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ContentUrl for Feed1 adcall");
			        	logStep("Validating ContentUrl for Feed1 adcall");			        	
			        	Utils.validate_non_custom_param_val_in_gampad_url("Smoke", "Feed1", "content_url","https://www.weather.com");
			        }
			        
			        @Test(priority = 1004, enabled = true)
			        @Description("Validating 'ContentUrl' for maps details ad call ")
			        public void Validate_ContentUrl_for_mapsdetails_adcall() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ContentUrl for maps details adcall");
			        	logStep("Validating ContentUrl for maps details adcall");			        	
			        	Utils.validate_non_custom_param_val_in_gampad_url("Smoke", "Map", "content_url","https://weather.com/weather/radar/interactive/l/"+Utils.placeId);
			        }
			        
			        
			        @Test(priority = 1006, enabled = true)
			        @Description("Validating 'ContentUrl' for Hourly details ad call ")
			        public void Validate_ContentUrl_for_Hourlydetails_adcall() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ContentUrl for Hourly details adcall");
			        	logStep("Validating ContentUrl for Hourly details adcall");			      
			        	proxy.clearCharlesSession();
			    		Functions.archive_folder("Charles");
			    		hrTab.navigateToHourlyTab();
			    		AppFunctions.Swipe_Conter(5);
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    		Utils.getPlaceIdFromAPICall(Utils.placeId);	
			        	Utils.validate_non_custom_param_val_in_gampad_url("Smoke", "Hourly", "content_url","https://weather.com/weather/hourbyhour/l/"+Utils.placeId);
			        }
			        
			        @Test(priority = 1008, enabled = true)
			        @Description("Validating 'ContentUrl' for Hourly1 details big ad call ")
			        public void Validate_ContentUrl_for_Hourly1_details_bidadcall() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ContentUrl for Hourly1 details big adcall");
			        	logStep("Validating ContentUrl for Hourly details adcall");			      
			        	Utils.validate_non_custom_param_val_in_gampad_url("Smoke", "Hourly1", "content_url","https://weather.com/weather/hourbyhour/l/"+Utils.placeId);
			        }
			        
			        @Test(priority = 1010, enabled = true)
			        @Description("Validating 'ContentUrl' for Hourly2 details big ad call ")
			        public void Validate_ContentUrl_for_Hourly2_details_bidadcall() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ContentUrl for Hourly2 details big adcall");
			        	logStep("Validating ContentUrl for Hourly2 details big adcall");			      
			        	Utils.validate_non_custom_param_val_in_gampad_url("Smoke", "Hourly2", "content_url","https://weather.com/weather/hourbyhour/l/"+Utils.placeId);
			        }
			        
			        @Test(priority = 1012, enabled = true)
			        @Description("Validating 'ContentUrl' for Hourly3 details big ad call ")
			        public void Validate_ContentUrl_for_Hourly3_details_bidadcall() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ContentUrl for Hourly3 details big adcall");
			        	logStep("Validating ContentUrl for Hourly3 details big adcall");			      
			        	Utils.validate_non_custom_param_val_in_gampad_url("Smoke", "Hourly3", "content_url","https://weather.com/weather/hourbyhour/l/"+Utils.placeId);
			        }
			        
			      
			        
			        @Test(priority = 1014, enabled = true)
			        @Description("Validating 'ContentUrl' for daily details  ad call ")
			        public void Validate_ContentUrl_for_daily_details_adcall() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ContentUrl for daily details  adcall");
			        	logStep("Validating ContentUrl for daily details  adcall");		
			        	proxy.clearCharlesSession();
			    		Functions.archive_folder("Charles");
			    		dTab .navigateToDailyTab();
			    		proxy.getXml();
			    		Utils.createXMLFileForCharlesSessionFile();
			    		Utils.getPlaceIdFromAPICall(Utils.placeId);	
			        	Utils.validate_non_custom_param_val_in_gampad_url("Smoke", "Daily(10day)", "content_url","https://weather.com/weather/tenday/l/"+Utils.placeId);
			        }
			    	
	//validating ContentURL test cases//
			    	
			    	   /*
			         * This method validates st custom parameter of Marquee call
			         */
			        @Test(priority = 1016, enabled = true)
			        @Description("Validating 'ContentUrl' for Vidoes ad call ")
			        public void Validate_ContentUrl_for_Videos_adcall() throws Exception {
			        	System.out.println("==============================================");
			        	System.out.println("****** Validating ContentUrl for Vidoes call");
			        	logStep("Validating ContentUrl for Vidoes call");
			        	proxy.clearCharlesSession();
			    		CharlesFunctions.archive_folder("Charles");
			    		Functions.waitForMilliSeconds(5000);
			    		hmTab.clickonHomeTab();
			    		proxy.clearCharlesSession();
			    		// navigate to Video tab
			    		vTab.navigateToVideoTab(true, proxy);
			    		TestBase.waitForMilliSeconds(10000);
			    		proxy.getXml();
			    		CharlesFunctions.createXMLFileForCharlesSessionFile();
			    		Utils.getPlaceIdFromAPICall(Utils.placeId);		
			    		Utils.get_iu_value_of_Feedcall("Smoke", "PreRollVideo");
			    		Utils.validate_non_custom_param_val_in_gampad_url("Smoke", "PreRollVideo", "content_url","https://www.weather.com");
			    		
			        }
			        
			        

			       
			    	
			    	
			    	
			    	
	
	
			










}
