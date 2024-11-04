package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.annotations.Test;

@Service
public class SeleniumChromeTest {

    @Test
    public void openSeleniumDemoPage() {
        String baseUrl = "http://seleniumdemo.com/";
        WebDriver driver = getDriver(getChromeOptions(), baseUrl);
        driver.findElement(By.xpath("//span[text()='Shop']")).click();
        WebElement seleniumProduct = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));
        Assert.assertTrue(seleniumProduct.isDisplayed());
    }

    public WebDriver getDriver(ChromeOptions options, String baseUrl) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }

    public ChromeOptions getChromeOptions() {
        String path = "/home/tomaszgorski/Dokumenty/chromedriver-linux64/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return options;
    }
}