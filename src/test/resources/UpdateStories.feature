@UpdateStoriesTest
Feature: Update Stories using the Resources Dashboard

	Background: I am in the add new story form
		Given I am in the Stories Administration page
			And I select a random story to edit
		When I do click in the Edit Story button
		Then The EditStory form should be displayed
			
		@U1
		Scenario: Update the name of the story
			Given I put a new name
			When I do click in the Update button
			Then I should see an alert of successful story Update
				And I should see the changes in the Stories Module
				And I should see the changes in the Mongo DB