@notebook
Feature: Notebook
  Description: Scenarios for notebook

Background:
 Given Im logged in with the user "testautomated91@gmail.com" and the password "Client123"

@createNotebook
Scenario: I can create a notebook
  When I create a noteBook "My notebook1"
  Then a notebook "My notebook1" is created

Scenario: I can delete a notebook
  Given I create a noteBook "My notebook2"
  When I delete a notebook "My notebook2"
  Then the notebook "My notebook2" is not present in the list of notebooks

@createNotebook
Scenario: At try to create two notebook with the same name a message is displayed
  Given I create a noteBook "Todo"
  When I create a noteBook "Todo"
  Then a message error is displayed at try to created a duplicate notebook name