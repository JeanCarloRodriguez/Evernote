@note
Feature: Note
  Description: Scenarios for note
  Background:
    Given Im logged in with the user "testautomated91@gmail.com" and the password "Client123"

  @createNotebook
  Scenario: I can create a note inside a notebook
    Given I create a noteBook "First Notebook"
    When I create a note "My note" for notebook "First Notebook"
    Then the note "My note" is in the note list of "First Notebook" notebook

  @createNotebook
  Scenario: I can delete a note
    Given I create a noteBook "Songs to sing"
      And I create a note "karaoke" for notebook "Songs to sing"
    When I delete the note "karaoke"
    Then a message confirming that a note was deleted is displayed
      And the note "karaoke" is not displayed in the list of notes

  Scenario: a note should be showed at the begin of the list when is created in a noteBook with 2 other notes
    Given I create a noteBook "Automation tasks"
      And I create a note "first note" for notebook "Automation tasks"
      And I create a note "second note" for notebook "Automation tasks"
    When I create a note "last note" for notebook "Automation tasks"
    Then the note "last note" is in the note list of "Automation tasks" notebook
    When I sort the list of notes by "Date Updated (newest first)"
    Then the new note should be at the beginning of the list