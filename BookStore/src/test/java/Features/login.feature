@Test
Feature: Login in Book Store
  Scenario Outline: Login Book Store
    Given Open the Homepage
    When Send the UsernameAndPassword "<userName>" and "<password>"
    Then LogoutOfApp

    Examples:
      | userName |  | password   |
      | fkarakus |  | Fts124797! |

  @Test
  Scenario Outline: Register Book Store Validate
    Given Open the Homepage
    Then Click the NewUser Button
    Then Give the Firstname "<firstName>"
    Then Give the LastName "<lastName>"
    Then Give the UserName "<userName>"
    Then Give the Password "<password>"
    When Click the Register Button
    Then Validate the Registration "<firstName>","<lastName>","<userName>","<password>"
    Examples:
      | firstName | lastName | userName | password   |
      | Ahmet     | Kaya     | akaya    | Atm124797! |

