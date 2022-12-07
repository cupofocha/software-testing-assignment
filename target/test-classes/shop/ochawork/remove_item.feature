Feature: Saucedemo webshop cart removing items testing

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the Login button is clicked
    And side Menu is clicked
    And reset Link is clicked
    And page is refreshed
    And the "Sauce Labs Backpack" is added to the cart
    And the "Sauce Labs Bike Light" is added to the cart
    And the "Sauce Labs Bolt T-Shirt" is added to the cart
    And the "Sauce Labs Fleece Jacket" is added to the cart

    Scenario Outline: remove one item
      And the '<item>' is removed
      And the cart icon is clicked
      And the checkout button is clicked
      And the First Name is filled with 'A'
      And the Last Name is filled with 'B'
      And the Zip Code is filled with '1234'
      When the Continue button is clicked
      Then '<price>' should be shown
      Examples:
        | item                     | price          |
        | Sauce Labs Backpack      | Total: $82.05  |
        | Sauce Labs Bike Light    | Total: $103.65 |
        | Sauce Labs Bolt T-Shirt  | Total: $97.17  |
        | Sauce Labs Fleece Jacket | Total: $60.45  |

