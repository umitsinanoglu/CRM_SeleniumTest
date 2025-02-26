@StartCRM
Feature: Login Functionality

  Background:  # This is the Background section
    Given the user is on the login page

#zorunlu alan uyarısı
  #hata mesajı
  #başarılı mesaj

  @InvalidCredentials
  Scenario Outline: UnSuccessful Login Test with invalid credentials
    #Given the user is on the login page
    When the user enters username '<username>' and password '<password>'
    Then  an error message '<message>' should be displayed
    And the user should remain on the login page
    Examples:
      | username | password            | message                                  |
      | admin    | bBP9Htjd43jlk3kj4j2 | Geçerli bir kullanıcı adı/şifre giriniz. |
      | admin123 | Ü;:Q^#$½{[XSS]}}    | Geçerli bir kullanıcı adı/şifre giriniz. |


  @EmptyUserName
  Scenario: Unsuccessful Login with Empty Username
    When the user enters an empty username and a valid password
    Then a "This field is required!" error message should be displayed
    And the user should remain on the login page


  @EmptyPassword
  Scenario: Unsuccessful Login with Empty Password
    When the user enters a valid username and an empty password
    Then "This field is required!" error message should be displayed for the password field
    And the user should remain on the login page

  @ValidCredentials
  Scenario: Successful Login with Valid Credentials
    When the user enters valid username and valid password
    And the user should be successfully logged in
    And the user should be redirected to the home page
    Then the username should match the expected username as on myaccount page
    And the user should be able to logout successfully

  @ValidCredentials_with2FA
  Scenario Outline: 2FA Login with Valid Credentials
    #Given the user is on the login page
    When the user enters username "<username>" and password "<password>"
    Then the countdown timer should be visible on the login page
    And the user should be prompted to enter a two factor code
    And the two-factor authentication input field should be displayed
    When the user enters a valid two factor code
    Then the user should be successfully logged in
    And the user should be redirected to the home page
    Examples:
      | username                   | password         |
      | tester@gmail.com           |  |
      | umit.sinanoglu@example.com |  |