EXAMEN JAVA DRIMIS ALEXANDROS


1. Technologies Used
This is the technologies that I have used during my project:

- Backend Framework: Java Spring Boot
- Database: MySQL
- Build Tool: Maven
- Testing: JUnit and Mockito
- API Framework: REST
- Others: Lombok, Spring Data JPA


 Architecture
The application is designed using a layered architecture, with a clear separation of concerns. The layers are :

Controller Layer :

- Handles HTTP requests and generates HTTP responses.
- Maps REST API endpoints to specific service methods.
- Acts as the entry point for client interactions.
- Example : BookController, AuthorController.

Service Layer :

- Contains the application's business logic.
- Ensures validations and coordinates between the controller, repository, and external systems.
- Example : AuthorService,BookService

Repository Layer (DAO) :

- Directly interacts with the database.
- Uses Spring Data JPA to manage data persistence and CRUD operations.
- Example: BookDAO, AuthorDAO 

Entity Layer :

- Represents the database tables as Java objects.
- Annotated with JPA annotations like @Entity
- Example : Book , Author

DTO Layer (Data Transfer Objects):
- Used to transfer data between layers without exposing the actual entity structure.
- Ensures a clear boundary between API consumers and internal models.
- Example: BooksAuthorDto , AuthorInfoDto

3. Key Components
� Entities
You can find the different entities beside:
  
- Book : store informations about books
- Author : creator of a book 

� Database Schema
There is all the table of mySQL Database:

 - Book: id, title, gender, id_author
 - Author: id, firstName, lastName


REST API Endpoints:

Book Management :

- POST /books: Create a new Book.
- GET /books/{id}: Retrieve a book's details.
- PUT /books/{id}: Update a book's profile.
- GET /books Retrieve all book's details.
- DELETE /books/{id}: Delete a player.

Author Management :

- POST /authors : create a new Author
- GET /authors: Get all authors 




