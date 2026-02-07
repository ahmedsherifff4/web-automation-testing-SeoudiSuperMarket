Feature: Cart Functionality
  Background:
  Given user has selected their location
  Scenario: Verify that the item quantity after increasing the item by 1 is 2 in the cart page
    Given user has an item selected from products page
    When user is on the cart page
    And user increments an item quantity by 1
    Then the item count should be 2

  Scenario: Verify that the item quantity after decreasing the item by 1 is 1 in the cart page
    Given user has an item selected from products page
    When user increments an item quantity by 1 while on the cart page
    And user decrements an item quantity by 1
    Then the item count should be 1

  Scenario: Verify that a message "Your Cart is Empty" is displayed when the user removes the last item in the cart
    Given user has an item selected from products page
    When user is on the cart page
    And user removes the last item
    Then a message "Your Cart is Empty" is displayed

  Scenario: Verify That when the cart contains 2 items and the user removes 1 item the other item is not removed
    Given user has 2 items selected from products page
    When user is on the cart page
    And user removes one item
    Then the other item is not removed

  Scenario: Verify that the subtotal and total in the cart page contain "EGP"
    Given user adds an item to the cart
    When user is on the cart page
    Then subtotal and total contain "EGP"

  Scenario: Verify that "Checkout" button works where user is redirected to checkout page when clicked on
    Given user has an item selected from products page
    When user is on the cart page
    And user clicks on "Checkout" button
    Then user is redirected to checkout page

  Scenario: Verify that "Continue Shopping" button works where user is redirected to products page when clicked on
    Given user has an item selected from products page
    When user is on the cart page
    And user clicks on "Continue Shopping" button
    Then user is redirected to products page

  Scenario: Verify that an error message is displayed when the user enters an invalid Promo code
    Given user has an item selected from products page
    When user is on the cart page
    And user enters an invalid Promo code
    Then an error message is displayed