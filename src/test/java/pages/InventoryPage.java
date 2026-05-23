package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InventoryPage {

    private final Page page;

    public InventoryPage(Page page) {this.page = page;}

    private final String cartBadge = ".shopping_cart_badge";
    private final String inventoryItem = ".inventory_item";
    private final String addToCartButton = "button:has-text('Add to cart')";

    public void addProduct(String productName) {
        page.locator(inventoryItem).filter(new Locator.FilterOptions().setHasText(productName)).locator(addToCartButton).click();
    }

    public String getCartCount() {
        return page.locator(cartBadge).textContent();
    }

    public void waitForPage() {
        page.waitForURL("**/inventory.html");
        page.locator(inventoryItem).first().waitFor();
    }
}