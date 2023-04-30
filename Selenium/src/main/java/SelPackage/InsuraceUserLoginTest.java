package SelPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class InsuraceUserLoginTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void login(){
        driver.get("https://demo.guru99.com/insurance/v1/index.php");    // Opening the url (login page)
        driver.findElement(By.name("email")).sendKeys("hiransanjeewaa@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("submit")).click();  // clicking the submit button

        // Explicit waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class=\"btn btn-default\"]")));


        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"content\"]//h4")).getText(),false);

    }

    @AfterTest
    public void teardown(){
       driver.close();   // Closing the chrome tab
        driver.quit();
    }
 }
