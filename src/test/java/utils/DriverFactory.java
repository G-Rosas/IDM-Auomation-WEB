package utils;

import com.microsoft.playwright.*;

public class DriverFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static void initBrowser() {
        playwright = Playwright.create();
        String browserName = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
        int slowMo = Integer.parseInt(ConfigReader.get("slowmo"));

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(slowMo);

        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox()
                        .launch(options);
                break;
            case "webkit":
                browser = playwright.webkit()
                        .launch(options);
                break;
            default:
                browser = playwright.chromium()
                        .launch(options);
        }
        context = browser.newContext();
        page = context.newPage();
    }

    public static Page getPage() {
        return page;
    }

    public static void closeBrowser() {

        if (page != null) {
            page.close();
        }

        if (context != null) {
            context.close();
        }

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}