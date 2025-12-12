Feature: Title of your feature
  I want to use search for the mobile products

  @smoke
  Scenario Outline: Search Iphone Mobile 
		Given open broswer with url
    When search for Product "<SearchTextBox>"
    And click on home search button
    And click and selected "<dropdownOptions>" from dropdown
    And checked the check box
    And click on search button
    And view the iphone 
    And click on home page button
    Then verify navigate back to home page
    
    Examples:
    |	SearchTextBox	|	dropdownOptions	|
		| Mobile				|	Phones & PDAs		|
    
  @smoke
  Scenario Outline: Search product that doesn't matches the search criteria.
		Given open broswer with url
    When search for Product "<SearchTextBox>"
    And click on home search button
    And click and selected "<dropdownOptions>" from dropdown
    And checked the check box
    And click on search button
    Then verify the message "<message>"
    And click on home page button
    And verify navigate back to home page
    
    Examples:
    |	SearchTextBox	|	dropdownOptions	|message																								|
		| Camera				|	Web Cameras			|There is no product that matches the search criteria.	|
		
	@smoke
  Scenario Outline: Search product with empty input
		Given open broswer with url
    When search for Product "<SearchTextBox>"
    And click on home search button
    And click and selected "<dropdownOptions>" from dropdown
    And checked the check box
    And click on search button
    Then verify the message "<message>"
    And click on home page button
    And verify navigate back to home page
    
    Examples:
    |	SearchTextBox	|	dropdownOptions	|message																								|
		| 							|									|There is no product that matches the search criteria.	|

  
