@login
Feature: Login SauceDemo

  @smoke-test
  Scenario: Login exitoso con standard_user
    Given el usuario navega al login
    When inicia sesion con usuario "standard_user" y password "secret_sauce"
    Then visualiza la pagina de productos

  @negative
  Scenario: Login fallido con usuario bloqueado
    Given el usuario navega al login
    When inicia sesion con usuario "locked_out_user" y password "secret_sauce"
    Then visualiza mensaje de usuario bloqueado