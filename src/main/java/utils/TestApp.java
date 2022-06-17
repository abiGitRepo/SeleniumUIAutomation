package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;


    public class TestApp {
        private WebDriver driver;
        private static utils.TestApp myObj;
        utils.PropertyFileReader property = new PropertyFileReader();

        //  Singleton design Pattern
        public static utils.TestApp getInstance() {
            if (myObj == null) {
                myObj = new utils.TestApp();
                return myObj;
            } else {
                return myObj;
            }
        }

        //get the selenium driver
        public WebDriver getDriver() {
            return driver;
        }

        //when selenium opens the browsers it will automatically set the web driver
        private void setDriver(WebDriver driver) {
            this.driver = driver;
        }

        public static void setMyObj(utils.TestApp myObj) {
            utils.TestApp.myObj = myObj;
        }

        public void openBrowser() {

            String browserName= property.getProperty("config","browser");
            System.out.println("Browser is "+ browserName);
            if(browserName.equals("chrome") ){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            }else if(browserName.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }else if(browserName.equals("edge")){
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            }


            driver.manage().window().maximize();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void navigateToURL() {
            String url = property.getProperty("config", "url");

            driver.get(url);
        }

        public void closeBrowser() {
            driver.quit();
        }

        public WebElement waitForElement(By locator, int timeout) {
            WebElement element = new WebDriverWait(utils.TestApp.getInstance().getDriver(), timeout).until
                    (ExpectedConditions.presenceOfElementLocated(locator));
            return element;
        }

        private String getChromeDriverFilePath() {
            //you should add the chromedriver.exe with extention if you are a windows user
            URL res = getClass().getClassLoader().getResource("chromedriver.exe");
           //For Gecko
           // URL res = getClass().getClassLoader().getResource("geckodriver.exe");
           //For Edge
           // URL res = getClass().getClassLoader().getResource("msedgedriver.exe");





            File file = null;
            try {
                file = Paths.get(res.toURI()).toFile();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return file.getAbsolutePath();
        }
    }

