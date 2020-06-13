package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActionUtil;
public class ProductPage extends BasePage
{
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	@FindBy(xpath="//span[contains(.,'Continue shopping')]")
	private WebElement continueToShopping;
	
	@FindBy(className="cross")
	private WebElement closePopUp;
	
	@FindBy(name="Submit")
	private WebElement addToCartButton;
	
	@FindBy(className="icon-plus")
	private WebElement plusButton;
	
	@FindBy(className="icon-minus")
	private WebElement minusButton;
	
	@FindBy(id="group_1")
	private WebElement sizeDropDown;
	
	@FindBy(name="Beige")
	private WebElement colorBeige;
	
	@FindBy(name="Pink")
	private WebElement colorPink;
	
	public ProductPage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver, webActionUtil);
	}
	
	public void clickOnAddToCart()
	{
		webActionUtil.click(addToCartButton);
	}
	
	public void clickOnPlusButton(int count) {
		for(int i=1;i<=count;i++) {
			webActionUtil.click(plusButton);
		}
	}
	
	public void clickOnMinusButton(int count) {
		for(int i=1;i<=count;i++) {
			webActionUtil.click(minusButton);
		}
	}
	
	public void selectSize(String text)
	{
		webActionUtil.selectDropDownText(sizeDropDown, text);
	}
	
	public void selectCOlor(String color) {
		switch (color) {
		case "Beige":webActionUtil.click(colorBeige);
					 break;
		case "Pink":webActionUtil.click(colorPink);
					break;
		default: System.out.println("Color Not Found");
			break;
		}
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
