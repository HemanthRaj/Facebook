package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActionUtil;

public class OrderPage extends BasePage
{
	@FindBy(xpath="//tbody/tr")
	private List<WebElement> productsInCart;
	
	public boolean verifyProductDisplayed(String id)
	{
		for(WebElement product:productsInCart)
		{
			return product.findElement(By.tagName("a")).getAttribute("href").contains("id");
		}
		return false;
	}
	public OrderPage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver, webActionUtil);
	}
}
