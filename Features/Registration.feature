#Author: your.email@your.domain.com
Feature: Registration Page

  @Regression
  Scenario: Successful Registration of customer
    Given the user navigates to account registration page
    When user provides the details as below
      | FirstName | Banana        |
      | LastName  | Bhaijaan      |
      | Email     | banana@bj.com |
      | Telehone  |    8956214560 |
      | Password  | Banana@999    |
    And user checks the privacypolicy check box
    And user clicks on the continue button
    Then User account get created successfully
