Feature: Add new address after login
  Scenario Outline: Fill up required information

    Given User is logged in to the shop
    When Logged user goes to address
    And User add "<alias>", "<address>", "<city>", "<post code>", "<country>" and "<phone>"
    And User saves all information
    And New address is added and equals "<alias>", "<address>", "<city>", "<post code>", "<country>" and "<phone>"
    Then Logged user deleted address and can see "Address successfully deleted!"

    Examples:
      | alias       | address  | city   | post code | country        | phone      |
      | superwoman5 | 12A Road | London | KK1 2CV   | United Kingdom | 0123456789 |