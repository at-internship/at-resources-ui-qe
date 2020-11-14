@CreateStoriesTest
Feature: Create Stories using the Resources Dashboard

	Background: I am in the add new story form
		Given I am in the Stories Administration page
		When I do click in the AddNewStory button
		Then The AddNewStory form should be displayed
			
		@HappyPath
		Scenario: Create a story correctly
			Given I select a sprint
    		And I select a user
    		And I select a priority
    		And I put a name
    		And I put a description
    		And I put acceptance criteria
    		And I assign story points
    		And I select a start date
    		And I select a due date
			When I do click in the Save button
			Then I should see an alert of successful story creation
				And The story should be found by the search function of the page
				And The story should be found in the DB