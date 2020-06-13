package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtil
{
	public static String getValue(String path, String key)
	{
		String data="";
		try
		{
			FileInputStream fin = new FileInputStream(path);
			Properties p = new Properties();
			p.load(fin);
			data = p.getProperty(key);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	public static void getPhoto(WebDriver driver, String name)
	{
		String date=LocalDateTime.now().toString();
		date=date.replace(':', '-');
		TakesScreenshot t =(TakesScreenshot) driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest = new File(IAutoConstants.IMAGE_PATH+date+name+"1.png");
		try 
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
