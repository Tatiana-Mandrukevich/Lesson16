package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest {
    //1. Open browser, site http://www.uitestingplayground.com/sampleapp
    //2. Enter value in Username field
    //3. Enter value "pwd" in Password field
    //4. Click 'Log in' button

    @Test
    public void fillRegistrationFieldsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.uitestingplayground.com/sampleapp");
        driver.findElement(By.name("UserName")).sendKeys("User");
        driver.findElement(By.name("Password")).sendKeys("pwd");
        driver.findElement(By.id("login")).click();

        String expectedResult = "Welcome, User!";
        String actualResult = driver.findElement(By.id("loginstatus")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
