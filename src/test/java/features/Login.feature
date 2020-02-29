Feature: LoginFeature

  Background:
    Given I am on the home page

  @Invalid @login
  Scenario Outline: Invalid
    When I click login items
    And I enter username "<userName>" and password "<Password>"
    And I click login button
    Then I should see response
    Examples:
      | userName       | Password  |
      | sevilay.agil   | Password1 |
      | testautomation | 12345667  |
      | trendyoldolap  | Password3 |

  @login @missing
  Scenario: MissingUserOrPassword
    When I click login items
    And I fill username for missing
    And  I fill password for missing
    And I click login button
    Then I should see response

  @login @success
  Scenario: SuccessfulLogin
    When I click login items
    And I fill username for successful
    And  I fill password for successful
    And I click login button
    Then I should see ProfileLink