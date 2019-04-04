/**
 * 
 */
package com.saucedemo.pages;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.locator.Locators;

/**
 * @author vineetkothari
 *
 */
public class LoginPage extends Locators {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeUserName(String username) {
		driver.findElement(By.cssSelector(USERNAME_TXTBOX)).sendKeys(username);
		System.out.println("Typed Username: "+username);
	}
	
	public void typePassword(String password) {
		driver.findElement(By.cssSelector(PASSWORD_TXTBOX)).sendKeys(password);
		System.out.println("Typed password");
	}
	
	public void clickSubmit() {
		driver.findElement(By.cssSelector(SUBMIT_BTN)).click();
		System.out.println("Clicked on submit button on login page");
	}

	public void addOnesieToCart() {
		driver.findElement(By.xpath(ONESIE_ADD_BTN)).click();
		System.out.println("Added: Sauce Labs Onesie to the cart");
	}

	public void addBikeLightToCart() {
		driver.findElement(By.xpath(BIKE_LIGHT_ADD_BTN)).click();
		System.out.println("Added Sauce Labs Bike Light to the cart");
	}

	public void goToCart() {
		driver.findElement(By.cssSelector(CART_BTN)).click();
		System.out.println("Click on cart icon");
	}

	public ArrayList<String> getCartItems() {
		ArrayList<String> items = new ArrayList<String>();
		
		for (int i =0; i<driver.findElements(By.cssSelector(CART_ITEMS_LIST)).size();i++) {
			items.add(driver.findElements(By.cssSelector(CART_ITEMS_LIST)).get(i).getText());
		}
		System.out.println(items);
		return items;
	}
}
