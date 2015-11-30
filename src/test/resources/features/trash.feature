@trash
Feature: trash
  Description: all the scenarios for trash are in this feature
  Background:
    Given Im logged in with the user "testautomated91@gmail.com" and the password "Client123"

  @createNotebook
  Scenario: I can empty all the notes from the trash
  Given I create a NoteBook "For test Trash"
    And I create a Note "note for trash" for Notebook "For test Trash"
    And I delete the Note "note for trash"
  When I go to Trash page
    And I empty all the Notes
  Then the Trash is empty
    And the Notes count says "0 notes"