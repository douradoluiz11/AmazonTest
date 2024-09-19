#Author: Luiz Henrique Dourado Ferreira

@ValidaPesquisa
Feature: Pesquisa Amazon

  @Sucesso
  Scenario: Realizar pesquisa e validar autocomplete com sucesso
    Given Abro o Navegador
    And Acesso o Site "https://www.amazon.com.br/"
    When no search box escrevo a palavra "Escova" e valido o autocomplete clicando em "escova secadora"
    Then clico em pesquisar e valido o resultado na pagina de pesquisa "escova secadora"


  @Falha
  Scenario: Realizar pesquisa e validar autocomplete sem sucesso
    Given Abro o Navegador
    When Acesso o Site "https://www.amazon.com.br/"
    Then no search box escrevo a palavra "¨¨&¨%%S" que não existe autocomplete para essa pesquisa "¨¨&¨%%S"
    
 