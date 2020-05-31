#Author: ajayas26@gmail.com
@FunctionalTest
Feature: Login Amazon
  
Background: Amazon Home Page
Given Navigate to Home Page
And  Click on signIn button
@RegressionTest
Scenario: Login to Amazon HomePage with valid credential    
When Enter the username and password
Then Validate you are navigated to respective user home page
@RegressionTest
Scenario: Password Reset Assistance
When Click on Need Help Label
And Click on Forget Password
Then Verify you are navigated to Amazon Password Assistance page
@RegressionTest
Scenario: New Account Creation
When Click on Create new  account button
Then Verify you are navigated to new account page
 
