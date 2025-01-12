package org.example.Lab01Selenium01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestSelenium03 {
    private static final Logger logger = LoggerFactory.getLogger(TestSelenium03.class);
    @Test
    public void test_selenium01(){

// handle the location permissions of browser
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("geo.enabled", true);
        options.addPreference("geo.provider.use_corelocation", true);
        options.addPreference("geo.prompt.testing", true);
        options.addPreference("geo.prompt.testing.allow", true);
        logger.info("Starting Selenium WebDriver");
        // instance of ChromeDriver
        //Open url
        WebDriver driver= new FirefoxDriver(options);
        logger.info("Navigating to hdfcbankWebsite");
        driver.get("https://portaluat.hdfcbank.com:9443/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Get path for WebElement and pass keys into it
        WebElement login=driver.findElement(By.id("liabiltyLoginCustId"));
        login.sendKeys("192598116");
        //Click on Continue Button
        WebElement continueBttn=driver.findElement(By.id("continuelogin"));
        continueBttn.click();
        try{
            WebElement alrdyLogin=driver.findElement(By.xpath("//div[@class='input-box']//p[@class='error-msg ng-binding ng-scope']"));
            if(alrdyLogin.isDisplayed())
            {
                logger.info("Enter a different user id as this is already in  used");
                System.exit(0);

            }
        } catch (Exception e) {
            logger.info("User is not logged in and Programe can be continued");
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Enter Password field
        WebElement password=driver.findElement(By.id("keyboard"));
        password.sendKeys("hdfcbank1");
        //click on secure ID checkbox
        WebElement checkBox=driver.findElement(By.id("secureAccessID"));
       try{

        checkBox.click();}
       catch (Exception NoSuchElementException)
       {
           logger.info("Secure Id  is not present");
       }
        //click Login Button

        WebElement loginbtn=driver.findElement(By.id("loginBtn"));
        loginbtn.click();
       // Assert ast = new Assert();
         // Defining actions class for mousehover
        Actions actions=new Actions(driver);
        logger.info("Starting actions class");
        WebElement pay= driver.findElement(By.xpath("//li[@id='webPay']//a[@title='Pay']"));
        actions.click(pay);
       //TestSelenium01 actions.moveToElement(pay).perform();
        List<WebElement> payoptions = driver.findElements(By.xpath("//li[@id='webPay']//ul[@class='sub-menu-level-1 dropdown-menu megamenu-content']"));

        for(WebElement opt:payoptions){
            System.out.println(opt.getText());

        }



       // driver.quit();
    }
}
