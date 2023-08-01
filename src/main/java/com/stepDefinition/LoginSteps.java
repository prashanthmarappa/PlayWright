package com.stepDefinition;

import com.microsoft.playwright.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.*;

@SpringBootConfiguration
public class LoginSteps {

    @Autowired
    private Browser browser;

    private Page page;

    @Before
    public void setUp() {
        page = browser.newPage();
    }

    @Given("I am on the website")
    public void goToWebsite() {
        page.navigate("https://example.com");
    }

    @When("I search for {string}")
    public void searchFor(String keyword) {
        page.fill("input[name='search']", keyword);
        page.press("input[name='search']", "Enter");
    }

    @Then("I should see search results")
    public void verifySearchResults() {
        // Add assertions to verify search results
    }

    @After
    public void tearDown() {
        browser.close();
    }
}
