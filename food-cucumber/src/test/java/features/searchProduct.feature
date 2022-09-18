Feature: Search and Place the order for Products

@PlaceOrder
Scenario: Search Experience for product search in both home and offers page
	Given User is on GreenCart Lading Page
	When user search with Shortname "Tom" and extracted actual name of product
	And user searched for "Tom" shortname in offers page to check if product exist with same name
	Then validate product name in offers page matches with Landing Page