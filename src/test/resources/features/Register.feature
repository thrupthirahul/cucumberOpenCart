Feature: Registration 
  I want to Register the Account
  
  @dev1
  Scenario Outline: Register with the given data
    Given open broswer with url
    When click on My Account option
    And click Register option
    And enter firstname "<firstname>"
    And enter lastname "<lastname>"
    And enter email "<email>"
    And enter telephone "<telephone>"
    And enter password "<password>"
    And enter confirmPassword "<confirmPassword>" 
    And click Subscribe
    And click PolicyOption 
    And click continue button1
    Then Verify Message "<Message>"
    
    Examples:
   |	firstname		|	lastname | email 								| telephone 	| password | confirmPassword	| Message 																													|
   |	Rahul 			| Kumar		 | user@test.com				| 9876543210 	| Test@123 | Test@123 				|	Congratulations! Your new account has been successfully created!		|	
		
		
	@dev1
  Scenario Outline: Register with the existing email
    Given open broswer with url
    When click on My Account option
    And click Register option
    And enter firstname "<firstname>"
    And enter lastname "<lastname>"
    And enter email "<email>"
    And enter telephone "<telephone>"
    And enter password "<password>"
    And enter confirmPassword "<confirmPassword>" 
    And click Subscribe
    And click PolicyOption 
    And click continue button1
    Then Verify Message "<Message>"
    
    Examples:
   |	Register		|	firstname		|	lastname | email 													| telephone 	| password | confirmPassword	| Message 																				|
   |	Register		|	Rahul 			| Kumar		 | thrupthirahul8@gmail.com				| 9876543210 	| Test@123 | Test@123 				|	Warning: E-Mail Address is already registered!	|	
		
		