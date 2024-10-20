package pageObjec;

import org.openqa.selenium.By;
import org.testng.Assert;

import support.Constants;

public class Assertions implements Constants {
	public void checkSuccessOfPurchase(String message) {
		Assert.assertEquals(driver.findElement(By.className("base")).getText(), message);
	}
}
