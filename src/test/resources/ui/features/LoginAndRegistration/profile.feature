Feature: This feature file Login page functionality

Background:
  #Scenario: Login
    Given user login as "miguel12@gmail.com" "Password123"
    #    Then user should land on profile page with url "https://dbank-qa.wedevx.co/bank/user/profile"

  Scenario: validate profile
    When user clicks on profile picture
    And click on my profile picture
    Then user should see all registration info

      | title | firstName | lastName | homePhone   | mobilePhone | workPhone  | address            | locality | region     | postalCode | country |
      | Mr.   | Mike      | Test     | 1234567890  | 2146599041  | 8056374531 | 123 Hollywood Blvd | LA       | California | 90002      | USA     |

