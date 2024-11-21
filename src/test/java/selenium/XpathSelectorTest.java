package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

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


        By buttonId = By.xpath("//*[@id=\"clickOnMe\"]");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        System.out.println(clickOnMeButton.hashCode());

        By buttonIdFullName = By.xpath("/html/body/button[@id='clickOnMe']");
        WebElement butElement = driver.findElement(buttonIdFullName);
        System.out.println(butElement.hashCode());

        By fnameInput = By.xpath("//*[@id=\"fname\"]");
        WebElement fnameInputElement = driver.findElement(fnameInput);

        By inputsLocator = By.xpath("//input");
        WebElement inputElement = driver.findElement(inputsLocator);
        driver.findElement(inputsLocator).sendKeys("coś wprowadzam w input nr 1");
        List<WebElement> inputsList = driver.findElements(inputsLocator);
        System.out.println("liczba inputów w liście: " + inputsList.size());

        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);
        System.out.println(schoolLink.hashCode());

        By linkText2 = By.xpath("//a[contains(text(), 'Visit')] ");
        WebElement schoolLink2 = driver.findElement(linkText2);
        System.out.println(schoolLink2.hashCode());

        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementsWithAttribute = By.xpath("(//*[@name])");
        driver.findElements(elementsWithAttribute);

        By elementWithAttributeName = By.xpath("//*[@name='fname']");
        driver.findElement(elementWithAttributeName);
    }
}
