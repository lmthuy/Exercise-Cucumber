Feature: Add Multiple Categories to the CMS

  @regression @device_macbook
  Scenario Outline: Add new categories to the CMS
    Given User logged in with email "admin@example.com" and password "123456"
    When User navigates to the "Categories" page
    And User enters the category name "<categoryName>"
    Then the new category "<categoryName>" should be added to the list

    Examples:
      | categoryName                |
      | Smart lights                |
      | Men Clothing                |
      | Home Appliances             |
