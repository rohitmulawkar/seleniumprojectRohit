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
import java.util.List;
import java.util.Map;
import java.util.Set;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

    public class BitcoinPriceAPITest {

    @Test
    public void verifyBitcoinPriceAPIResponse() {
        // Define Base URI
        RestAssured.baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json";

        // Send GET request and store the response
        Response response = given()
                .when()
                .get()
                .then()
                .statusCode(200) // Verify status code is 200
                .extract()
                .response();

        // Convert response body to JSON
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Extract specific values from JSON
        String usdCode = response.jsonPath().getString("bpi.USD.code");
        String gbpCode = response.jsonPath().getString("bpi.GBP.code");
        String eurCode = response.jsonPath().getString("bpi.EUR.code");

        // Assertions to verify all three BPIs exist
        Assert.assertEquals(usdCode, "USD", "USD BPI is missing!");
        Assert.assertEquals(gbpCode, "GBP", "GBP BPI is missing!");
        Assert.assertEquals(eurCode, "EUR", "EUR BPI is missing!");

        // Verify GBP description
        String gbpDescription = response.jsonPath().getString("bpi.GBP.description");
        Assert.assertEquals(gbpDescription, "British Pound Sterling", "GBP description is incorrect!");

        System.out.println("All API assertions passed successfully!");
    }
}

