package utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        String browserType = ConfigurationReader.getProperty("browser");

        if (driverPool.get() == null) {
            switch (browserType) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--window-size=1920,1080");

                    driverPool.set(new ChromeDriver(chromeOptions));
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    Dimension firefoxSize = new Dimension(1920, 1080);
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().setSize(firefoxSize);
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
