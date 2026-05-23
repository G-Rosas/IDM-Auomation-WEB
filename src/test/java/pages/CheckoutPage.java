package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {

    private final Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }

    private final String firstNameInput = "#first-name";
    private final String lastNameInput = "#last-name";
    private final String postalCodeInput = "#postal-code";
    private final String continueBtn = "#continue";
    private final String finishBtn = "#finish";
    private final String successMessage = ".complete-header";

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        page.fill(firstNameInput, firstName);
        page.fill(lastNameInput, lastName);
        page.fill(postalCodeInput, postalCode);
    }

    public void continueCheckout() {
        page.click(continueBtn);
    }

    public void finishCheckout() {
        page.click(finishBtn);
    }

    public String getSuccessMessage() {
        return page.locator(successMessage).textContent();
    }
}