package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SelectorTest {

    private SeleniumChromeTest seleniumChromeTest;

    public SelectorTest(SeleniumChromeTest seleniumChromeTest) {
        this.seleniumChromeTest = seleniumChromeTest;
    }


    @Test
    public void setWebDriver(){
        ChromeOptions options = seleniumChromeTest.getChromeOptions();
        String baseUrl = "https://testeroprogramowania.github.io/selenium/basics.html";
        WebDriver driver = seleniumChromeTest.getDriver(options, baseUrl);

    }




}
