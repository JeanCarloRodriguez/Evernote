@Login
Feature: Login
  Description: scenarios for login

  @loginSuccessful
  Scenario: login successful
  Given I go to the root Page
  And I Go to the log in Page
  When I Login into the web page with a correct email "testautomated91@gmail.com" and the password "Client123"
  Then I am in the main page
    And Im login with the correct user

  Scenario: Log out successful
  Given I log in with the user "testautomated91@gmail.com" and the password "Client123"
  When I log out
  Then a message is displayed confirming the log out


  @loginFailed
  Scenario Outline: Login Unsuccessful
   Given I go to the root Page
   And I Go to the log in Page
   When I Login into the web page with a wrong email "<email>" and the password "<password>"
   Then a message error "<errorMessage>" is displayed for the login failed
   Examples:
   | email               | password | errorMessage |
   |test2122232@gmail.com | Clave321 |Incorrect username and/or password.|
   |fake@gmail.com       | Clave123 |Incorrect username and/or password.|
   |test212223@gmail.com |          |This is a required field.|
   |                     |          |This is a required field.|