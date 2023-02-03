package SI.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class SingletonClass {
	
		private static SingletonClass instanceOfSingletonBrowserClass=null;

		private WebDriver driver1;

		private SingletonClass() {
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+
					"\\ChromeDriver\\geckodriver.exe");
			
			FirefoxProfile geoDisabled = new FirefoxProfile();
			geoDisabled.setPreference("geo.enabled", false);
			geoDisabled.setPreference("geo.provider.use_corelocation", false);
			geoDisabled.setPreference("geo.prompt.testing", false);
			geoDisabled.setPreference("geo.prompt.testing.allow", false);
			geoDisabled.setPreference("dom.webnotifications.enabled", false);
//			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//			capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
//			driver1 = new FirefoxDriver();
			
//			ProfilesIni profile = new ProfilesIni();
//			FirefoxProfile testprofile = profile.getProfile("debanjan");
//			testprofile.setPreference("dom.webnotifications.enabled", false);
//			testprofile.setPreference("dom.push.enabled", false);
//			
			
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("geo.enabled", false);
			options.addPreference("geo.provider.use_corelocation", false);
			options.addPreference("geo.prompt.testing", false);
			options.addPreference("geo.prompt.testing.allow", false);
			options.addPreference("dom.webnotifications.enabled", false);
//
			driver1 = new FirefoxDriver(options);
		}

		

		public static SingletonClass getInstanceOfSingletonBrowserClass(){

			if(instanceOfSingletonBrowserClass==null) {

				instanceOfSingletonBrowserClass=new SingletonClass();

			}

			return instanceOfSingletonBrowserClass;

		}

		public WebDriver getDriver() {

			return driver1;

		}
	
}
