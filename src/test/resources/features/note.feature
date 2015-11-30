@note
Feature: Note
  Description: Scenarios for note
  Background:
    Given Im logged in with the user "testautomated91@gmail.com" and the password "Client123"

  @createNotebook
  Scenario: I can create a Note inside a Notebook
    Given I create a NoteBook "First Notebook"
    When I create a Note "My note" for Notebook "First Notebook"
    Then the Note "My note" is in the Note list of "First Notebook" Notebook

  @createNotebook
  Scenario: I can delete a Note
    Given I create a NoteBook "Songs to sing"
      And I create a Note "karaoke" for Notebook "Songs to sing"
    When I delete the Note "karaoke"
    Then a message confirming that a Note was deleted is displayed
      And the Note "karaoke" is not displayed in the list of Notes

  @createNotebook
  Scenario: the newest note should be displayed at the begin of the list of notes when is sorted by "Date Created (newest first)"
    Given I create a NoteBook "Automation tasks"
      And I create a Note "first note" for Notebook "Automation tasks"
      And I create a Note "second note" for Notebook "Automation tasks"
    When I create a Note "last note" for Notebook "Automation tasks"
    Then the Note "last note" is in the Note list of "Automation tasks" Notebook
    When I sort the list of Notes by "Date Created (newest first)"
    Then the "last note" should be at the beginning of the list of Notes