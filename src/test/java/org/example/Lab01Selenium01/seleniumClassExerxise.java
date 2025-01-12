package org.example.Lab01Selenium01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class seleniumClassExerxise {

    @Test
    public void verifyText(){
        WebDriver driver =new ChromeDriver();
        driver.get("https://katalon.com/katalon-studio?utm_term=katalon%20studio&utm_campaign=IN_Search_Brand_KatalonStudio&utm_source=adwords&utm_medium=search&hsa_acc=4390546474&hsa_cam=22025659653&hsa_grp=171444974879&hsa_ad=725720045747&hsa_src=g&hsa_tgt=kwd-466633575824&hsa_kw=katalon%20studio&hsa_mt=p&hsa_net=adwords&hsa_ver=3&gad_source=1&gclid=Cj0KCQiA9667BhDoARIsANnamQY5U3W8-qielFU7rtEe451WxGkvAd6UKT1b7ROUF_HlgXjyprPHRxgaAi2cEALw_wcB");
        driver.manage().window().maximize();
        WebElement element= driver.findElement(By.xpath("//*[@class='hero-a__left--container']/h1"));
        Assert.assertEquals("The way software testing should be",element.getText());
        if (driver.getPageSource().contains("The way software testing should be")){
            Assert.assertTrue(true);

        }


    }
}
