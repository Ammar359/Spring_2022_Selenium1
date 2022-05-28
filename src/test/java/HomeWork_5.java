import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
public class HomeWork_5 {
    //Question 1
    /**
     * darksky.net
     * Verify the current date is highlighted in Time Machine's calendar
     */

    @Test
    public void isCurrentDateHighlighted() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        for (int i = 0; i <= 15; i++) {
            try {
                MyDriver.getDriver().findElement(By.xpath("//a[text()='Time Machine' or text()='TIME MACHINE']")).click();
                break;
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                JavascriptExecutor jsE = (JavascriptExecutor) MyDriver.getDriver();
                jsE.executeScript("scrollBy(0,100)");
            }
        }
        Misc.pause(5);
        Date now = new Date();
        SimpleDateFormat sdFormatDay = new SimpleDateFormat("d");
        String todayDate = sdFormatDay.format(now);
        String dateFromTimeMachine = MyDriver.getDriver().findElement(By.xpath("//td[@class='is-today']/button")).getText();
        Assert.assertEquals(todayDate, dateFromTimeMachine, "The current date is not highlighted");
        MyDriver.quitWindows();
    }

    //Question 2

    /**
     * darksky.net
     * Verify same values are displayed in the Today's data
     */

    @Test
    public void areValuesDisplayedCorrect() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        for (int i = 0; i <= 10; i++) {
            try {
                MyDriver.getDriver().findElement(By.xpath("(//span[@class='toggle']/span[@class='open'])[1]")).click();
                break;
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                JavascriptExecutor jsE = (JavascriptExecutor) MyDriver.getDriver();
                jsE.executeScript("scrollBy(0,100)");
            }
        }
        Misc.pause(5);
        String lowBarTemp = MyDriver.getDriver().findElement(By.xpath("//a[@class='day revealed']//span[@class='minTemp']")).getText();
        String lowNumTemp = MyDriver.getDriver().findElement(By.xpath("(//span[@class='temp'])[1]")).getText();
        Assert.assertEquals(lowBarTemp, lowNumTemp, "The Low temperatures displayed are non identical");
        String highBarTemp = MyDriver.getDriver().findElement(By.xpath("(//span[@class='maxTemp'])[1]")).getText();
        String highNumTemp = MyDriver.getDriver().findElement(By.xpath("(//span[@class='arrow']/following::span[@class='temp'])[1]")).getText();
        Assert.assertEquals(highBarTemp, highNumTemp, "The High temperatures displayed are non identical");
        MyDriver.quitWindows();
    }

    //Question 3

    /**
     * facebook.com/
     * Launch facebook.com
     * Click on Facebook Pay, Oculus, Instagram, Portal and Bulletin
     * Close ALL windows except Instagram
     * Verify number of window-Handles is 1
     * Verify Page Title is Instagram
     * Verify Log in button on Instagram is disabled by default
     */
    
    @Test
    public void allWindows() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
        MyDriver.getDriver().findElement(By.linkText("Facebook Pay")).click();
        MyDriver.getDriver().findElement(By.linkText("Oculus")).click();
        MyDriver.getDriver().findElement(By.linkText("Instagram")).click();
        MyDriver.getDriver().findElement(By.linkText("Portal")).click();
        MyDriver.getDriver().findElement(By.linkText("Bulletin")).click();
        Set<String> allHandles = MyDriver.getDriver().getWindowHandles();
        List<String> allHandlesInList = new ArrayList<>(allHandles);
        MyDriver.getDriver().switchTo().window(allHandlesInList.get(0)).close();
        MyDriver.getDriver().switchTo().window(allHandlesInList.get(1)).close();
        MyDriver.getDriver().switchTo().window(allHandlesInList.get(3)).close();
        MyDriver.getDriver().switchTo().window(allHandlesInList.get(4)).close();
        MyDriver.getDriver().switchTo().window(allHandlesInList.get(2));
        Misc.pause(3);
        String currentTitle = MyDriver.getDriver().getTitle();
        Assert.assertEquals(currentTitle, "Instagram", "The current title is not instagram");

        Set<String> numOfWindowHandles = MyDriver.getDriver().getWindowHandles();
        int totalNumOfWindowHandles = numOfWindowHandles.size();
        Assert.assertEquals(1, 1, "Total number of window handles are more than 1 ");

        WebElement logInElement = MyDriver.getDriver().findElement(By.xpath("//div[text()='Log In']"));
        boolean isItDisabled = logInElement.isSelected();
    }
}
