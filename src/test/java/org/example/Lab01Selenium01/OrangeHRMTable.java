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
import java.util.List;

public class OrangeHRMTable {
    @Test
    public void verifyText() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.navigate().to("https://www.bing.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // driver.findElement(By.xpath("//input[@id='username']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rohitrm");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin@123");
        driver.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"oxd-topbar-header-title\"]")));

// //*[@class="oxd-topbar-header-title"]
        List<WebElement> table= driver.findElements(By.xpath("//*[@class=\"oxd-topbar-header-title\"]"));
        //String str2= str1.getText();;
        //driver.findElement(By.xpath("//div[@class='intid-card-cont']//*[text()='Your free trial has expired']"));
        //System.out.println(str2);
      //  Assert.assertEquals(str2,"Your free trial has expired");

        // driver.findElement()//*[@class="id-btn id-info-btn-frm"]

    }
}
