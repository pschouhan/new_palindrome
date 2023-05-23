# new_palindrome
Developed a REST API to accept a username and text value and return an indicator whether that value is a palindrome - A palindrome is a word, number, phrase, or other sequences of characters which reads the same backward as forward, such as madam or kayak.

Instructions :

- Open the project folder and run spring-boot:run
- The application will run on 8080 port. (http://localhost:8080)

API End points:

- localhost:8080/validate-palindrome
- Method : POST.
- Request Body : {
  "userName": "admin",
  "value": "abababa"
  }
- Response body(String): The validation message will display if the value is palindrome or not.



Database:

Mysql Data-base. Create a schema “palindrome”. The sql server should be running on 3306.
Once the application is started and table palindrome.my_user is auto populated in the database


Work flow:

- Once the application is started and running,
    - The cache is populated with contents from the database.

provide the request parameters.

    - userName -> name of the user making the request.
    - value -> value to find palindrome or not.

- If the value provided is a palindrome, the value will be validated from the cache and the same will be acknowledged to the user.

- If the value provided is a palindrome and not present in the cache then the value will be validated and stored in the DB

- If the value provided is not a palindrome, the values will not be stored in the database and the validation message will be acknowledged to the user.

- If the value provided is an invalid such as non-alphabetic, empty, with special chars, then the error will be acknowledged to the user.

- A caching mechanism is used where the data will be fetched out of the cache before fetching from the database.
