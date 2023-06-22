package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {

        //BROWSER --chrome or firefox
        //HUB_HOST -- localhost/10.1.1.3 /hostname

        String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") !=null &&
                    System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        } else {
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String complteUrl = "http://" + host + ":4444/wd/hub";
        //dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(complteUrl), dc);


//        System.setProperty("webdriver.chrome.driver", "/Users/rameshdhanenkula/Downloads/chromedriver_mac64/chromedriver");
//        this.driver = new ChromeDriver();

    }

    @AfterTest

    public void quitDriver(){
        this.driver.quit();
    }

}
