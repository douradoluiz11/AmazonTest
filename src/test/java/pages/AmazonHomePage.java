package pages;

import org.openqa.selenium.By;

public class AmazonHomePage {
	
	
	public static By SEARCH_BOX = By.id("twotabsearchtextbox");
    public static By AUTOCOMPLETE = By.xpath("//div[@class='left-pane-results-container']");
    public static By RESULTADO = By.xpath("//div/span[@class='a-color-state a-text-bold']");
    

}
