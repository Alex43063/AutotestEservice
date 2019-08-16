package utils;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.soap.SOAPException;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static sun.net.NetProperties.get;


public class BaseSettings {
    public ChromeDriver driver;
    public WebDriverWait wait;
    public ChromeOptions options;

    @Before
    public void setup (){
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\davydov\\IdeaProjects\\EservicePortal\\src\\test\\assert\\plugins\\Proxy-Auto-Auth_v2.0.crx"));
//        options.addArguments(get("profile"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        @FindBy(id="login")
//         WebElement login;
//        driver.findElementById("login").sendKeys("davydov");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\davydov\\IdeaProjects\\EservicePortal\\src\\test\\assert\\driver\\chromedriver.exe");


//        ChromeDriverManager
//                .getInstance(DriverManagerType.CHROME)
//                .proxy(get("proxyHost") + ":" + get("proxyPort"))
//                .proxyUser(get("proxyUserName"))
//                .proxyPass(get("proxyPassword"))
//                .setup();
        driver = new ChromeDriver(capabilities);
        wait = new WebDriverWait(driver,30);
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\davydov\\IdeaProjects\\EservicePortal\\src\\test\\assert\\driver\\chromedriver.exe");
//        driver = new ChromeDriver();
//        ChromeOptions options = new ChromeOptions();
//        //List<File> files = new ArrayList<File>();
//        String fileName= "C:\\Users\\davydov\\IdeaProjects\\EservicePortal\\src\\test\\assert\\plugins\\Proxy-Auto-Auth_v2.0.crx";
////        files.add(new File(BaseSettings.class.getClassLoader().getResource(fileName).getFile()));
////        fileName = "C:\\Users\\davydov\\IdeaProjects\\EservicePortal\\src\\test\\assert\\plugins\\CryptoPro-Extension-for-CAdES-Browser-Plug-in_v1.2.7_0.crx";
//       // files.add(new File(BaseSettings.class.getClassLoader().getResource(fileName).getFile()));
//        options.addExtensions("C:\\Users\\davydov\\IdeaProjects\\EservicePortal\\src\\test\\assert\\plugins\\Proxy-Auto-Auth_v2.0.crx");
//        wait = new WebDriverWait(driver,30);
//        System.out.println("Test start");
    }

    @Before
    public void proxy(){

    }



    //    @After
//    public  void close(){
//        driver.quit();
//        System.out.println("Test end");
//    }

}
