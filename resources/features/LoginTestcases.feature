Feature: LoginPage Validation
  I want to Login into opencart website

  @smoke
  Scenario Outline: Login with valid username and password
    Given open broswer with url
    When click on My Account option
    And click on "<loginOption>" option
    And enter "<username>" and "<password>"
    And click on login button
    And click on logout button
    And click on continue button
    Then verify navigate back to home page
    
    Examples:
		|	loginOption	|	username									|password	|
		|	Login				|	thrupthirahul8@gmail.com	|Rahul@28	|
		
		
	@smoke
  Scenario Outline: Login with invalid username and password
    Given open broswer with url
    When click on My Account option
    And click on "<loginOption>" option
    And enter "<username>" and "<password>"
    And click on login button
    Then verify message "<message>"
    And click on home page button
    Then verify navigate back to home page
    
    Examples:
		|	loginOption	|	username									|password	|	message																								|
		|	Login				|	thrupthirahul@gmail.com		|Rahul 		|	Warning: No match for E-Mail Address and/or Password.	|
		
		