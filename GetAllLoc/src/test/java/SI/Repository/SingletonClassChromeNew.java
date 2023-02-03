package SI.Repository;

import java.util.HashMap;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


public class SingletonClassChromeNew {
	
		private static SingletonClassChromeNew instanceOfSingletonBrowserClass=null;

		private WebDriver driver2;

		private SingletonClassChromeNew() {

			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\test\\java\\SI\\Repository\\SingletonClassChromeNew.java");
			String downloadFilepath = System.getProperty("user.dir")+ "\\downloadedfiles";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1 );
//			 options.setHeadless(true);
		        // https://stackoverflow.com/a/43840128/1689770
//		    options.addArguments("--headless","--window-size=1920,1080"); 
			options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
	        options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
//	        options.addArguments("--headless"); // only if you are ACTUALLY running headless
	        options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
	        options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
	        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
	        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
	        options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
	        options.addArguments("enable-features=NetworkServiceInProcess");
	        options.addArguments("disable-features=NetworkService");
	        options.addArguments("--force-device-scale-factor=1");
	        options.addArguments("--disable-notifications");
			driver2 = new ChromeDriver(options);
			
//			System.setProperty("webdriver.gecko.driver",
//					"D:\\GeekoDriver\\geckodriver.exe");
//			FirefoxProfile geoDisabled = new FirefoxProfile();
//			geoDisabled.setPreference("geo.enabled", false);
//			geoDisabled.setPreference("geo.provider.use_corelocation", false);
//			geoDisabled.setPreference("geo.prompt.testing", false);
//			geoDisabled.setPreference("geo.prompt.testing.allow", false);
//			geoDisabled.setPreference("dom.webnotifications.enabled", false);
//			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//			capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
//			driver = new FirefoxDriver();
			
//			ProfilesIni profile = new ProfilesIni();
//			FirefoxProfile testprofile = profile.getProfile("debanjan");
//			testprofile.setPreference("dom.webnotifications.enabled", false);
//			testprofile.setPreference("dom.push.enabled", false);
//			DesiredCapabilities dc = DesiredCapabilities.firefox();
//			dc.setCapability(FirefoxDriver.PROFILE, testprofile);
//			FirefoxOptions opt = new FirefoxOptions();
//			opt.merge(dc);
//			driver =  new FirefoxDriver(opt);
//			
			
			
//			FirefoxOptions options = new FirefoxOptions();
//			options.setProfile(new FirefoxProfile());
//			options.addPreference("geo.enabled", false);
//			options.addPreference("geo.provider.use_corelocation", false);
//			options.addPreference("geo.prompt.testing", false);
//			options.addPreference("geo.prompt.testing.allow", false);
//			options.addPreference("dom.webnotifications.enabled", false);
//
//			driver = new FirefoxDriver(options);
		}

		public static SingletonClassChromeNew getInstanceOfSingletonBrowserClass(){

			if(instanceOfSingletonBrowserClass==null) {

				instanceOfSingletonBrowserClass=new SingletonClassChromeNew();

			}

			return instanceOfSingletonBrowserClass;

		}

		public WebDriver getDriver() {

			return driver2;

		}
	
}
