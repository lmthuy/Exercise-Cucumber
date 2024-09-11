Feature: CMS dashboard page

  Background: User is logged to the CMS
    Given User logged in with email "admin@example.com" and password "123456"

  @regression @device_Macbook
  Scenario Outline: Open menu
    Given User navigate to dashboard
    When User click "<menu>"
    Then The user redirect to this page "<menu>"
    Examples:
      | menu     |
      | Uploaded Files |
