/**
 * 
 */
package com.saucedemo.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.saucedemo.pages.LoginPage;

/**
 * @author vineetkothari
 *
 */
public class LoginAndAddToCartTest {

	String url = "";
	String username = "";
	String password = "";
	@Test(groups = {"SD"}, description = "Sauce Demo test case")
	public void verifyAddToCart() {
		if (System.getProperty("webdriver.chrome.driver") == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		}
		File conf = new File("src/test/resources/configuration.properties");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(conf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				if (line.startsWith("url="))
					url = line.substring(4);
				if (line.startsWith("username"))
					username = line.substring(9);
				if (line.startsWith("password"))
					password = line.substring(9);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		System.out.println("browsing to: "+url);
		LoginPage login = new LoginPage(driver);
		login.typeUserName(username);
		login.typePassword(password);
		login.clickSubmit();
		login.addOnesieToCart();
		login.addBikeLightToCart();
		login.goToCart();
		ArrayList<String> itemsInCart = new ArrayList<String>();
		itemsInCart = login.getCartItems();
		
		Assert.assertEquals(itemsInCart.get(0).toString(), "Sauce Labs Onesie", "Sauce Labs Onesei Found");
		Assert.assertEquals(itemsInCart.get(1).toString(), "Sauce Labs Bike Light", "Sauce Labs Onesei Found");
		
		driver.close();
	}	
	
}
