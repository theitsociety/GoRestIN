Feature: Api testing for CRUID operators


  Background:
    Given user given api url "https://gorest.co.in"
#dfsfsdfsdfsdfdgdgsdgsdfg

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
      | John Doe 8 | male   | john260@gmail.com | active |


  Scenario Outline: PUT-Update existing user data
    Given set api endpoint "public/v1/users/""<userId>"
    And Update the user with request body "<Name>","<Gender>","<Email>","<Status>"
    Then validate the status code 200
    And validate the user Name is "<Name>"
    And validate the user Gender is "<Gender>"
    And validate the user Email is "<Email>"
    And validate the user Status is "<Status>"

    Examples: User Details table
      | Name         | Gender | Email            | Status | userId |
      | John Doe 133 | male   | john26@gmail.com | active | 13954  |


  Scenario Outline: Create a post and comment
    Given user sets "<EndpointPost>" post
    And create a post with given userId and create one "<Body>" and "<Title>"
    When user sets "<EndpointComment>" post and create one "<Comment>" using "<userId>", "<name>", "<email>", "<comment body>"
    Then verify that comment created "<name>" "<email>"

    Examples:
      | EndpointPost                   | EndpointComment                   | userId | Body              | Title                  | Comment       | name    | email             | comment body         |
      | public/v1/users/<userId>/posts | public/v1/posts/<userId>/comments | 13954  | Body post message | this is my first title | first comment | My Name | asdasda@gmail.com | This is comment body |


  Scenario: DELETE-Delete user
    Given user set endpoint "public-api/users/" for "7951" userid
    And use DELETE request to delete specific user
    Then validate the response status code is 204
    Then try to get the user data and validate response code is 404
    Then validate with response message "Resource not found"







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

