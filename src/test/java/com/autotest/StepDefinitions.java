package com.autotest;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    public static WebDriver driver;
    String baseURL = "https://www.google.com";

    @Given("^user launches Google webapp$")
    public void user_launches_Google_webapp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @When("^user searches for a \"([^\"]*)\"$")
    public void user_searches_for_a(String arg1) throws Throwable {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(arg1);
    }

    @And("^click on search button$")
    public void click_on_search_button() throws Throwable {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.submit();
    }
    
    @Then("^results retrieved should contain the \"([^\"]*)\" used$")
    public void results_retrieved_should_contain_the_used(String string) {
        WebElement result = driver.findElement(By.className("LC20lb"));
        if (StringUtils.containsAny(result.getText(), string)) {
            System.out.println("Text is matching");
        } else {
            System.out.println("Text is not matching");

        }
        driver.quit();
    }

}