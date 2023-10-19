@Registration
Feature: Digital Bank Registration Page

  Background:
    Given The the user with "miguel1@test.co" is not in DB
    And  user navigates to Digital Bank signup page


@Test
  Scenario: Positive Case. As a user, I want to create Digital Bank Account
    When User creates account with following fields
      | title | firstName | lastName | gender | dob        | ssn         | email           | password      | address         | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | termsCheckMark | accountNonExpired | accountNonLocked |  credentialNonExpired |
      | Mr.   | Miguel    | Test     | M      | 12/12/1990 | 607-21-8165 | miguel1@test.co | Password12345 | 124 Main street | City     | CA     | 99921      | USA     | 2146599013 | 2146599043  | 8056374532 | true           |  true              | true             | true                  |
    Then user should be displayed with the message "Success Registration Successful. Please Login."
    Then the following user info should be saved in the db
      | title | firstName | lastName | gender | dob        | ssn         | email           | password      | address         | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  |termsCheckMark | accountNonExpired | accountNonLocked |  credentialsNonExpired | enabled |
      | Mr.   | Miguel    | Test     | M      | 12/12/1990 | 607-21-8165 | miguel1@test.co | Password12345 | 124 Main street | City     | CA     | 99921      | USA     | 2146599013 | 2146599043  | 8056374532 | true          | true              | true             | true                  | true   |

    @NegativeRegistrationCases
    Scenario Outline: Negative Test Cases. As a Digital Bank Admin I want to make sure users can not register without providing all valid data
      When User creates account with following fields
        | title   | firstName   | lastName   | gender   | dob   | ssn   | email   | password   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMark              |
        | <title> | <firstName> | <lastName> | <gender> | <dob> | <ssn> | <email> | <password> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> |     <termsCheckMark>        |
      Then the User should see the "<fieldWithError>" required field error message "<errorMessage>"



      Examples:
        | title | firstName | lastName | gender | dob | ssn | email | password | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | termsCheckMark | fieldWithError | errorMessage                       |
        |       |           |          |        |     |     |       |          |         |          |        |            |         |           |             |           |                | title          | Please select an item in the list. |
        | Mr.   |           |          |        |     |     |       |          |         |          |        |            |         |           |             |           |                | firstName      | Please fill out this field.        |
        | Mr.   | Jack      |          |        |     |     |       |          |         |          |        |            |         |           |             |           |                | lastName       | Please fill out this field.        |
        | Mr.   | Jack      | Test     |        |     |     |       |          |         |          |        |            |         |           |             |           |                | gender         | Please select one of these options. |
