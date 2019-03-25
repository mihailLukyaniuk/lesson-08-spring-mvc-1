# Users

## Steps to run the project:

1. Clone the repository
2. Run project with mvn spring-boot:run command
3. Check localhost:8080

## Steps to complete the task:

- Create UserController
    - GET "/users" should display a table with all users
        - if users list is empty, there is a message "List is empty" instead of the table
    - each user is clickable and points to url /users/%user_id%
    - each user should have a button with remove action
        - clicking on remove should send POST to /users/%user_id_to_delete%
        - after removing there should be automatic redirect to /users page
    - GET /users/%user_id% should display information about specific user
    - GET /createUser should display a form with fields for new user
        - clicking on submit should send POST request to url /users, user should be created
        - after user creation there should be automatic redirect to new user's page /users/%new_user_id%
    - navigation links shoud be presented on pages.
        - users list -> create user
        - create user -> users list
        - user info -> users list
- Create UserRestController
    - GET "/users" should return array with users in JSON format
    - GET "/users?firstName=John" should return array with users with firstName "John" in JSON format
    - GET "/users?lastName=Snow" should return array with users with lastName "Snow" in JSON format
    - GET "/users/%user_id%" should return specific user in JSON format
    - DELETE "/users/%user_id%" should remove user
    - POST "/users" with JSON in request body should create user
  
- If you want to be a Rockstar
    - replace UserRepositoryStaticImpl to your own implementation using Spring Data and In-memory DB
 