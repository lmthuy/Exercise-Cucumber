Feature: Login Test CMS

   Background: Navigate to Admin Login page
      Given User is on the Admin Login Page "https://cms.anhtester.com/login"

   @regression @device_Macbook
   Scenario: Successful login
      When user logs in with "admin@example.com" and "123456"
      And click Login button
      Then user is redirected to the Dashboard
