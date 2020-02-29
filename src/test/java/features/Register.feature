Feature: Register feature
  Background:
    Given I am on the home page for register process
  @register @success
  Scenario:
    When I click register items
    And I fill register forms
    And I press register button
    Then I should see ProfileLink after register
  @register @errorregister
  Scenario:
    When I click register items
    And I fill register forms by mistake
    And I press register button
    Then I should see errorbox
  @register @emailerror @error
  Scenario:
    When I click register items
    And I fill register forms for email by mistake
    And I press register button
    Then I should see errorbox about email
  @register @passworderror @error
  Scenario:
    When I click register items
    And I fill register forms for password by mistake
    And I press register button
    Then I should see errorbox about password