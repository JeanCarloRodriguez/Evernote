@note
Feature: Notes
  Description: notes feature(create, modify, send to trash, delete from trash, share)
Background:
  Given I am in the root Page
    And I Go to the log in Page
    And I Login into the web page with a correct email "alejandrojeancarlo@gmail.com" and the password "motifxf7"


Scenario: a note should be showed at the begin of the list when is created in a noteBook with 2 other notes
Given I have a noteBook called "Automation tasks"
  And the noteBook haves 2 notes called "first note", "second note"
When I create a new note   Called "Last Note"
  And I sort the notes by "Date Created(newest first)"
Then the new note should be created
  And the new note should be at the beginning of the list

Scenario:a entire notebook is removed and then a task is restored, the task should be restored in other notebook
Given I have created notebooks called "First notebook, Second notebook"
  And I have one task in the "First notebook" notebook, called "first task"
  And I remove the notebook "First notebook"
When I restore the task called "First task" from the trash
Then the task "first task" should be in the "Second notebook" notebook

Scenario: two notes are tagged with the word "Jala" and one with the word "Soft", at the moment of search by tag "soft" only one note should be displayed and in the tag menu all the tags are showed with the quantity of tags used
Given I Create notes with the tags: Jala, Jala , Soft
When I Search by the tag "Soft"
Then all the note with the tag "Soft" are showed
  And in the tag menu exists a tag called "Jala" with a value of "2"
  And in the tag menu exists a tag called "soft" with a value of "1"

Scenario: I have a note with an attached file, when I share the note with another account should be able to download from that account
Given I Create a note called "Note with an attached file"
  And I attached a file to the note called "Note with an attached file"
When I Share the note with the account "test222324@gmail.com"
Then is possible to see the note in the account "test222324@gmail.com"
  And is possible to download the file attached

Scenario: Two accounts should be able to chat with each other
Given I have two user accounts logged
When the user "User1" send the message "hello" to the user "User2"
  And the User "User1" share a notebook with the user "User2"
Then the user "User2" should receive the message "hello" from user "User1"
  And the user "User2" should receive a shared notebook
When the user "User2" send the message "hello" to the user "User1"
  And the User "User2" share a notebook with the user "User1"
Then the user "User1" should receive the message "hello" from user "User2"
  And the user "User1" should receive a shared notebook

Scenario: at have a note in the notebook called "To do", should be possible to move this note to another notebook called "Done"
Given I create the notebooks: To do, Done.
  And I create a note in the notebook called "To do"
When I move the note to the notebook "Done"
  Then the note should be in the notebook "Done"


