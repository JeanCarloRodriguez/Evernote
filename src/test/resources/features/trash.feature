@trash
Feature: trash
  Description: all the scenarios for trash are in this feature
  Background:
    Given Im logged in with the user "testautomated91@gmail.com" and the password "Client123"

  @createNotebook
  Scenario: I can empty all the notes from the trash
  Given I create a noteBook "For test Trash"
    And I create a note "note for trash" for notebook "For test Trash"
    And I delete the note "note for trash"
  When I go to trash page
    And I empty all the notes
  Then the trash is empty
    And the notes count says "0 notes"