@shortcut
Feature: shortcut
  Description: add a shortcut and remove a shortcut (notes and notebooks)

  Background: login
    Given Im logged in with the user "testautomated91@gmail.com" and the password "Client123"

  @createNotebook
  @addShortcut
  Scenario: I can add a shortcut
    Given I create a NoteBook "Notebook for shortcut1"
      And I create a Note "important note add" for Notebook "Notebook for shortcut1"
    When I add the note to the shortcut list
    Then the note is in the shortcut list

  @createNotebook
  Scenario: a note shortcut can be removed from the list of shortcuts
    Given I create a NoteBook "Notebook for shortcut2"
      And I create a Note "important note remove" for Notebook "Notebook for shortcut2"
      And I add the note to the shortcut list
    When I remove the shortcut from the shortcuts list
    Then the note is not in the shortcut list