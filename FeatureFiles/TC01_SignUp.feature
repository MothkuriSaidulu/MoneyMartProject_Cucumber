Feature: SignUp

  Background: 
    Given User Launch The Brower
    When User Entered Url "https://qac.moneymart.ca/home"

  @SignUp
  Scenario: TC01 Verify User is able Create Maney Mart Account
    And User Clicked On SignIn Signup Option
    And User Clicked On Sign Up Now Option
    Then User Enter the details
    And User Clicked On Creat Account button
    And Close The browser
