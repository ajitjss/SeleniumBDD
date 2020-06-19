package stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class actionClassDemo {

    public static WebDriver driver = null;

    @BeforeMethod
    public void beforeTestSetUP() {
        WebDriverManager.chromedriver().version("79.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void rightClick() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement rightClickableElemet = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        Actions action = new Actions(driver);
        action.contextClick(rightClickableElemet).build().perform();
        driver.findElement(By.xpath("//html//body//ul//li//span[contains(text(),'Paste')]")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void mouseHover() throws InterruptedException {
        driver.get("https://kybarg.github.io/bootstrap-dropdown-hover/");
        Thread.sleep(5000);
        WebElement dropDownonHover = driver.findElement(By.xpath("//body/div/div/div/div/div/div[1]/button[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(dropDownonHover).perform();
        WebElement onemoreDropDown = driver.findElement(By.xpath("//body/div/div/div/div/div/div[1]/ul[1]/li[3]/a[1]"));
        action.moveToElement(onemoreDropDown).perform();
        WebElement MoreDropdown = driver.findElement(By.xpath("//body/div/div/div/div/div/div[1]/ul[1]/li[3]/ul[1]/li[3]/a[1]"));
        action.moveToElement(MoreDropdown).build().perform();
       

        Thread.sleep(7500); // added delay to visual validation

    }



    @AfterMethod
    public void closeSetUp() {
        if (!driver.equals(null)) {
            driver.quit();
        }
    }

}