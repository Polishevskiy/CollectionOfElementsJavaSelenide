package core;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

abstract public class Base {
    /**
     * Selenide initialization with settings
     */
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1280x1024";
        Configuration.headless = false;
    }

    /**
     * Executing the method before each startup
     */
    @Before
    public void init(){
        setUp();
    }

    /**
     * Execution of the method after each test closure
     */
    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
