Feature: Customisation of the features

  Background:User has to filter options without notifications in Ajio home page
    Given the user navigates to the home page
    When the user cancel the notification
    And the user select products
    Then Notification got canceled and open user selected products

  #testcase_1
  Scenario: Verify that the user can redirecting to home page after clicking on homepage button
    Given the user wants to view homepage of ajio
    When the user click on homepage button
    Then the current page redirected to home page

#testcase_2
  Scenario: Verify that the user can filter products using relevance feature
    Given the user filter options by selecting relevance
    When the user select discount option to view products
    Then the product results should be displayed according to discount

#testcase_3
  Scenario Outline:Verify that user can able to search products
    Given the user search for products by enter their names
    When the user enter names of the products for "<item_names>"
    Then the search items should be displayed as item as "<Result>"
  Examples:
    |item_names| Result |
    |shoe| Footwear     |
    |watch|  Watches    |

  #testcase_4
#  Scenario: Verify that the user can able to redirect to specified page
#    Given the user select men's clothing page
#    When the user click on the men's clothing page
#    Then the home page should redirected to men's clothing page

  @smoke
    #testcase_5
  Scenario: Verify that the user can able to redirect to selected product
    Given the user select hand bags
    When the user click on the hand bags
    And sorted by using relevance
    Then the home page should redirected to hand bags page

    #testcase_6
  Scenario: Verify that user can search for a product using search bar
    Given the user search for products by enter item names
    When the user search for a specific product
    Then the required items should be shown







