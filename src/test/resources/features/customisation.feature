Feature: Customisation of the features

  Background:User has to filter options without notifications in Ajio home page
    Given the user navigates to the home page
    When the user cancel the notification
    And the user select products
    Then Notification got canceled and open user selected products


  Scenario: Verify that the user can view products using five-grid feature
    Given the user filter options by selecting grid options
    When the user select five-grid option to view products
    Then the product results should be displayed in five-grid mode

  Scenario: Verify that the user can redirecting to home page after clicking on homepage button
    Given the user wants to view homepage of ajio
    When the user click on homepage button
    Then the current page redirected to home page


  Scenario: Verify that the user can filter products using relevance feature
    Given the user filter options by selecting relevance
    When the user select discount option to view products
    Then the product results should be displayed according to discount

  Scenario: Verify that user can select a specific product
    Given the user select a product
    When the user selected product results will shown in new window
    Then the product result open in new window
@TC1
  Scenario Outline:Verify that user can able to search products
    Given the user search for products by enter their names
    When the user enter names of the products for "<itemnames>"
    And the user select five-grid option to view selected products
    Then the search items should be displayed
  Examples:
    |itemnames|
    |shoe|
    |watch|








#  Scenario: Verify that the user can filter options using gender
#    Given the user filter options by selecting boys
#    When the user select boys as an option for filter the products
#    Then the product results should be displayed which is belongs to boys





#  Scenario: Verify that the user can filter options using category
#  Given the user filter options by selecting sports shoes
#  When the user select sports shoes as an option to filter the products
#  Then the product results should be displayed which is belongs to sports shoes

#  Scenario: Verify that the user can filter options using price
#    Given the user filter options by selecting price
#    When the user select price Rs.2001-2500 (114) as an option to filter the products
#    Then the product results should be displayed which is belongs to user selected price
