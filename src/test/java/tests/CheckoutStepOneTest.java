package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.CartPage;
import com.Pages.CheckoutPage;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;

public class CheckoutStepOneTest extends BaseTest {

	@DataProvider(name = "details")
	public Object[][] checkoutData() {
		return new Object[][] {
				{ "standard_user", "secret_sauce", "", "testlastname", "M1L3K1", "Error: First Name is required" },
				{ "standard_user", "secret_sauce", "testfirstname", "", "M1L3K1", "Error: Last Name is required" },
				{ "standard_user", "secret_sauce", "testfirstname", "testlastname", "", "Error: Postal Code is required" }};
	}
	
	@DataProvider(name = "successfulInformation")
	public Object[][] successfulcheckoutData() {
		return new Object[][] {
				{ "standard_user", "secret_sauce", "testfirstname", "testlastname", "M1L3K1" }};
	}

	@Test(dataProvider = "details")
	public void validateFieldsInCheckoutPageStepOne(String username, String password, String firstname, String lastname,
			String zipcode, String errorMessage) {

		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		
		
		inventoryPage.clickOnSortDropdown();
		inventoryPage.clickOnDropdownThirdOption();
		
		inventoryPage.addProductFromFirstColumn();
		inventoryPage.addProductFromSecondColumn();
		inventoryPage.clickOnCartIcon();
		
				
		cartPage.clickOnCheckoutButton();
		
		
		checkoutPage.enterFirstName(firstname);
		checkoutPage.enterLastName(lastname);
		checkoutPage.enterZipCode(zipcode);
		checkoutPage.clickOnContinueButton();
		String errorNotification = checkoutPage.getErrorNotification();		
		
		Assert.assertEquals(errorNotification, errorMessage);
	}

	@Test(dataProvider = "successfulInformation")
	public void checkoutInformationSuccessful(String username, String password, String firstname, String lastname,
			String zipcode) {
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		
		inventoryPage.clickOnSortDropdown();
		inventoryPage.clickOnDropdownThirdOption();
		
		
		inventoryPage.addProductFromFirstColumn();
		inventoryPage.addProductFromSecondColumn();
		inventoryPage.clickOnCartIcon();

			
		cartPage.clickOnCheckoutButton();
		
		checkoutPage.enterFirstName(firstname);
		checkoutPage.enterLastName(lastname);
		checkoutPage.enterZipCode(zipcode);
		checkoutPage.clickOnContinueButton();
		
		
		String checkoutStepTwoTitle = checkoutPage.getCheckoutPageTwoTitleValue();
		Assert.assertEquals(checkoutStepTwoTitle, "Checkout: Overview");
	}
}
