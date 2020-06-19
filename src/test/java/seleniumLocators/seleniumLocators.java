package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class seleniumLocators {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("81.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com");
        Thread.sleep(7500);
        //Locator 1- Using Partial Link Text- Click on SIGN-ON using partial link text"SIGN"
        driver.findElement(By.partialLinkText("SIGN")).click();
        // Locator 2- Using LinkText -Click on REGISTER using link text
        driver.findElement(By.linkText("REGISTER")).click();
        // Locator 3- Using Name- Identify first name field using name locator
        driver.findElement(By.name("firstName")).sendKeys("Thoughtcoders");
        // locator 4- Using CSS Selector
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("team");
        //Locator 5- Using xpath
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9555902032");
       // Locator 6- Using Tag name
        WebElement dropdowns= driver.findElement(By.tagName("select"));
        Select select = new Select(dropdowns);
        select.selectByVisibleText("ALGERIA ");
        // Locator 7- Using Class Name
       WebElement footer=  driver.findElement(By.className("footer"));
        System.out.println(footer.getText());
        //Locator using id
        driver.findElement(By.id("email")).sendKeys("thoughtcoders@gmail.com");
        driver.findElement(By.name("register")).click();
        driver.close();
    }
}
