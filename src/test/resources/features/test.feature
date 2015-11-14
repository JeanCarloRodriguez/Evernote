@notebook
Feature: Notebook
  Description: Scenarios for notebook
  Background:
    Given I go to the root Page
    And I Go to the log in Page
    And I Login into the web page with a correct email "testautomated91@gmail.com" and the password "Client123"

  Scenario: I can create a notebook and after delete this notebook
    Given I create a noteBook called "First Notebook"
    When I create a note called "My note" in "First Notebook" notebook
#Todo the assertion

#    When I delete a notebook called "My notebook"
#    Then the notebook "My notebook" is not present in the list of notebooks