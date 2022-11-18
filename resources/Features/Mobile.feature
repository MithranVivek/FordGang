#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@mobile
Feature: Mobile
 
Background:
	Given user login to flipkart
@sm1
  Scenario: mobile purchase
  Given user login to flipkart
    When user search mobile
    And user choose the mobile
    And user doing payment by using UPI
    Then user receives confirmation message
@sm2
  Scenario: mobile purchase
    When user search mobile by using oneD List
    |Realme|Iphone|Samsung mobile|
    And user choose the mobile
    And user doing payment by using UPI
    Then user receives confirmation message
@sm3
  Scenario: mobile purchase
    When user search mobile by using oneD map
    |phone1|Realme|
    |phone2|Iphone|
    |phone3|Samsung mobile|
    And user choose the mobile
    And user doing payment by using UPI
    Then user receives confirmation message
@sm4
  Scenario Outline: mobile purchase
    When user search mobile "<phone>"
    And user choose the mobile
    And user doing payment by using UPI
    Then user receives confirmation message

    Examples: 
    |phone|
    |Realme|
    |iphone|
    |Samsung Mobile|
     