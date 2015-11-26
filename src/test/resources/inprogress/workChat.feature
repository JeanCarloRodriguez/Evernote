@workChat
Feature: workChat
  Description: all the scenarios for work chat
  Background: log in
    Given Im logged in with the user "testautomated91@gmail.com" and the password "Client123"

  @removeConversation
  Scenario: An account should be able to send a message to another account
    Given I Go to the Work Chat tab
    When I send a chat message "Hello my friend" to "alejandrojeancarlo@gmail.com"
    Then a message confirming that a message was send is displayed
      And a conversation with the user "alejandrojeancarlo@gmail.com" is displayed
      And the message "Hello my friend" is displayed for the user "alejandrojeancarlo@gmail.com"

  Scenario: A conversations is able to be removed
    Given I Go to the Work Chat tab
      And I send a chat message "Hello my friend (message to delete scenario)" to "alejandrojeancarlo@gmail.com"
    When I remove the conversation
    Then a conversation with the user "alejandrojeancarlo@gmail.com" is deleted

  Scenario: Two accounts should be able to chat with each other
    Given I Go to the Work Chat tab
      And I send a chat message "Hello alejandrojeancarlo@gmail.com" to "alejandrojeancarlo@gmail.com"
      And I log out
    When Im logged in with the user "alejandrojeancarlo@gmail.com" and the password "motifxf7"
      And I Go to the Work Chat tab
    Then a conversation with the user "testautomated91@gmail.com" is displayed
      And the message "Hello alejandrojeancarlo@gmail.com" is displayed for the user "testautomated91@gmail.com"




  #Scenario: Two accounts should be able to chat with each other
  #  When the user "User1" send the message "hello" to the user "User2"
  #  And the User "User1" share a notebook with the user "User2"
  #  Then the user "User2" should receive the message "hello" from user "User1"
  #  And the user "User2" should receive a shared notebook
  #  When the user "User2" send the message "hello" to the user "User1"
  #  And the User "User2" share a notebook with the user "User1"
  #  Then the user "User1" should receive the message "hello" from user "User2"
  #  And the user "User1" should receive a shared notebook