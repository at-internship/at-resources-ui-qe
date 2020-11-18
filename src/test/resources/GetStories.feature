@GetStoriesTest
Feature: Get all the stories using the Resource Dashboard
	@Get1
	Scenario: Get all the stories
		Given I am in the Stories Administration page
		When I compare mongo with stories displayed
		Then I validate the mongodb data and the stories