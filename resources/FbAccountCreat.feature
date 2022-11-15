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

Feature: Account Creation
#	Scenario: Facebook Account Creation
    #Given user goto facebook page
    #And clear cach and cookies
    #When user select create new account 
    #And fill the signup page
    #And fill the date of birth
    #And select gender
    #Then I validate the outcomes
  
  #Scenario: Facebook Account Creation
    #Given user goto facebook page
    #And clear cach and cookies
    #When user select create new account 
    #And fill the signup page by using oneD map
    #|firstname|saravanan|
    #|surename|p|
    #|email|vivekbabudeee@gmail.com|
    #|New Password|Creat@123|
    #And fill the date of birth by using oneD map
    #|day|12|
    #|month|Jan|
    #|year|1990|
    #And select gender by using oneD list
    #|Female|Male|Custom|
    #And take screen shot
    #Then I validate the outcomes
     
     
   

  
  Scenario Outline: Facebook Account Creation
    Given user goto facebook page
    And clear cach and cookies
    When user select create new account 
    And fill the signup page "<firstname>","<surename>","<email>","<Reemail>","<New Password>"
    And fill the date of birth "<day>", "<month>", "<year>"
    And select gender "<gender>"
    Then I validate the outcomes
    
    Examples: 
    |firstname|surename|email|Reemail|New Password|day|month|year|gender|
    |vivekbabu|P|vivekbabudeee@gmail.com|vivekbabudeee@gmail.com|Create@123|9|Jul|1991|Male|
    |saravanan|P|sarwanRTR@gmail.com|sarwanRTR@gmail.com|Creat@123|12|Jan|1990|Male|
    
    #|gender|
    #|Female|
    #|Male|
    #|Custom|
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
