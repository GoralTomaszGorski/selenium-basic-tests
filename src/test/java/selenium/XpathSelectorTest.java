package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathSelectorTest {


    @Test
    public void findElementByXpath(){
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By fullPath = By.xpath("/html/body/div/ul");
        WebElement fullPathSelector = driver.findElement(fullPath);
        System.out.println(fullPathSelector);

        By shortPath = By.xpath("//ul");
        WebElement shortPathSelector = driver.findElement(shortPath);
        System.out.println(shortPathSelector);

    }
}
