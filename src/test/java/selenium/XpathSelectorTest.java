package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class XpathSelectorTest {

    public static void printer(WebElement webElement){
        System.out.println(webElement.hashCode());
    }

    public static void listPrinter(List<WebElement> webElementsList) {
        for (int i = 0; i < webElementsList.size(); i++) {
            System.out.print(i+1+". ");
            printer(webElementsList.get(i));
        }
    }

    @Test
    public void findElementByXpath(){
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By fullPath = By.xpath("/html/body/div/ul");
        WebElement fullPathSelector = driver.findElement(fullPath);
        printer(fullPathSelector);

        By shortPath = By.xpath("//ul");
        WebElement shortPathSelector = driver.findElement(shortPath);
        printer(shortPathSelector);

        By buttonId = By.xpath("//*[@id=\"clickOnMe\"]");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        printer(clickOnMeButton);

        By buttonIdFullName = By.xpath("/html/body/button[@id='clickOnMe']");
        WebElement butElement = driver.findElement(buttonIdFullName);
        printer(butElement);

        By fnameInput = By.xpath("//*[@id=\"fname\"]");
        WebElement fnameInputElement = driver.findElement(fnameInput);
        printer(fnameInputElement);

        By inputsLocator = By.xpath("//input");
        WebElement inputElement = driver.findElement(inputsLocator);
        printer(inputElement);

        driver.findElement(inputsLocator).sendKeys("coś wprowadzam w input nr 1");
        List<WebElement> inputsList = driver.findElements(inputsLocator);
        System.out.println("liczba inputów w liście: " + inputsList.size());
        listPrinter(inputsList);

        System.out.println();
        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);
        printer(schoolLink);

        By linkText2 = By.xpath("//a[contains(text(), 'Visit')] ");
        WebElement schoolLink2 = driver.findElement(linkText2);
        printer(schoolLink2);

        By allXpath = By.xpath("//*");
        printer(driver.findElement(allXpath));

        By secondElement = By.xpath("(//input)[2]");
        printer(driver.findElement(secondElement));

        By lastElement = By.xpath("(//input)[last()]");
        printer(driver.findElement(lastElement));

        By elementsWithAttribute = By.xpath("(//*[@name])");
        driver.findElements(elementsWithAttribute);

        driver.findElements(elementsWithAttribute);

        By elementWithAttributeName = By.xpath("//*[@name='fname']");
        driver.findElement(elementWithAttributeName);

        By idButton = By.xpath("//button[@id='clickOnMe']");
        WebElement buttonWebElementById = driver.findElement(idButton);
        System.out.println(buttonWebElementById.hashCode());

        By diffrentThemIdButton = By.xpath("//button[@id!='clickOnMe']");
        WebElement buttonWebElementByIdDiffrent = driver.findElement(diffrentThemIdButton);
        System.out.println(buttonWebElementByIdDiffrent.hashCode());

        By xpathContainsBy = By.xpath("//*[contains(@name, 'ame')]");
        List<WebElement> containsNameList = driver.findElements(xpathContainsBy);
        listPrinter(containsNameList);

        By xpathStartsBy = By.xpath("//*[starts-with(@name, 'user')]");
        WebElement startsWith = driver.findElement(xpathStartsBy);
        printer(startsWith);
        
        By childUlBy = By.xpath("//*[starts-with(@name, 'user')]");
        By descendantUlBy = By.xpath("//div/descendant::ul");
        By descendantAllBy = By.xpath("//div/descendant::*");
        By anescorBy = By.xpath("//div/ancestor::*");

        WebElement childElement = driver.findElement(childUlBy);
        List<WebElement> descsendaUlElements = driver.findElements(descendantUlBy);
        List<WebElement> descsendaAllElements = driver.findElements(descendantAllBy);
        List<WebElement> anescorElements = driver.findElements(anescorBy);
        List<WebElement> descsendaElements = driver.findElements(descendantUlBy);

        System.out.println(childElement.hashCode());
        listPrinter(descsendaUlElements);
        listPrinter(descsendaAllElements);
        listPrinter(anescorElements);
        listPrinter(descsendaElements);

        //182 3:30
    }


}
