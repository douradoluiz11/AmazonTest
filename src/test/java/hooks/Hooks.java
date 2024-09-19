package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;

public class Hooks {
	
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    @Before
	    public void beforeScenario(Scenario scenario) {
	        driver.set(new ChromeDriver());
	    }

	    @After
	    public void afterScenario(Scenario scenario) {
	        if (scenario.isFailed()) {
	            takeScreenshot(scenario);
	        }
	        driver.get().quit();
	        driver.remove();
	    }

	    @Attachment(value = "Screenshot", type = "image/png")
	    public byte[] takeScreenshot(Scenario scenario) {
	        return ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
	    }

}
