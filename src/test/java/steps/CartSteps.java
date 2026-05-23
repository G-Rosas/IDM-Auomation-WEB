package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.InventoryPage;
import utils.DriverFactory;
import utils.TestContext;

import java.util.List;

public class CartSteps {

    InventoryPage inventoryPage = new InventoryPage(DriverFactory.getPage());
    CartPage cartPage = new CartPage(DriverFactory.getPage());


    @When("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String productName) {
        TestContext.selectedProducts.add(productName);
        inventoryPage.addProduct(productName);
    }


    @Then("el carrito muestra {int} productos")
    public void elCarritoMuestraProducto(int expectedCount) {
        int actualCount = Integer.parseInt(inventoryPage.getCartCount());
        Assert.assertEquals(expectedCount, actualCount);
    }

    @And("navega al carrito")
    public void navegaAlCarrito() {
        cartPage.navigateToCart();
    }

    @And("elimina el producto {string} del carrito")
    public void eliminaElProductoDelCarrito(String productName) {
        cartPage.removeProduct(productName);
        TestContext.selectedProducts.remove(productName);
    }
    @Then("visualiza los productos agregados")
    public void visualizaLosProductosAgregados() {
        List<String> actualProducts = cartPage.getCartProducts();
        Assert.assertEquals(TestContext.selectedProducts, actualProducts
        );
    }
}