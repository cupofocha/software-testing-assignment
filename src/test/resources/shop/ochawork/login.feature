Feature: Saucedemo login function testing

  Background:
    Given the homepage is open

    Scenario Outline: Invalid Login attempts
      And the Username is filled with '<username>'
      And the Password is filled with '<password>'
      When the Login button is clicked
      Then the Login error should be shown
      Examples:
        | username                | password     |
        | user                    | secret_sauce |
        | standard_user           | password     |
        | problem_user            | password     |
        | performance_glitch_user | password     |

    Scenario Outline: Valid Login attempts
      And the Username is filled with '<username>'
      And the Password is filled with '<password>'
      When the Login button is clicked
      Then Login should be successful
      Examples:
        | username                | password     |
        | standard_user           | secret_sauce |
        | problem_user            | secret_sauce |
        | performance_glitch_user | secret_sauce |

    Scenario: Locked out user Login
      And the Username is filled with "locked_out_user"
      And the Password is filled with "secret_sauce"
      When the Login button is clicked
      Then the Locked out error should be shown


    Scenario Outline: Valid Logout via different accounts
      And the Username is filled with '<username>'
      And the Password is filled with '<password>'
      And the Login button is clicked
      And side Menu is clicked
      When the Logout link is clicked
      Then Logout should be successful
      Examples:
        | username                | password     |
        | standard_user           | secret_sauce |
        | problem_user            | secret_sauce |
        | performance_glitch_user | secret_sauce |