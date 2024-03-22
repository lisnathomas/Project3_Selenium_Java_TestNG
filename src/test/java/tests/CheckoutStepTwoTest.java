package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.CartPage;
import com.Pages.CheckoutPage;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;

public class CheckoutStepTwoTest extends BaseTest{

	@DataProvider(name = "successfulInformation")
	public Object[][] successfulcheckoutData() {
		return new Object[][] {
				{ "standard_user", "secret_sauce", "testfirstname", "testlastname", "M1L3K1" }};
	}
	
	@Test(dataProvider = "successfulInformation")
	public void checkIfPriceAndPaymentMatchesExpectedValueAfterCheckout(String username, String password, String firstname, String lastname,
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
		
		String checkoutStepPaymentInformation = checkoutPage.getPaymentInformation();
		Assert.assertEquals(checkoutStepPaymentInformation, "SauceCard #31337");
		System.out.println("Payment information matches expected value");
		
		String checkoutPriceTotal = checkoutPage.getPriceTotal();
		String[] checkoutTotal = checkoutPriceTotal.split(": ");
		Assert.assertEquals(checkoutTotal[1], "$34.54");
		System.out.println("Total price matches the expected value");
	}

	@Test(dataProvider = "successfulInformation")
	public void checkIfOrderPlaced(String username, String password, String firstname, String lastname,
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
		checkoutPage.clickOnFinishButton();
		String orderPlacedText = checkoutPage.getCompleteOrderText();
		Assert.assertEquals(orderPlacedText, "Thank you for your order!");
		
	}
	
	@Test(dataProvider = "successfulInformation")
	public void checkIfUserLogoutAfterPlacingOrder(String username, String password, String firstname, String lastname,
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
		checkoutPage.clickOnFinishButton();
		loginPage.clickLogoutButton();
		String loginLogo=loginPage.getLoginLogoText();	
		Assert.assertEquals(loginLogo, "Swag Labs");
		
	}

}
