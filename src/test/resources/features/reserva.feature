@tag
Feature: Reservations

	@tag1
  Scenario Outline: Home Page
    Given the user <client> is on the browser
    When the user enters the home page 
    Then the user validates that he is on the home page <home>
    
    Examples: 
      | client  | home 																|
      | Rafael  | Demo Script Test drive - PHPTRAVELS |


	@tag2
	Scenario Outline: Login
		Given the user <vclient> is in the home page
		When the user looks for option Front-End Home Page
		And the user enters the Front-End Home Page <fendpage>
		And the user enters credentials and logs in
		Then the user validates that the username <username> on the user home page
		
		Examples: 
      | vclient   | fendpage    											| username  |
      | Antonio  	| https://www.phptravels.net/	  	  | Demo	  	|
		
	
	
	