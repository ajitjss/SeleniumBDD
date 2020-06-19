package stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestDropdown {
    @Test
    public void dropdownTest() throws InterruptedException {
        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // store dropdown as Webelement
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
        // Use Selenium "Select" class to perform dropdown related operations
        Select drpdown = new Select(dropdown);
        //Count total dropdowns
        int totalNoOfDropdown = drpdown.getOptions().size();
        System.out.println("Total Number of Dropdown:" + totalNoOfDropdown);
        // Verify total number of dropdowns
        Assert.assertEquals(totalNoOfDropdown, 66, "Verified total number of dropdowns ");
        // verify  selected Options
        WebElement selectedDropdown = drpdown.getFirstSelectedOption();
        String selectedDropdowntext = selectedDropdown.getText();
        System.out.println("Selected Dropdown: " + selectedDropdowntext);
        // Verify selected Dropdown using Testng Assert Method
        Assert.assertEquals(selectedDropdowntext, "English", "Verified selected Dropdown");
        // Select dropdown using index - Index 9 -Dansk
        drpdown.selectByIndex(9);
        // Select dropdown by using value-(Select Language- Magyar using value- "hu"

        Thread.sleep(7500);  // wait for 7.5 seconds. Just to see visible
        drpdown.selectByValue("hu");

        // Select dropdown using Visble text "Suomi" - Language Suomi will be selected
        Thread.sleep(5000);
        drpdown.selectByVisibleText("Suomi");
        // Check whether dropdown is multiple select or not
        System.out.println("is this dropdown is multiple select : " + drpdown.isMultiple());

        // Print all the dropdowns
        List<WebElement> allOptions = drpdown.getOptions();
        for (WebElement ele : allOptions) {
            System.out.println(ele.getText());
        }
        driver.close();
    }

}
