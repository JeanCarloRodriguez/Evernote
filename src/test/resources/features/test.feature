@note
Feature: Notes
  Description: notes feature(create, modify, send to trash, delete from trash, share)
  Background:
    Given I Go to the log in Page
    And I Login into the web page with the email "test212223@gmail.com" and the password "Clave123"

  Scenario: a note should be showed at the begin of the list when is created in a noteBook with 2 other notes
    Given I have a noteBook called "Automation tasks"

  Scenario Outline: Login Unsuccessful
    Given I Go to the log in Page
    When I Login into the web page with the email "<email>" and the password "<password>"
    Then a message error "<errorMessage>" is displayed for the log
  Examples:
    | email               | password | errorMessage |
    |test212223@gmail.com | Clave321 |Incorrect username and/or password.|
    |fake@gmail.com       | Clave123 |Incorrect username and/or password.|
    |test212223@gmail.com |          |This is a required field.|
    |                     |          |This is a required field.|





  //Scenario Outline: Login Unsuccessful
  // Given I Go to the log in Page
  // When I Login into the web page with the email "<email>" and the password "<password>"
  // Then a message error "<errorMessage>" is displayed for the login failed
  // Examples:
  // | email               | password | errorMessage |
  // |test212223@gmail.com | Clave321 |Incorrect username and/or password.|
  // |fake@gmail.com       | Clave123 |Incorrect username and/or password.|
  // |test212223@gmail.com |          |This is a required field.|
  // |                     |          |This is a required field.|