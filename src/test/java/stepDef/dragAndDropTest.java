package stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class dragAndDropTest {
    public static WebDriver driver = null;

    @BeforeMethod
    public void beforeTestSetUP() {
        WebDriverManager.chromedriver().version("79.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
     @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        WebElement dragableItem = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppableTargetElement = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragableItem, droppableTargetElement).perform();
    }
    @Test
    public void dragableSlider() throws InterruptedException {
        driver.get("https://jqueryui.com/slider/");
        //Given slider is in IFrame so we need switch in to Iframe first. Refer Iframe Blog for more understaing
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        WebElement dragableSlider = driver.findElement(By.xpath("//div[@id='slider']//span"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(dragableSlider, 250, 0).build().perform();
        Thread.sleep(5000);
    }


    @AfterMethod
    public void closeSetUp() {
        if (!driver.equals(null)) {
            driver.quit();
        }
    }

    }
