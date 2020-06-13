package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.WebActionUtil;
public class LoginPage extends BasePage
{
	@FindBy(partialLinkText="Sign in")
	private WebElement signIn;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver, webActionUtil);
	}
	
	
	public void login(String un, String pwd)
	{
		signIn.click();
		email.clear();
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
	}
}
