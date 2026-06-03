package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import utils.DriverFactory;
import utils.TestContext;
import io.cucumber.java.Scenario;
import com.microsoft.playwright.Page;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void setup() {
        DriverFactory.initBrowser();
        TestContext.selectedProducts.clear();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = DriverFactory.getPage()
                    .screenshot(new Page.ScreenshotOptions().setFullPage(true));

            scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.getName());

            Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot));
        }

        DriverFactory.closeBrowser();
    }
}

