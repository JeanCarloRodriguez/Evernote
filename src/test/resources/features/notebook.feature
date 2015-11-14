@notebook
Feature: Notebook
  Description: Scenarios for notebook
Background:
  Given I go to the root Page
    And I Go to the log in Page
    And I Login into the web page with a correct email "testautomated91@gmail.com" and the password "Client123"

Scenario: I can create a notebook and after delete this notebook
  When I create a noteBook called "My notebook"
  Then A notebook called "My notebook" is created
  When I delete a notebook called "My notebook"
  Then the notebook "My notebook" is not present in the list of notebooks

Scenario: At create two notebook with the same name a message is displayed
  Given I create a noteBook called "Todo"
  When I create a noteBook called "Todo"
  Then a message error "The notebook title entered already exists. Please choose another title." is displayed at try to created a duplicate notebook name
    And I delete a notebook called "Todo"

