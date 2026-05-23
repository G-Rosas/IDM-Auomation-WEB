package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;
import utils.TestContext;

public class Hooks {

    @Before
    public void setup() {
        DriverFactory.initBrowser();
        TestContext.selectedProducts.clear();
    }

    @After
    public void tearDown() {
        DriverFactory.closeBrowser();
    }
}

