package scripts;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;
public class TC002 extends BaseTest
{
	@Test
	public void loginPageElementsCheck() throws InterruptedException
	{
		HomePage all = new HomePage(driver, webActionUtil);
		Assert.assertTrue(all.allTabsDisplayed());
		all.clickDresses();
		all.selectProduct("4");
		ProductPage product = all.clickOnMore();
		product.clickOnPlusButton(4);
		product.clickOnMinusButton(1);
		product.selectCOlor("Pink");
		product.selectSize("L");
		product.clickOnAddToCart();
		OrderPage op =product.clickOnProceedToCheckOut();
		Assert.assertTrue(op.verifyProductDisplayed("4"));
	}
}
