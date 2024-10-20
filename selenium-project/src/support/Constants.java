package support;

import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface Constants {
	
	WebDriver driver = new ChromeDriver();
	
	String email = "ahmadalshak57@gmail.com";
	String password = "Ahmad0592";
	
	default String generateRandomEmail() {
        return "testuser" + UUID.randomUUID().toString().substring(0, 3) + "@gmail.com";
    }
}

