package selenium;

import ch.qos.logback.core.util.FileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadTest {

    @Test
    public void uploadFile() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("/home/tomaszgorski/IdeaProjects/Selenium/src/main/resources/static/screenshots//home/tomaszgorski/IdeaProjects/Selenium/src/main/resources/static/screenshot.jpg"));
    }
}
