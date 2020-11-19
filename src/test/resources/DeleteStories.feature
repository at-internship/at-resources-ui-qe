@Regression
Feature: Delete Stories using the Resources dashboard

  Background: I am in the menu story table
    Given I am in the Stories Administration page

	@Delete1
	Scenario: Delete a story using the dashboard button
    Given I have an existent id
    When I delete a existent story on the dashboard
    Then I should see an alert of successful story deleted
    	And I verify in the dashboard if the story does not exist
