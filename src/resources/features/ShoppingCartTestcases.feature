Feature: Iteams add to cart
  I want to Login into opencart website and Iteams should be added to cart

  @smoke
  Scenario Outline: user added iteam to the cart
    Given open broswer with url
    When click on shopping cart
    And click continue button
    And click on Add To Cart Iteams (Mac Book)
    And click on ItemsCart
    And click on viewcart
    Then verify "<Total>" 
    
    Examples:
		|	Total			|
		|	$602.00		|	
		
		
	