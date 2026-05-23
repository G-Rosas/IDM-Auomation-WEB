package steps;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.DriverFactory;
import pages.InventoryPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getPage());

    @Given("el usuario navega al login")
    public void elUsuarioNavegaAlLogin() {
        loginPage.navigate();
    }

    @When("inicia sesion con usuario {string} y password {string}")
    public void iniciaSesionConUsuarioYPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("visualiza la pagina de productos")
    public void visualizaLaPaginaDeProductos() {
        DriverFactory.getPage().waitForURL("**/inventory.html");
        String currentUrl = DriverFactory.getPage().url();
        Assert.assertTrue(currentUrl.contains("inventory"));
    }

    @Then("visualiza mensaje de usuario bloqueado")
    public void visualizaMensajeDeUsuarioBloqueado() {
        String errorMessage = DriverFactory.getPage().locator("[data-test='error']").textContent();
        Assert.assertTrue(errorMessage.contains("locked out"));
    }


    @Given("el usuario inicia sesion correctamente")
    public void elUsuarioIniciaSesionCorrectamente() {
        loginPage.navigate();
        loginPage.login("standard_user", "secret_sauce");
    }
}