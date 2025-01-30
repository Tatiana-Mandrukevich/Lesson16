package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest {
    //1. Open browser, site https://the-internet.herokuapp.com/login
    //2. Enter value "tomsmith" in Username field
    //3. Enter value "SuperSecretPassword!" in Password field
    //4. Click 'Login' button

    @Test
    public void fillRegistrationFieldsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

        String expectedResult = "Logout";
        String actualResult = driver.findElement(By.xpath("//*[@class=\"button secondary radius\"]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
