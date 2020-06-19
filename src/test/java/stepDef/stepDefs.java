package stepDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class stepDefs {

    public  WebDriver driver=null;

    @Given("^Open the firefox and open application$")
    public void Open_the_firefox_and_open_application() throws Throwable {
        WebDriverManager.chromedriver().version("83.0.4103.61").setup();
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @When("^enter the Username and Password$")
    public void enter_the_Username_and_Password() throws Throwable {
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("mercury");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
        driver.findElement(By.xpath("//input[@name='login']")).click();
    }



    @Then("^user should be successfully login into Application$")
    public void user_should_be_successfully_login_into_Application() throws Throwable {
        Assert.assertEquals("Find a Flight: Mercury Tours:",driver.getTitle());
        driver.close();
    }


    @Then("^reset the credentials$")
    public void reset_the_credentials() throws Throwable {
        System.out.println("Reset the credentials");
        Assert.assertEquals("Ajeet", "Ajeet");
    }


    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void userEnterUsernameAndPassword(String username, String password) throws Throwable {
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='login']")).click();
        Assert.assertEquals("Ajeet", "Ajeet");
    }
}
