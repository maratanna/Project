Feature: Second task
  Scenario Outline: Buy Hummingbird Printed Sweater

    Given User is logged into examplary shop
    When User choose item
    And User choose "<size>" and "<quantity>"
    And User choose checkout option
    And User confirm delivery address
    And User choose payment method and obligation to pay
    And System will do screenshoot with order confirmation
    Then Check orders history

    Examples:
      | size | quantity|
      | L    | 52       |
