package stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import java.util.Date;

public class consoleLogTest {
    @Test
    public void consoleMessageTest() throws InterruptedException {
        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        Thread.sleep(7500);
        LogEntries logEntries = driver.manage().logs().get("browser");
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            String errorLogType= entry.getLevel().toString();
            String errorLog= entry.getMessage().toString();
            if(errorLog.contains("404")){
                System.out.println("Error LogType: "+ errorLogType+" Error Log message: "+errorLog);
            }
        }
        driver.close();
    }

}
