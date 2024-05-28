# Simple Online Bookstore RESTful API
### Overview

This project implements a simple RESTful API for managing a bookstore using Java with the Spring Boot framework. 
The API allows users to view a list of available books, add new books to the store, update book details, and delete books from the store.
- **User Access and Security**: Control user access levels and permissions to ensure data security and confidentiality.

## Technologies Used

The Online BookStore Application leverages modern technologies to deliver a robust and efficient experience:

- **Java**: The core programming language for developing the application logic.
- **Spring Boot**: A powerful framework for building robust and scalable applications.
- **Spring Data JPA**: Provides data access and manipulation capabilities using the Java Persistence API.
- **Spring Web**: Facilitates the creation of web APIs and interfaces.
- **Spring Security**: Ensures secure authentication and authorization within the application, guarding against unauthorized access and protecting sensitive data.
- **JSON Web Token (JWT)**: Enables stateless authentication by securely transmitting user information as JSON objects, facilitating secure communication between the client and server.
- **PostgreSQL**: A popular relational database management system used for storing and retrieving structured data efficiently.
- **Maven**: Manages project dependencies and provides a structured build process.
- **Caffeine Cache**: A high-performance, near-zero-latency caching library for Java 8.
- **Git**: Version control for collaborative development.


##Setup Instructions
1. Clone the repository to your local machine:
   #####git clone https://github.com/JacinthEsther/online_store.git
2. Navigate to the project directory:3.
   #####cd online_bookstore

3. Build the project using Maven:
   #####mvn clean install
4. Run the Spring Boot application
   #####mvn spring-boot:run
5. The application should now be running locally at http://localhost:8080.


##  **Configure the Database:**

   Modify the `src/main/resources/application.properties` file to include your database connection details:

   ```properties
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.datasource.url=your_database_jdbc_url
   spring.datasource.username=your_database_username
   spring.datasource.password=your_database_password
   ```
### **Token Requirements:**

   Modify the `src/main/resources/application.properties` file to include your JWT token:

    ```properties
   online_bookstore.app.SecretKey=your_JWT_token


# API Documentation
##1.Get all books
### GET /books
  Returns a list of all books in the bookstore.

##2. Add a new book

###POST /books/addbooks/{email}
Adds a new book to the bookstore. Requires a JSON payload with book details.

##Example request body:

##json

`{
"title": "Sample Book",
"author": "John Doe",
"description": "A sample book for demonstration purposes",
"price": 19.99
}`
##3.Update book details
###PUT /books/{email}/{book_id}
Updates the details of an existing book in the bookstore. Requires the book ID in the path parameter and a JSON payload 
with updated book details. NB: Only an admin can update the books in the bookstore

Example request body:

_json_

`{
"title": "Updated Book Title",
"author": "Jane Smith",
"description": "An updated version of the book",
"price": 24.99
}`
##4. Delete a book

###DELETE /books/{email}/{book_id}
Deletes a book from the bookstore. Requires the book ID in the path parameter.
Note: only an admin can delete a book

##5.Get books by Id
### GET /books/{id}
Returns the book whose id has been passed.

#Design Explanation
**_Data Model:_** The project uses a Book entity class mapped to a database table using JPA annotations.
**_Repository Layer:_** The BookRepository interface extends JpaRepository to provide CRUD operations for books.
**_Controller Layer:_** The BookController class defines REST endpoints for handling book-related operations.
**_Service Layer:_** Service classes can be added if business logic requires additional processing.
**_Error Handling:_** Error handling is implemented using global exception handlers and appropriate HTTP status codes.

#Additional Notes
#####Database configuration can be modified in the application.properties file.
#####Unit tests can be found in the src/test directory.