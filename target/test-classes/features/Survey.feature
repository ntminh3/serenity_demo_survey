Feature: Take survey demo

  Scenario: User answer the survey
    Given User go to survey page
    When User select "Good"
    And User submit the answer
    Then User should see "Have a nice day." message
    When User go to previous page
    Then Button "Good" should be clicked
    And Button "Bad" should not be clicked
    And Button "Okay" should not be clicked
    When User select "Bad"
    And User submit the answer
    Then User should see "Have a nice day." message