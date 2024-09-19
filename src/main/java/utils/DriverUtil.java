package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {
	
public static WebDriver driver;
	

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		return driver;
	}


	public static void killDrivers() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public static String getUrl(String url) {
		
		getDriver().get(url);
		
		return url;
	}
	
	// Método para definir o tamanho da tela
    public static void setViewport(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    // Métodos para definir tamanhos de tela pré-definidos
    public static void setViewportDesktop() {
        setViewport(1920, 1080); // Tamanho de tela padrão para desktop
    }

    public static void setViewportTablet() {
        setViewport(1024, 768); // Tamanho de tela padrão para tablet
    }

    public static void setViewportMobile() {
        setViewport(375, 667); // Tamanho de tela padrão para mobile
    }

}
