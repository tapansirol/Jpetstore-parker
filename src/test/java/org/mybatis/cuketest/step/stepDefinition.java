/**
 *    Copyright 2010-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.cuketest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.lang.*;

public class stepDefinition {
  WebDriver webDriver = null;

  @Given("^I open chrome browser$")
  public void iOpenChromeBrowser() throws Throwable {
    // webDriver = DriverInitializer.getDriver("chrome");
    System.out.println("open chrome browser");
  }

  @When("^I navigate to index\\.html page$")
  public void iNavigateToIndexHtmlPage() throws Throwable {
    // webDriver.get(DriverInitializer.getProperty("login.url"));
    System.out.println("Navigate to index.html");
  }

  @And("^I click on Enter the store button$")
  public void iClickEnerthestorebutton() throws Throwable {
    // WebElement webElement = webDriver.findElement(By.id("enter"));
    // webElement.click();

    System.out.println("click on Enter the store button");
  }

  @Then("^Store should be visible$")
  public void iStorevisible() throws Throwable {
    System.out.println("Store should be visible");
  }
}
