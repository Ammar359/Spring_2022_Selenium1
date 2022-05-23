package Class1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UseSelenium {

    @Test
    public void useSeleniumLib() {

        // path of chromedriver
        //System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");            // Mac

         System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");         // Windows

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

    }

}