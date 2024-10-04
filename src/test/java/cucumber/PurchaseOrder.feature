
@tag
Feature: Purchase the order from e commerce website
  I want to use this template for my feature file
Background:
Given I landed on the ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given I logged in with username <name> and <Password>
    When I add product to the cart
    And checkout and submit the order
    Then "Thank you message" should appear on screen

    Examples: 
      | name  | Password|
      | test34@gmail.com |  Testing21 |
      