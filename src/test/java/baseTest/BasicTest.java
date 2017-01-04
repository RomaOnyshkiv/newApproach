package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import utils.ConfigProperties;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BasicTest {

    private static WebDriver driver;
    private File pathToDriver = new File("./src/main/resources/drivers/chromedriver");

    protected WebDriver getDriver(){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", pathToDriver.getAbsolutePath());
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getPropeties("imp.wait")), TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
