package twc.android.app.pages;

import org.openqa.selenium.By;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import twc.Automation.General.Functions;

public class FeedOneCardScreen extends Functions {
	
	static AppiumDriver<MobileElement> Ad;
	static String feedOneCardAd_Id = "weather.feed0-adContainerView";
	String snapshotLogo_AccessibilityId = "SnapshotLogo";
	String buttonClose_AccessibilityId  = "button close";
	
	static By byFeedOneCardAd = MobileBy.id(feedOneCardAd_Id);
	By bySnapshotLogo = MobileBy.AccessibilityId(snapshotLogo_AccessibilityId);
	By byButtonClose = MobileBy.AccessibilityId(buttonClose_AccessibilityId);
	

	static MobileElement feedOneCardAd = null;
	MobileElement snapshotLogo = null;
	MobileElement buttonClose = null;

	public FeedOneCardScreen(AppiumDriver<MobileElement> Ad) {
		this.Ad = Ad;
	}

	@Step("Navigate To FeedOne Card Content Page")
	public static void navigateToFeedOneCardContentPage() throws Exception {

		feedOneCardAd = Ad.findElement(byFeedOneCardAd);
		Functions.clickOnElement(byFeedOneCardAd, feedOneCardAd, "FeedOneCard Ad");
		Thread.sleep(6000);
		attachScreen();
	}

}
