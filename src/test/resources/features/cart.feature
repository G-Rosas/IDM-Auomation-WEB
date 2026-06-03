@cart
Feature: Carrito de compras

  Background:
    Given el usuario inicia sesion correctamente

  @smoke-test @regresion
  Scenario: Agregar productos al carrito
    When agrega el producto "Sauce Labs Backpack" al carrito
    And agrega el producto "Sauce Labs Bike Light" al carrito
    And agrega el producto "Sauce Labs Bolt T-Shirt" al carrito
    Then el carrito muestra 3 productos
    And navega al carrito
    Then visualiza los productos agregados


  @SCRUM-7 @regresion
  Scenario Outline: Visualizar productos del carrito
    When agrega el producto "<producto>" al carrito
    And navega al carrito
    Then visualiza los productos agregados
    Examples:
      | producto                      |
      | Sauce Labs Backpack           |
      | Sauce Labs Bike Light         |
      | Sauce Labs Bolt T-Shirt       |

  @regresion
  Scenario Outline: Agregar diferentes productos al carrito
    When agrega el producto "<producto>" al carrito
    Then el carrito muestra 1 productos
    And navega al carrito
    Then visualiza los productos agregados
    And elimina el producto "<producto>" del carrito
    Examples:
      | producto                      |
      | Sauce Labs Backpack           |
      | Sauce Labs Bike Light         |
      | Sauce Labs Bolt T-Shirt       |