package pageObjec;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import support.Constants;

public class Actions implements Constants {
		
	//Maximze window action
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	//Visit website action
	public void visitWebsite() {
		driver.get("https://magento.softwaretestingboard.com/");
	}
	
	//Login Actions
	public void clickOnSignInLink() {
		driver.findElement(By.linkText("Sign In")).click();
	}
	
	public void typeEmailInEmailInputField() {
		driver.findElement(By.id("email")).sendKeys(email);
	}
	
	public void typePasswordInPasswordInputField() {
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		driver.findElement(By.id("send2")).click();
	}
	
	//Search for a product action
	public void SearchProduct(String product) {
		driver.findElement(By.id("search")).sendKeys(product+Keys.ENTER);
	}
	
	//Select a random product action
	public void selectProductItem(int index) {
		List<WebElement> items = driver.findElements(By.className("product-item-info"));
		WebElement selectedItem = items.get(index);
		selectedItem.click();
	}
	
	//Select the product options action
	public void selectProductOptions() {
		driver.findElement(By.id("option-label-size-143-item-167")).click();
		driver.findElement(By.id("option-label-color-93-item-53")).click();
	}
	
	//Click on Add to Cart Button action
	public void clickOnAddToCartButton() {
		WebElement element =  driver.findElement(By.id("product-addtocart-button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
	
	//Click on the shopping cart icon action
	public void clickOnShoppingCartIcon() {
		driver.findElement(By.className("showcart")).click();
	}
	
	//click on Proceed to Checkout button action
	public void clickOnProceedToCheckoutButton() {
		driver.findElement(By.id("top-cart-btn-checkout")).click();
	}
	
	//Enter Email Address action
	public void enterEmailAdress() {
		String randomEmail = generateRandomEmail();
		driver.findElement(By.id("customer-email")).sendKeys(randomEmail);
	}
	
	//Enter First Name action
	public void enterFirstName(String firstName) {
		driver.findElement(By.name("firstname")).sendKeys(firstName);
	}
	
	//Enter Last Name action
	public void enterLastName(String lastName) {
		driver.findElement(By.name("lastname")).sendKeys(lastName);
	}
	
	//Enter street address action
	public void enterStreetAddress(String streetAddress) {
		driver.findElement(By.name("street[0]")).sendKeys(streetAddress);
	}
	
	//Enter city action
	public void enterCity(String city) {
		driver.findElement(By.name("city")).sendKeys(city);
	}
	
	//Select state from dropdown action
	//public void selectState(String state) {
		//WebElement states = driver.findElement(By.name("region_id"));
		//Select option = new Select(states);
		//option.selectByVisibleText(state);
	//}
	
	//Enter postal code action
	public void enterPostalCode(String code) {
		driver.findElement(By.name("postcode")).sendKeys(code);
	}
	
	//Select country action
	public void SelectCountry(String countryName) {
		WebElement country = driver.findElement(By.name("country_id"));
		Select options = new Select(country);
		options.selectByVisibleText(countryName);
	}
	
	//Enter the phone number action
	public void enterPhoneNumber(String phoneNumber) {
		driver.findElement(By.name("telephone")).sendKeys(phoneNumber);
	}
	
	//Click on Next button action
	public void clickOnNextButton() {
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
	}
	
	//Click on Palce Order button action
	public void clickOnPlaceOrderButton() {
		driver.findElement(By.cssSelector(".action.primary.checkout")).click();
	}
	
	//Print order number action
	public void printOrderNumber() {
		WebElement order = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/span"));
		String orderNumber = order.getText();
		System.out.println("Order Number: "+orderNumber);
	}
	
	//Close the browser
	public void CloseWindow() {
		driver.close();
	}
	
}



