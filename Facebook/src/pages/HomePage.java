package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActionUtil;

public class HomePage extends BasePage
{
	@FindBy(id="selectProductSort")
	private WebElement sortDropDown;
	
	@FindBy(partialLinkText="Women")
	private WebElement women;
	
	@FindBy(xpath="(//a[text()='Dresses'])[2]")
	private WebElement dresses;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	private WebElement tshirts;
	
	@FindBy(xpath="//a[contains(.,'Cart')]")
	private WebElement cart;
	
	@FindBy(partialLinkText="Contact us")
	private WebElement contactUs;
	
	@FindBy(className="logout")
	private WebElement signOut;
	
	@FindBy(linkText="Grid")
	private WebElement grid;
	
	@FindBy(linkText="List")
	private WebElement list;
	
	@FindBy(linkText="Add to cart")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li")
	private List<WebElement> productList;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	@FindBy(xpath="//span[contains(.,'Continue shopping')]")
	private WebElement continueToShopping;
	
	@FindBy(className="cross")
	private WebElement closePopUp;
	
	@FindBy(xpath="(//span[text()='More'])[2]")
	private WebElement more;
	
	public HomePage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver, webActionUtil);
	}
	
	public boolean allTabsDisplayed()
	{
		return women.isDisplayed() && dresses.isDisplayed() && tshirts.isDisplayed()
				&& cart.isDisplayed() && contactUs.isDisplayed() && signOut.isDisplayed();
	}
	
	public void clickWomen()
	{
		women.click();
	}
	
	public void clickDresses()
	{
		dresses.click();
	}
	
	public void clickTshirts()
	{
		tshirts.click();
	}
	
	public void clickCart()
	{
		cart.click();
	}
	
	public void clickContactUs()
	{
		contactUs.click();
	}
	
	public void clickLogout()
	{
		signOut.click();
	}
	
	public void clickOnAddToCart()
	{
		webActionUtil.click(addToCartButton);
	}
	
	public ProductPage clickOnMore()
	{
		webActionUtil.click(more);
		return new ProductPage(driver, webActionUtil);
	}
	
	public void clickGrid()
	{
		grid.click();
	}
	
	public void clickList()
	{
		list.click();
	}
	
	public void selectProduct(String id)
	{
		for(WebElement product:productList)
		{
			if(product.findElement(By.tagName("a")).getAttribute("href").contains(id))
			{
				webActionUtil.mouseHover(product);
			}
		}
	}
	
	public WebElement getDropDown()
	{
		return sortDropDown;
	}
	
	public void clickOnClosePopUp()
	{
		webActionUtil.click(closePopUp);
	}
	
	public OrderPage clickOnProceedToCheckOut()
	{
		webActionUtil.click(proceedToCheckOut);
		return new OrderPage(driver, webActionUtil);
	}
	
	public void clickOnContinueShopping()
	{
		webActionUtil.click(continueToShopping);
	}
	
}
