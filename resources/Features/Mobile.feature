#Author: your.email@your.domain.com

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
     