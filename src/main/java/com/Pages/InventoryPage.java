package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
	WebDriver driver;
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickOnSortDropdown() {
		WebElement sortDropdown = driver.findElement(By.xpath("//span[@class='select_container']"));
		sortDropdown.click();
	}
	public String getDropdownThirdOption() {
		return driver.findElement(By.xpath("//select[@class='product_sort_container']/option[3]")).getText();
	}
	public void clickOnDropdownThirdOption() {
		 driver.findElement(By.xpath("//select[@class='product_sort_container']/option[3]")).click();
	}
	
	public void addProductFromFirstColumn() {
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
	}
	
	public void addProductFromSecondColumn() {
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
	}
	public int getCartCountFromShoppingCartBadge() {
		WebElement cartItem = driver.findElement(By.className("shopping_cart_badge"));
		int cartItemCount = Integer.parseInt(cartItem.getText());
		if (cartItemCount == 2) {
			System.out.println("Products added to cart successfully!");
			
		} else {
			System.out.println("Error adding products to cart.");
		}
		return cartItemCount;
	}
	public void clickOnCartIcon() {
		WebElement cartItem = driver.findElement(By.className("shopping_cart_badge"));
		cartItem.click();
	}
	
}
