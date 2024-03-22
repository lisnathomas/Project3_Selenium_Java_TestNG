package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.InventoryPage;
import com.Pages.LoginPage;

public class InventoryTest extends BaseTest {

	
	
	@DataProvider(name = "successfulLogin")
	public Object[][] loginData() {
		return new Object[][] { { "standard_user", "secret_sauce" } };
	}

	@Test(dataProvider = "successfulLogin")
	public void testIfUserIsRedirectedToInventoryPage(String username, String password) {

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();

		System.out.println("User logged in successfully");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@Test(dataProvider = "successfulLogin")
	public void testSortByPriceLowToHigh(String username, String password) {

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		

		inventoryPage.clickOnSortDropdown();
		String dropdownOptionThirdValue = inventoryPage.getDropdownThirdOption();
		
		Assert.assertEquals(dropdownOptionThirdValue, "Price (low to high)");
		inventoryPage.clickOnDropdownThirdOption();
		System.out.println("Sort Dropdown Value clicked successfully");
	}
	
	
	@Test(dataProvider = "successfulLogin")
	public void testIfBothItemsAreAddedToCart(String username, String password) {

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		
		inventoryPage.clickOnSortDropdown();	
		inventoryPage.clickOnDropdownThirdOption();
		
		inventoryPage.addProductFromFirstColumn();
		inventoryPage.addProductFromSecondColumn();
		int itemsInCart = inventoryPage.getCartCountFromShoppingCartBadge();
		Assert.assertEquals(itemsInCart, 2);
	}
}
