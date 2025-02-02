package org.example.Lab01Selenium01;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EbayExerciseChrome {

    @Description("Verify the login functionality of Katalon Cura ")
    @Test
    public void verifyCartUpdate() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open eBay and maximize window
            driver.get("https://www.ebay.com/");
            driver.manage().window().maximize();

            // Initialize Explicit Wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate the search input box and perform search
            WebElement searchBox = driver.findElement(By.xpath("//*[@placeholder='Search for anything']"));
            searchBox.click();
            searchBox.sendKeys("book");

            // Click the search button
            driver.findElement(By.xpath("//*[@value='Search']")).click();

            // Wait until the URL changes to the search results page
            wait.until(ExpectedConditions.urlContains("sch/i.html?_nkw=book&_sacat=0"));

            // Click on the first book result
            WebElement firstBook = driver.findElement(By.xpath("//*[@class='srp-results srp-list clearfix']/li[1]/div/div[2]/a"));
            firstBook.click();

            // Handle multiple windows (Switch to the new tab)
            String parentWindow = driver.getWindowHandle();
            for (String window : driver.getWindowHandles()) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            // Wait to ensure page is loaded (Better to replace Thread.sleep with WebDriverWait)
            Thread.sleep(3000);

            // Click on "Add to Cart" button
            WebElement addToCartButton = driver.findElement(By.id("atcBtn_btn_1"));
            addToCartButton.click();

            // Verify if the cart is updated
            WebElement cartItemCount = driver.findElement(By.xpath("//*[@id='gh']/nav/div[2]/div[4]/div/a/span/span"));
            String cartCount = cartItemCount.getText();

            // Assertion to verify cart update
            Assert.assertEquals(cartCount, "1", "Cart update verification failed!");

            System.out.println("The Cart is successfully updated, and the test case has passed.");

        } catch (Exception e) {
            System.err.println("Test encountered an error: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }

}
