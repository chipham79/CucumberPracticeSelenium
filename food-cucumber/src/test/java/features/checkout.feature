Feature: Place the order for Products
	
	@Checkout
  Scenario Outline: Search Experience for product search in both home and offers page
  
	Given User is on GreenCart Lading Page
	When user search with Shortname <Name> and extracted actual name of product
	And added "3" items of the selected product to cart
	Then user proceed to checkout and validate the <Name> items in checkoutpage
	And verify user has ability to enter promo code and place the order
	
	Examples:
	|Name |
	|Tom	|
	|Bean	|
