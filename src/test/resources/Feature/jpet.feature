Feature: Enter the store

  Scenario: Successful Login to the page
    Given I open chrome browser
    When I navigate to index.html page
    And I click on Enter the store button
    Then Store should be visible