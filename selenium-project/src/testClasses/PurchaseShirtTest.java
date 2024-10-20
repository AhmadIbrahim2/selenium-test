package testClasses;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjec.Actions;
import pageObjec.Assertions;

@Listeners
public class PurchaseShirtTest {
	
	Actions action = new Actions();
	Assertions assertion = new Assertions();
	
	String productName = "shirt";
	String message = "Thank you for your purchase!";

	@BeforeSuite
	public void myBeforeTest() {
		
		//Maximize the screen of Browser
		action.maximizeWindow();
		
		//Visit the website
		action.visitWebsite();
		
		//Login to the website
		/*
		  action.clickOnSignInLink();
		  action.typeEmailInEmailInputField();
		  action.typePasswordInPasswordInputField();
		  action.clickOnSignInButton();
		*/
	}
	
	@Test(description = "End-to-End Purchase Flow for a Shirt Product")
	public void ProductCheckoutTest () throws InterruptedException{
		
		//Search for shirt products
		action.SearchProduct(productName);
		
		//Select a Product
		action.selectProductItem(1);
		
		//Choose product options size,color
		action.selectProductOptions();
		Thread.sleep(3000);
		
		//Click on Add to Cart Button
		action.clickOnAddToCartButton();
		Thread.sleep(3000);
		
		//Click on shopping cart icon
		action.clickOnShoppingCartIcon();
		
		//Click on Proceed to Checkout button
		action.clickOnProceedToCheckoutButton();
		Thread.sleep(3000);
		
		//Enter Email Address
		action.enterEmailAdress();
		
		//Enter first name
		action.enterFirstName("ahmad");
		
		//Enter last name
		action.enterLastName("ibrahim");
		
		//Enter street address 
		action.enterStreetAddress("jenin street");
		
		//Enter City
		action.enterCity("Jenin");
		
		//Enter postal code
		action.enterPostalCode("00972");
		
		//Select the country
		action.SelectCountry("Palestinian Territories");
		
		//Enter Phone number
		action.enterPhoneNumber("0594655333");
		Thread.sleep(3000);
		
		//Click on Next button
		action.clickOnNextButton();
		Thread.sleep(3000);
		
		//Click on Palce Order Button 
		action.clickOnPlaceOrderButton();
		Thread.sleep(3000);
		
		//Print order number on IDE console
		action.printOrderNumber();
		
		//Check the success of the purchase
		assertion.checkSuccessOfPurchase(message);
	}
	
	@AfterSuite
	public void myAfterTest() {
		action.CloseWindow();
	}
}
