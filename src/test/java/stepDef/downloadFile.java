package stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class downloadFile {

    @Test
    public void TestDownloadFile() throws InterruptedException {
        WebDriverManager.chromedriver().version("83.0.4103.61").setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, String> chromePref = new HashMap<String, String>();
        String downloadFolder = "C:\\Users\\ajit\\Desktop\\Chinees";
        chromePref.put("download.default_directory", downloadFolder);
        options.setExperimentalOption("prefs", chromePref);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://songspk3.online/dream-girl-songs.html");
        //Click now download Link
        driver.findElement(By.xpath("//table[1]//tbody[1]//tr[1]//td[2]//a[1]//strong[1]")).click();
        // Get Parent Window Handle
        String parentWindow = driver.getWindowHandle();
        //Open New Tab in Same Browser and go to "chrome://downloads" to check Dowonlaod status
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.open()");
        // Get all windowHandles
       Set<String> allWinowHandles= driver.getWindowHandles();
       // Switch to new Window Handle
        for(String winHandle: allWinowHandles){
            //Switch to second window
            if(!winHandle.equals(parentWindow)){
                driver.switchTo().window(winHandle);
            }
        }

        // navigate to chrome downloads
        driver.get("chrome://downloads");
// Use JavaScript Executor to get information about Downloaded File
        JavascriptExecutor downloadWindowExecutor = (JavascriptExecutor)driver;
        // Wait for Download till 100% completion

        double percentageProgress = (double) 0;
        while (percentageProgress != 100) {
            percentageProgress = (Long) downloadWindowExecutor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value");
            System.out.println("Completed Percentage" + percentageProgress);
           Thread.sleep(100);
        }
//
        // Get File Name using Java Query
        String fileName = (String) downloadWindowExecutor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
        // Get the URL of Download Source link
        String downloadSourceLink = (String) downloadWindowExecutor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').href");
        // Get download folder location
        String downloadedFolder = (String) downloadWindowExecutor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div.is-active.focus-row-active #file-icon-wrapper img').src");
        System.out.println("Details of Downloaded Files");
        // print the details
        System.out.println("Details of Downloaded Files");
        System.out.println("Downloaded File Name: " + fileName);
        System.out.println("Donwloaded File Location: " + downloadedFolder);
        System.out.println("Download Link : " + downloadSourceLink);
        //Assert.assertEquals(downloadedFolder,downloadFolder, "Verified Download Folder Location");
        // Close Chrome  Download TAB
        driver.quit();
  /*      driver.close();
        // Now switch to Parent Window
        driver.switchTo().window(parentWindow);
        // At the End close Browser
        driver.close();*/
    }

    public boolean isFileDownloaded(String fileName, String folderName) {
        File dir = new File(folderName);
        boolean isFileExist = false;
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                isFileExist = true;
            }
        }
        return isFileExist;
    }

    public String waitUntilDonwloadCompleted(WebDriver driver) throws InterruptedException {
        // Store the current window handle
        String mainWindow = driver.getWindowHandle();

        // open a new tab
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        // switch to new tab
        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        // navigate to chrome downloads
        driver.get("chrome://downloads");

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // wait until the file is downloaded
        Long percentageProgress = (long) 0;
        while (percentageProgress != 100) {
            percentageProgress = (Long) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value");
            System.out.println("Completed Percentage" + percentageProgress);
            Thread.sleep(1000);
        }
        // Get File Name using Java Query
        String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
        // Get the URL of Download Source link
        String sourceURL = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').href");
        // Get download folder location
        String donwloadedAt = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div.is-active.focus-row-active #file-icon-wrapper img').src");
        System.out.println("Details of Downloaded Files");
        System.out.println("Downloaded File Name: " + fileName);
        System.out.println("Donwloaded File Location: " + donwloadedAt);
        System.out.println("Download Link : " + sourceURL);
        // print the details

        // Close Chrome  Download TAB
        driver.close();
        // Now switch to Main Window
        driver.switchTo().window(mainWindow);
        return fileName;
    }
}
