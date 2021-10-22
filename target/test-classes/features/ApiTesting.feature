Feature: Api testing for CRUID operators


  Background:
    Given user given api url "https://gorest.co.in"


  Scenario Outline: POST-Create a new user
    Given set api endpoint "public/v1/users"
    And User creates new user with request body "<Name>","<Gender>","<Email>","<Status>"
    Then validate the status code 201
    And validate the userId is not null
    And validate the user Name is "<Name>"
    And validate the user Gender is "<Gender>"
    And validate the user Email is "<Email>"
    And validate the user Status is "<Status>"

    Examples: User Details table
      | Name       | Gender | Email             | Status |
      | John Doe 8 | male   | john26@gmail.com | active |


  Scenario Outline: PUT-Update existing user data
    Given set api endpoint "public/v1/users/""<userId>"
    And Update the user with request body "<Name>","<Gender>","<Email>","<Status>"
    Then validate the status code 200
    And validate the user Name is "<Name>"
    And validate the user Gender is "<Gender>"
    And validate the user Email is "<Email>"
    And validate the user Status is "<Status>"

    Examples: User Details table
      | Name         | Gender | Email             | Status | userId |
      | John Doe 133 | male   | john26@gmail.comn | active | 13954  |



    ####################################################
  # Alternate scenario

  Scenario: POST-Create a new user input
    Given set api endpoint "public/v1/users"
    And User creates new user with request body "John Doe 8","male","john26@gmail.comn","active"
    Then validate the status code 201
    And validate the userId is not null
    And validate the user Name is "John Doe 8"
    And validate the user Gender is "male"
    And validate the user Email is "john26@gmail.comn"
    And validate the user Status is "active"

