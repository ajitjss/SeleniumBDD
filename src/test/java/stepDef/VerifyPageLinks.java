package stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyPageLinks {
     @Test
    public void verifyBrokenLinks() {
        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // store dropdown as Webelement
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total Number of Links: " + allLinks.size());

        SoftAssert soft = new SoftAssert();
        for (WebElement link : allLinks) {
            String actualLinkText = link.getText();
            System.out.println("Link Text" + actualLinkText);
            System.out.println("URL within HREF: " + link.getAttribute("href"));
            //Test Case 1:
            //actualLinkText should not null. So use TestNG method assertNotNull for assertions
            soft.assertNotNull(actualLinkText);
            // Test Case 2: Verify response code
            String urlForTest= link.getAttribute("href");
            int responseCode =getResponseCode(urlForTest);
            System.out.println("Link: "+urlForTest+"Response From Server: "+responseCode);
            soft.assertEquals(responseCode, 200, "Testing Response of URL"+urlForTest);
        }
        soft.assertAll();
        driver.close();
    }

    @Test
    public void brokenLink() {
        String urForTest = "https://www.wikipedia.org/";
        try {
            URL url = new URL(urForTest);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();
            int serverResponseCode = httpConnection.getResponseCode();
            System.out.println("Server Response Code: " + serverResponseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getResponseCode(String urForTest){
        int serverResponseCode=0;
        try {
            URL url = new URL(urForTest);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();
          serverResponseCode = httpConnection.getResponseCode();
            System.out.println("Server Response Code: " + serverResponseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverResponseCode;
    }


}
