#Author: SudeeptaDash
Feature: Login with Valid Credentials

  #@sanity @regression
  #Scenario: Successful Login with Valid Credentials
    #Given the user navigates to login page
    #When user enters email as "apple@ap.com" and password as "Apple@01"
    #And the user clicks on the Login button
    #Then the user should be redirected to the MyAccount Page

  @sanity @regression
  Scenario Outline: Successful Login with Valid Credentials
    Given the user navigates to login page
    When user enters email as "<Email>" and password as "<Password>"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page

    Examples: 
      | Email         | Password   |
      | apple@ap.com  | Apple@01   |
      | banana@bj.com | Banana@999 |
