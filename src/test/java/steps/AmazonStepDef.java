package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actions.AmazonActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.AmazonHomePage;
import utils.DriverUtil;

public class AmazonStepDef {

	DriverUtil driver = new DriverUtil();
	AmazonActions actions = new AmazonActions();
	AmazonHomePage homePage = new AmazonHomePage();

	@Given("Abro o Navegador")
	public void abro_o_navegador() {
		driver.getDriver();
		driver.setViewportTablet();
	}

	@When("Acesso o Site {string}")
	public void acesso_o_site(String site) {
		driver.getUrl(site);
	}

	@When("no search box escrevo a palavra {string} e valido o autocomplete clicando em {string}")
	public void no_search_box_escrevo_a_palavra_e_valido_o_autocomplete_clicando_em(String produto, String autocomplete)
			throws InterruptedException {
		
		
		actions.escreve(homePage.SEARCH_BOX, produto);
		actions.esperaImplicita(15);
		actions.buscarElemento(autocomplete, homePage.AUTOCOMPLETE);
		
	}

	@Then("clico em pesquisar e valido o resultado na pagina de pesquisa {string}")
	public void clico_em_pesquisar_e_valido_o_resultado_na_pagina_de_pesquisa(String resultado) {

		assertEquals( "\"escova secadora\"",actions.retornaTexto(homePage.RESULTADO));
	}
	
	@Then("no search box escrevo a palavra {string} que não existe autocomplete para essa pesquisa {string}")
	public void no_search_box_escrevo_a_palavra_que_não_existe_autocomplete_para_essa_pesquisa(String produto, String autocomplete) throws InterruptedException {

		actions.escreve(homePage.SEARCH_BOX, produto);
		actions.esperaImplicita(15);
		actions.buscarElementoFalha(autocomplete, homePage.AUTOCOMPLETE);
		
	}


}
