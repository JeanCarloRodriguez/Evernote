@notebook
Feature: Notebook
  Description: Scenarios for notebook

Background:
 Given Im logged in with the user "testautomated91@gmail.com" and the password "Client123"

@createNotebook
Scenario: I can create a notebook
  When I create a NoteBook "My notebook1"
  Then a notebook "My notebook1" is created

Scenario: I can delete a notebook
  Given I create a NoteBook "My notebook2"
  When I delete a notebook "My notebook2"
  Then the notebook "My notebook2" is not present in the list of notebooks

@createNotebook
Scenario: is not allowed to create notebooks with the same name, a message is displayed
  Given I create a NoteBook "Todo"
  When I create a NoteBook "Todo"
  Then a message error is displayed at try to created a duplicate notebook name