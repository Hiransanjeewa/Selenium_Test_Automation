package SelPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InsuraceUserLoginTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void login(){
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
        driver.findElement(By.name("email")).sendKeys("hiransanjeewaa@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("submit")).click();

    }

    @AfterTest
    public void teardown(){
        driver.close();
        driver.quit();
    }
 }
