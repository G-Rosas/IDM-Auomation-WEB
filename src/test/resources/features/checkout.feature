@checkout
Feature: Checkout SauceDemo

  Background:
    Given el usuario inicia sesion correctamente

  @smoke-test
  Scenario Outline: Completar compra exitosamente
    When agrega el producto "<producto>" al carrito
    And completa el checkout
    Then visualiza mensaje de compra exitosa
    Examples:
      | producto                      |
      | Sauce Labs Backpack           |
      | Sauce Labs Bike Light         |
      | Sauce Labs Bolt T-Shirt       |