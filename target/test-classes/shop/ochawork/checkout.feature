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

  Scenario Outline: invalid checkout attempts
    And the cart icon is clicked
    And the checkout button is clicked
    And the First Name is filled with '<first_name>'
    And the Last Name is filled with '<last_name>'
    And the Zip Code is filled with '<zip_code>'
    When the Continue button is clicked
    Then check out error '<error>' should be shown
    Examples:
      | first_name | last_name | zip_code | error                          |
      | George     | Bush      |          | Error: Postal Code is required |
      | Joe        |           | 1234     | Error: Last Name is required   |
      |            | Biden     |          | Error: First Name is required  |
      |            |           | 1234     | Error: First Name is required  |

  Scenario Outline: valid checkout attempts
    And the cart icon is clicked
    And the checkout button is clicked
    And the First Name is filled with '<first_name>'
    And the Last Name is filled with '<last_name>'
    And the Zip Code is filled with '<zip_code>'
    When the Continue button is clicked
    Then 'Total: $114.44' should be shown
    Examples:
      | first_name | last_name | zip_code |  |
      | George     | Bush      | 1234     |  |
      | Joe        | Biden     | 1234     |  |
      | Dave       | Li        | 1234     |  |
      | Peter      | Griffin   | 5678     |  |