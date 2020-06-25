Feature:  promociones home page

  Scenario: Featred promotions are up to date
    Given I am in Privalia Home Page
    Then All the featured ads are up to date

  Scenario: Currente promotions are up to date
    Given I am in Privalia Home Page
    Then All the current ads are up to date

  Scenario: Comming up promotions don´t have due date
    Given I am in Privalia Home Page
    Then Coming up promotions don´t have a due date

