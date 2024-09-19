package actions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverUtil;

public class AmazonActions {

	WebDriver driver = DriverUtil.getDriver();

	public void moverMouseParaCompra(By elemento) {

		Actions action = new Actions(DriverUtil.getDriver());
		WebElement perifericoElement = DriverUtil.getDriver().findElement(elemento);
		action.moveToElement(perifericoElement).perform();

	}

	public void find(By elemento) {

		driver.findElement(elemento);

	}

	public void click(By elemento) {

		driver.findElement(elemento).click();

	}

	public void escreve(By elemento, String txt) {

		driver.findElement(elemento).sendKeys(txt);

	}

	public void buscarElemento(String produtoDesejado, By lista) throws InterruptedException {

		try {
            

            // Localizar o elemento pai
            WebElement resultsContainer = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left-pane-results-container']")));

            // Encontrar o elemento com o texto "Escova de Dente"
            boolean encontrado = false;
            List<WebElement> listMarcas = resultsContainer.findElements(By.xpath(".//div[@class='s-suggestion-container']"));
            for (WebElement element : listMarcas) {
                String nomeProduto = element.getText();

                System.out.println("Produto: " + nomeProduto); // Imprime o nome do produto

                if (nomeProduto.equalsIgnoreCase(produtoDesejado)) {
                    System.out.println("Produto Correto: " + nomeProduto);
                    element.click(); // Clique no elemento encontrado
                    encontrado = true;
                    break; // Sai do loop se o produto for encontrado
                }
            }

            if (!encontrado) {
                System.out.println("Elemento 'Escova de Dente' não encontrado.");
            }

        } finally {
           
        }
		
	}
	
	
	public void  buscarElementoFalha (String produtoDesejado, By lista) throws InterruptedException {
		
		try {
		    // Localizar o elemento pai
		    WebElement resultsContainer = new WebDriverWait(driver, 10)
		            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left-pane-results-container']")));

		    // Encontrar o elemento com o texto "Escova de Dente"
		    List<WebElement> listMarcas = resultsContainer.findElements(By.xpath(".//div[@class='s-suggestion-container']"));
		    boolean encontrado = false;
		    for (WebElement element : listMarcas) {
		        String nomeProduto = element.getText();

		        System.out.println("Produto: " + nomeProduto); // Imprime o nome do produto

		        if (nomeProduto.equalsIgnoreCase(produtoDesejado)) {
		            System.out.println("Produto Correto: " + nomeProduto);
		            element.click(); // Clique no elemento encontrado
		            encontrado = true;
		            break; // Sai do loop se o produto for encontrado
		        }
		    }

		    // Verifica se o elemento foi encontrado
		    if (!encontrado) {
		        // Se o elemento não foi encontrado, o teste é considerado bem-sucedido
		        System.out.println("Elemento 'Escova de Dente' não encontrado. Teste bem-sucedido.");
		    } else {
		        // Se o elemento foi encontrado, o teste é considerado com falha
		        System.out.println("Elemento 'Escova de Dente' encontrado. Teste com falha.");
		    }

		} finally {
		    // ...
		}
	}
	public void esperaImplicita(int segundos) {

		DriverUtil.getDriver().manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);

	}

	public String retornaTexto (By elemento) {

		String selectElement = DriverUtil.getDriver().findElement(elemento).getText();
		
		String txt = selectElement.toString();
		
		return txt;

	}

}
