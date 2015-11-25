@workChat
Feature: workChat
  Description: all the scenarios for work chat

  Scenario: Two accounts should be able to chat with each other
    Given Im logged in with the user "testautomated91@gmail.com" and the password "Client123"
    When I send a chat message "Hello my friend" to "alejandrojeancarlo@gmail.com"
    Then a message confirming that a message was send is displayed


    When the user "User1" send the message "hello" to the user "User2"
    And the User "User1" share a notebook with the user "User2"
    Then the user "User2" should receive the message "hello" from user "User1"
    And the user "User2" should receive a shared notebook
    When the user "User2" send the message "hello" to the user "User1"
    And the User "User2" share a notebook with the user "User1"
    Then the user "User1" should receive the message "hello" from user "User2"
    And the user "User1" should receive a shared notebook