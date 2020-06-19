package stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AssertExample {
    public static WebDriver driver=null;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("83.0.4103.61").setup();
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //@Test
    public void LoginVerifyWithHardAssert() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("mercury");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        Thread.sleep(5000);
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        Assert.assertEquals(pageTitle, "Find a Flight: Mercury Tours:-Hard 1");
        driver.findElement(By.xpath("//input[@name='findFlights']")).click();
        String selectPageTitle = driver.getTitle();
        System.out.println("Page Title: " + selectPageTitle);
        Assert.assertEquals(selectPageTitle, "Select a Flight: Mercury Tours-Hard 2");
        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
        driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
        Thread.sleep(7000);
        driver.close();
        System.out.println("Test Completed!");
    }
  @Test
    public void BookFlightVerifyWithSoftAssert() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("mercury");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        SoftAssert soft = new SoftAssert();
        Thread.sleep(5000);
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        soft.assertEquals(pageTitle, "Select a Flight: Mercury Tours1");
        driver.findElement(By.xpath("//input[@name='findFlights']")).click();
        String selectPageTitle = driver.getTitle();
        System.out.println("Page Title: " + selectPageTitle);
        soft.assertEquals(selectPageTitle, "Select a Flight: Mercury Tours2");
        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
        driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
        Thread.sleep(7000);
        String confirmationPageTitle = driver.getTitle();
        System.out.println("Confirmation Page Title: "+confirmationPageTitle);
        soft.assertEquals(confirmationPageTitle, "");
        driver.close();
        System.out.println("Test Completed!");
        soft.assertAll();

    }

    @AfterTest
    public void closeSetUp(){
        if(!driver.equals(null)){
            driver.quit();
        }
    }

}
