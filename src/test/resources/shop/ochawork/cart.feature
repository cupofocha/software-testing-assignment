Feature: Saucedemo webshop cart testing

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the Login button is clicked

    Scenario Outline: Add multiple items
      Given the '<item>' is added to the cart
      And the cart icon is clicked
      And the checkout button is clicked
      And the First Name is filled with 'A'
      And the Last Name is filled with 'B'
      And the Zip Code is filled with '1234'
      When the Continue button is clicked
      Then '<price>' should be shown
      Examples:
        | item                     | price          |
        | Sauce Labs Backpack      | Total: $32.39  |
        | Sauce Labs Bike Light    | Total: $43.18  |
        | Sauce Labs Bolt T-Shirt  | Total: $60.45  |
        | Sauce Labs Fleece Jacket | Total: $114.44 |

    Scenario Outline: Add one item
      Given side Menu is clicked
      And reset Link is clicked
      And page is refreshed
      And the '<item>' is added to the cart
      And the cart icon is clicked
      And the checkout button is clicked
      And the First Name is filled with 'A'
      And the Last Name is filled with 'B'
      And the Zip Code is filled with '1234'
      When the Continue button is clicked
      Then '<price>' should be shown
      Examples:
        | item                     | price         |
        | Sauce Labs Backpack      | Total: $32.39 |
        | Sauce Labs Bike Light    | Total: $10.79 |
        | Sauce Labs Bolt T-Shirt  | Total: $17.27 |
        | Sauce Labs Fleece Jacket | Total: $53.99 |