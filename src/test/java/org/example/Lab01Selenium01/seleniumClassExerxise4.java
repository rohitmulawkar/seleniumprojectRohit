package org.example.Lab01Selenium01;

import ch.qos.logback.core.testUtil.DummyEncoder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class seleniumClassExerxise4 {

    @Test
    public void verifyText() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.idrive360.com/enterprise/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.navigate().to("https://www.bing.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      // driver.findElement(By.xpath("//input[@id='username']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(" augtest_040823@idrive.com");
       driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
       driver.findElement(By.xpath("//*[@class='id-btn id-info-btn-frm']")).click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id-main-container\"]/app-account/section/div[2]/div[2]/h2")));
        WebElement str1= driver.findElement(By.xpath("//*[@class='id-card-title']"));
        String str2= str1.getText();;
        //driver.findElement(By.xpath("//div[@class='intid-card-cont']//*[text()='Your free trial has expired']"));
       System.out.println(str2);
       Assert.assertEquals(str2,"Your free trial has expired");

       // driver.findElement()//*[@class="id-btn id-info-btn-frm"]

    }
}
