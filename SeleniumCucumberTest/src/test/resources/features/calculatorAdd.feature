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
@tag
Feature: Test addition on this website

	Background: Website is open
	Given I have opened the webite

  Scenario Outline: Add on marshus calculator website tool
    Given I want to add <number1> to the first box
    And I want to add <number2> to the second box
    When I press FIND ADDITION
    Then I want to see the <result> on the screen

    Examples: 
      |number1|number2|result	|
      |1 			|1 			|2 			|
  		|10.5		|4.5		|15			|
