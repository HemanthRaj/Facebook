package generic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.HomePage;
import pages.LoginPage;

public class BaseTest implements IAutoConstants
{
	public WebDriver driver;
	public WebActionUtil webActionUtil;
	public long ITO = 20, ETO = 20;
	
	@Parameters({"browserName","appUrl", "strITO"})
	@BeforeClass
	public void launchApp(@Optional(BROWSER_NAME) String browserName,
			@Optional(APP_URL) String appUrl,
			@Optional(IMPLICITTIMEOUT)String strITO)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		}
		else
		{
			throw new IllegalArgumentException("Browser not Supported");
		}
		driver.manage().window().maximize();
		long time = Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		driver.get(appUrl);
		webActionUtil = new WebActionUtil(driver);
	}
	
	@Parameters({"username", "password"})
	@BeforeMethod
	public void signInToApp(@Optional(USERNAME) String username,
			@Optional(PASSWORD)String password)
	{
		Reporter.log("From signInToApp", true);
		LoginPage l = new LoginPage(driver, webActionUtil);
		l.login(username, password);
	}
	
	@AfterMethod
	public void signOutFromApp(ITestResult result)
	{
		int status = result.getStatus();
		String testMethodName = result.getName();
		if(status == 2)
		{
			AutoUtil.getPhoto(driver, testMethodName);
		}
		HomePage home = new HomePage(driver, webActionUtil);
		try
		{
			home.clickLogout();
		}
		catch(Exception e) 
		{
			
		}
	}
	
	@AfterClass(alwaysRun=true)
	public void closeApp()
	{
		driver.quit();
	}
}
