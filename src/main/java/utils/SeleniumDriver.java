package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SeleniumDriver
{

    private static SeleniumDriver seleniumDriver;
    private static WebDriver driver;
    private static WebDriverWait waitDriver;

    public static Properties config = new Properties();
    public static Properties OR = new Properties();

    private FileInputStream fis;


    private SeleniumDriver()
    {
        // Open and Load config file
        try {
            fis = new FileInputStream("./src/main/resources/properties/OR.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            OR.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Open and Load or file
        try {
            fis = new FileInputStream("./src/main/resources/properties/Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(config.getProperty("browser").equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(config.getProperty("browser").equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static void setUpDriver()
    {
        if( seleniumDriver == null) {
            seleniumDriver = new SeleniumDriver();
        }
    }

    public static void tearDown()
    {
        if(driver != null)
        {
            driver.close();
            driver.quit();
        }

        seleniumDriver = null;
    }
}
