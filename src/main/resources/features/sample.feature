Feature: Search on a website

  Scenario: Searching for a product
    Given I am on the website
    When I search for "Playwright"
    Then I should see search results
