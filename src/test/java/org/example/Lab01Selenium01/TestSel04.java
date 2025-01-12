package org.example.Lab01Selenium01;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestSel04 {

    @Description("Verify the login functionality of Katalon Cura ")
    @Test
    public void verifyUrl() throws  Exception{
           FirefoxOptions firefoxoption =new FirefoxOptions();
                firefoxoption.addArguments("start-maximized");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("signon.rememberSignons", false);  // Disable password manager

        // Set the preferences
        firefoxoption.addPreference("signon.rememberSignons", false);
        firefoxoption.addPreference("privacy.trackingprotection.enabled", true); // Optional: Enable tracking protection
        WebDriver driver = new FirefoxDriver(firefoxoption);
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.findElement(By.id("btn-make-appointment")).click();
            wait.until(ExpectedConditions.urlContains("/profile.php#login"));
            driver.findElement(By.name("username")).sendKeys("John Doe");
            driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");
            driver.findElement(By.id("btn-login")).click();
           wait.until(ExpectedConditions.urlContains("#appointment"));
           WebElement facilele=driver.findElement(By.id("combo_facility"));
            Select select= new Select(facilele);
            select.selectByValue("Seoul CURA Healthcare Center");
            driver.findElement(By.className("checkbox-inline")).click();
            driver.findElement(By.xpath("//*[@id=\"radio_program_medicaid\"]")).click();
            driver.findElement(By.name("visit_date")).click();
            driver.findElement(By.className("table-condensed")).click();
            WebElement cmt= driver.findElement(By.xpath("//*[@id=\"txt_comment\"]"));
            cmt.sendKeys("efhrrvieljbhfsljvhirdf h[");

            driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
        wait.until(ExpectedConditions.urlContains("appointment.php#summary"));
            String str= driver.findElement(By.xpath("//*[@class='col-xs-12 text-center']/h2")).getText();
        Assert.assertEquals(str,"Appointment Confirmation");

    }
}
