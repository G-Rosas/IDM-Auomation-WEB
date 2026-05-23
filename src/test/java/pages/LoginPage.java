package pages;

import com.microsoft.playwright.Page;
import utils.ConfigReader;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    private final String username = "#user-name";
    private final String password = "#password";
    private final String loginBtn = "#login-button";

    public void navigate() {page.navigate(ConfigReader.get("base.url"));
    }

    public void login(String user, String pass) {
        page.fill(username, user);
        page.fill(password, pass);
        page.click(loginBtn);
    }
}
