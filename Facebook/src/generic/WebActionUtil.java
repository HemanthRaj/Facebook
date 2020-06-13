package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebActionUtil
{	
	WebDriver driver;
	public WebActionUtil(WebDriver driver)
	{
		this.driver=driver;		
	}
	public long ETO=20;
	public void mouseHover(WebElement target) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
	}
	
	public void click(WebElement target) 
	{
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.elementToBeClickable(target)).isDisplayed();
		target.click();
	}
	
	public void enterData(WebElement target, String keysToSend)
	{
		target.sendKeys(keysToSend);
	}
	
	public void selectDropDownText(WebElement target, String text)
	{
		Select select = new Select(target);
		select.selectByVisibleText(text);
	}
}
