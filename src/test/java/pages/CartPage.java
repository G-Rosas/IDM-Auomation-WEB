package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class CartPage {

    private final Page page;
    public CartPage(Page page) {
        this.page = page;
    }
    public List<String> getCartProducts() {return page.locator(".inventory_item_name").allTextContents();
    }

    private final String cartIcon = ".shopping_cart_link";
    private final String inventoryItemName  = ".inventory_item_name";
    private final String checkoutBtn = "#checkout";
    private final String removeButton = "button:has-text('Remove')";
    private final String cartItem = ".cart_item";

    public void navigateToCart() {
        page.click(cartIcon);
    }

    public String getProductName(String productName) {
        return page.locator(cartItem).filter(new Locator.FilterOptions().setHasText(productName)).locator(inventoryItemName).textContent().trim();
    }

    public void clickCheckout() {
        page.click(checkoutBtn);
    }

    public void removeProduct(String productName) {
        page.locator(cartItem).filter(new Locator.FilterOptions().setHasText(productName)).locator(removeButton).click();
    }
}