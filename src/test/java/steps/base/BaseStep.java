package steps.base;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BaseStep {
    protected WebDriver driver;
    protected Random randomGenerator;
    public User user;

    protected void set_timeOutValue(int timeOutValue) {
        this._baseTimeOutValue = timeOutValue;
    }

    private int _baseTimeOutValue = 0;
    private String folderName = "";
    String pattern;
    SimpleDateFormat simpleDateFormat;

    protected BaseStep(String folderName) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        options.addArguments("incognito");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.folderName = folderName;
        pattern = "dd-M-yyyy-hh-mm-ss";
        simpleDateFormat = new SimpleDateFormat(pattern);
        randomGenerator = new Random();
        user = new User();
        user.getUserName();
        user.getUserPassword();
    }

    private String get_randomNumber() {
        return UUID.randomUUID().toString();
    }

    private String get_currentTime() {
        return simpleDateFormat.format(new Date()).toString();
    }

    private String getFolderName() {
        return folderName;
    }

    protected void GotoUrl() {
        driver.get("https://dolap.com/");
    }

    protected void clickElement(WebElement element, TimeOut... timeOuts) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, timeOuts.length == 0 ? _baseTimeOutValue : timeOuts[0].value);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            HighLighterMethod(element);
        } catch (Exception ex) {
            takeScreenshot();
        }
    }

    protected WebElement visibilityOfElement(WebElement element, TimeOut... timeOuts) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, timeOuts.length == 0 ? _baseTimeOutValue : timeOuts[0].value);
            wait.until(ExpectedConditions.visibilityOf(element));
            HighLighterMethod(element);
            return element;
        } catch (Exception ex) {
            System.out.println("find element method error" + ex.getMessage());
            takeScreenshot();
            return null;
        }
    }

    protected WebElement invisibleElement(WebElement element, TimeOut... timeOuts) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, timeOuts.length == 0 ? _baseTimeOutValue : timeOuts[0].value);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return element;
        } catch (Exception ex) {
            System.out.println("find element method error" + ex.getMessage());
            takeScreenshot();
            return null;
        }
    }

    protected void pageScrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
    }

    protected void pageScrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-250)", "");
    }

    protected WebElement WaitElementCssControl(
            WebElement element, String prop, String value, TimeOut... timeOuts) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, timeOuts.length == 0 ? _baseTimeOutValue : timeOuts[0].value);
            wait.until(ExpectedConditions.attributeContains(element, prop, value));
            return element;
        } catch (Exception ex) {
            System.out.println("find element method error" + ex.getMessage());
            takeScreenshot();
            return null;
        }
    }

    public enum TimeOut {
        LOW(5),
        MIDDLE(10),
        HIGH(15),
        CUSTOM_MAX(60);
        private final int value;

        public int getValue() {
            return value;
        }

        private TimeOut(int value) {
            this.value = value;
        }
    }

    private void HighLighterMethod(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    protected String getUrl() {
        return driver.getCurrentUrl();
    }

    private void takeScreenshot() {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {

            String _path =
                    "src/test/java/screenshot/"
                            + getFolderName()
                            + "\\"
                            + get_currentTime()
                            + "\\"
                            + get_randomNumber()
                            + ".png";
            FileUtils.copyFile(scrFile, new File(_path));
        } catch (IOException e) {
            System.out.println("ScreenShot fail." + e.getMessage());
        }
    }

    protected void TearDown() {
        driver.quit();
    }
}
