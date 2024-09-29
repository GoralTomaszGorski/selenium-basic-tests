package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumChromeTest {


    @Test
    public void openSeleniumDemoPage() {
        ChromeOptions options = getChromeOptions();
        String baseUrl = "http://seleniumdemo.com/";
        WebDriver driver = getDriver(options, baseUrl);
        driver.findElement(By.xpath("//span[text()='Shop']")).click();
        WebElement seleniumProduct = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));
        Assert.assertTrue(seleniumProduct.isDisplayed());

    }

    private static WebDriver getDriver(ChromeOptions options, String baseUrl) {
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        String path = "/home/tomaszgorski/Dokumenty/chromedriver-linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return options;
    }

}