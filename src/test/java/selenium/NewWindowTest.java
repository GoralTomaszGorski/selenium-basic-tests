package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class NewWindowTest {


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
    public void testNewWindow() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        String startPage = driver.getWindowHandle();

        driver.findElement(
                By.linkText("Strona z iframe"))
                .click();
        String iframePage = driver.getWindowHandle();

        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.id("fname")).sendKeys("Tomek");
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }
}
