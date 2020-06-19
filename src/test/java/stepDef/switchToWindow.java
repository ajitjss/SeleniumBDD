package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class switchToWindow {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajit\\Documents\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
        // WebDriverManager.chromedriver().version("80.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.naukri.com");
        Thread.sleep(7500);
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Name: " + driver.getTitle());
        //getWindowHandles() method returns all the open windows.
        Set<String> openWindows = driver.getWindowHandles();
        System.out.print("All the open windows handles: " + openWindows);
        for (String winTitle : openWindows) {
            System.out.println("Win Title: " + driver.switchTo().window(winTitle).getTitle());
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Parent Window:  " + driver.getTitle());
        System.out.println("******************use iterator to iterate over window***************");
        Iterator<String> win = openWindows.iterator();
        while (win.hasNext()) {
            String tempWin = win.next();
            if (!tempWin.contentEquals(parentWindow)) {
                System.out.println("\nChild Window: " + driver.switchTo().window(tempWin).getTitle());
            }
        }
        driver.quit();
    }
}
