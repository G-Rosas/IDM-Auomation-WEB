package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import utils.DriverFactory;

public class CheckoutSteps {

    CartPage cartPage = new CartPage(DriverFactory.getPage());
    CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getPage());

    @And("completa el checkout")
    public void completaElCheckout() {
        cartPage.navigateToCart();
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutInformation("Giancarlo", "Rosas", "15001");
        checkoutPage.continueCheckout();
        checkoutPage.finishCheckout();
    }

    @Then("visualiza mensaje de compra exitosa")
    public void visualizaMensajeDeCompraExitosa() {
        String successMessage = checkoutPage.getSuccessMessage();
        Assert.assertEquals("Thank you for your order!", successMessage);
    }
}