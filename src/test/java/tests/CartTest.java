package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.CartPage;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;

public class CartTest extends BaseTest {

	@DataProvider(name = "successfulLogin")
	public Object[][] loginData() {
		return new Object[][] { { "standard_user", "secret_sauce" } };
	}

	@Test(dataProvider ="successfulLogin")
	public void testIfRightProductsAddedToCart(String username, String password)
	{
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		

		inventoryPage.clickOnSortDropdown();
		inventoryPage.clickOnDropdownThirdOption();
		
		inventoryPage.addProductFromFirstColumn();
		inventoryPage.addProductFromSecondColumn();
		inventoryPage.clickOnCartIcon();
		
		
		List<String> listOfProducts = cartPage.getTempListOfProductsAddedToCompare();
		List<WebElement> listOfProductsFromWebsite = cartPage.getListOfProductsAddedFromWebsite();
		boolean isTheRightProductAdded = cartPage.compare(listOfProducts, listOfProductsFromWebsite);
		
		Assert.assertTrue(isTheRightProductAdded, "Right product not added to cart");
		
		cartPage.clickOnCheckoutButton();
		System.out.println("Checkout button clicked successfully");
	}
	
}
