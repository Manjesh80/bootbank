package com.shivbank;

import com.shivbank.CoreservicesApplication;
import com.shivbank.TestMockBeansConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 2/9/2017.
 */
@WebAppConfiguration
@SpringBootTest(classes = {CoreservicesApplication.class, TestMockBeansConfig.class})
public class TestStepdefs {

    @Given("you know cucumber")
    public void you_know_cucumber() {
        System.out.println("you_know_cucumber");
    }

    @When("the ide is ready")
    public void the_ide_is_ready() throws Exception {
        System.out.println("the_ide_is_ready");
    }

    @Then("start coding")
    public void start_coding() throws Throwable {
        System.out.println("start_coding");
    }
}
