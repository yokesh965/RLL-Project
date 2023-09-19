Feature: login to openMRS

@Login_tag
Scenario: Successful Login
Given a user is on the login page of openMRS
When a user enter the username
When a user enter the password
And he choose the location
And he click on the login button
Then User should be logged in successfully