@tag
Feature: Dell Website

  @tag1
  Scenario: HomePage
    Given User should be on Home Page.
    When User hover on Laptops.
    And User click on For Home.
    And User scroll down on HomePage.
    And User click on Explore Inspiron.
    Then User should land on Explore Inspiron page.
    And User should navigate to Home Page.