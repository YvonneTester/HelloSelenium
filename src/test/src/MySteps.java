package org.example.tests;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySteps {

    WebDriver webDriver = new FirefoxDriver();
    WebElement archiveLink;

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        // do HTTP GET (navigate) to the project euler homepage
        webDriver.get("https://projecteuler.net/");
    }

    @Given("There is a menu option Archives")
    public void there_is_a_menu_option_archives() {
        // Get the archives menu element, we use a cssSelector
        //  tip: use your browser dev tools to find this, and or test it in your browser console
        //       `document.querySelector("#container > nav > ul > li > a[href='archives']")`
        archiveLink = webDriver.findElement(By.cssSelector("#container > nav > ul > li > a[href=\"archives\"]"));

        // Validate that the text of the link is 'Archives'
        Assertions.assertEquals("Archives", archiveLink.getText());
    }

    @When("I go navigate to Archives")
    public void i_go_navigate_to_archives() {
        archiveLink.click();
    }

    @Then("The first item should be Multiples of 3 or 5")
    public void theFirstItemShouldBe() {
        WebElement firstProblem = webDriver.findElement(By.cssSelector("#problems_table > tbody > tr:nth-child(2) > td:nth-child(2) > a"));

        Assertions.assertEquals("Multiples of\n" +
                "3\n" +
                "or\n" +
                "5", firstProblem.getText());
    }

    @After // runs after all tests, we clean up stuff here
    public void CleanUp() {
        //always close your web driver
        webDriver.close();
    }
}