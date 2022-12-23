#Author: your.email@your.domain.com

@tv
Feature: Tv

Background:
	Given user login to flipkart
	@st1
  Scenario: Tv purchase
    When user search Tv
    And user choose the Tv
    And user doing payment by using UPI
    Then user receives confirmation message
    
    #@st2
  #Scenario: Tv purchase
#		When user search Tv by using oneD List
    #|Realme Tv|mi Tv|Samsung Tv|
    #And user choose the Tv
    #And user doing payment by using UPI
    #Then user receives confirmation message
    #
  #@st3
   #Scenario: Tv purchase
    #Given user login to flipkart
    #When user search Tv by using oneD map
    #|phone1|Realme Tv|
    #|phone2|mi Tv|
    #|phone3|Samsung Tv|
    #And user choose the Tv
    #And user doing payment by using UPI
    #Then user receives confirmation message
    #
#@st4
  #Scenario Outline: Tv purchase
    #Given user login to flipkart
    #When user search Tv "<Tv>"
    #And user choose the Tv
    #And user doing payment by using UPI
    #Then user receives confirmation message
#
    #Examples: 
    #|Tv|
    #|Realme Tv|
    #|mi Tv|
    #|Samsung Tv|
    #
    