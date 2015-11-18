@notebook
Feature: Notebook
  Description: Scenarios for notebook

Background:
 Given I log in with the user "testautomated91@gmail.com" and the password "Client123"

@createNotebook
Scenario: I can create a notebook
  When I create a noteBook called "My notebook1"
  Then A notebook called "My notebook1" is created

Scenario: I can delete a notebook
  #Given I go to the main Page
  Given I create a noteBook called "My notebook2"
  When I delete a notebook called "My notebook2"
  Then the notebook "My notebook2" is not present in the list of notebooks

@createNotebook
@lastScenarioOfFeature
Scenario: At try to create two notebook with the same name a message is displayed
 # Given I go to the main Page
  Given I create a noteBook called "Todo"
  When I create a noteBook called "Todo"
  Then a message error "The notebook title entered already exists. Please choose another title." is displayed at try to created a duplicate notebook name