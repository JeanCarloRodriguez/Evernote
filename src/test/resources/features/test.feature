@note
Feature: Note
  Description: Scenarios for note
  Background:
    Given I log in with the user "testautomated91@gmail.com" and the password "Client123"

  @createNotebook
  Scenario: I can create a note inside a notebook
    Given I create a noteBook called "First Notebook"
    When I create a note "My note" for notebook "First Notebook"
    Then The note "My note" is in the note list of "First Notebook" notebook

  @createNotebook
  Scenario: I can delete a note
    Given I create a noteBook called "for delete"
      And I create a note "note for delete" for notebook "for delete"
    When I delete the note "note for delete"
    Then a message confirming that a note was deleted is displayed
      And the note "for delete" is not displayed in the list of notes