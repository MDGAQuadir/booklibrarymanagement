# booklibrarymanagement
Created this for assignement

Library Management System

Introduction-
This is a Spring Boot-based Library Management System that enables librarians to efficiently add, update, search, and remove books while maintaining their availability status.

Features-
Add a Book: Accepts book details (ID, title, author, genre, availability status) and stores them.
View All Books: Lists all books with their details.
Search Book by ID or Title: Allows searching using book ID or title.
Update Book Details: Modifies book attributes (title, author, genre, availability status).
Delete a Book Record: Removes a book from the catalog.
Exit System: Stops the program execution.

Technologies Used-
Backend: Java, Spring Boot, Spring Data JPA
Database: H2 (In-memory database for testing, can be switched to MySQL/PostgreSQL)
Build Tool: Maven
API Testing: Postman, cURL

Prerequisites-
Ensure you have the following installed:
Java 17+
Maven 3+
Any IDE (Eclipse, IntelliJ IDEA, VS Code with Java Extension)

Project Setup-
### 1. Clone the Repository
```sh
git clone <repository-url>
cd LibraryManagement
```
### 2. Build the Project
```sh
mvn clean install
```
### 3. Run the Application
```sh
mvn spring-boot:run
```
### 4. Access H2 Database Console (Optional)
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:library`
- Username: `sa`
- Password: *(leave blank)*

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| **POST** | `/books/add` | Add a new book |
| **GET** | `/books` | View all books |
| **GET** | `/books/{id}` | Search book by ID |
| **GET** | `/books/search?title={title}` | Search book by title |
| **PUT** | `/books/update/{id}` | Update book details |
| **DELETE** | `/books/delete/{id}` | Delete a book |

## Example API Usage

### Add a Book
```sh
curl -X POST http://localhost:8080/books/add -H "Content-Type: application/json" -d '{
  "title": "Harry Potter",
  "author": "J.K. Rowling",
  "availabilityStatus": "AVAILABLE"
}'
```

### View All Books
```sh
curl -X GET http://localhost:8080/books
```

### Search by ID
```sh
curl -X GET http://localhost:8080/books/1
```

### Update a Book
```sh
curl -X PUT http://localhost:8080/books/update/1 -H "Content-Type: application/json" -d '{
  "title": "Harry Potter and the Sorcerer's Stone",
  "author": "J.K. Rowling",
  "availabilityStatus": "CHECKED_OUT"
}'
```

### Delete a Book
```sh
curl -X DELETE http://localhost:8080/books/delete/1
```

## Challenges Faced & Future Improvements
- **Challenges:** Managing data persistence across multiple runs due to the use of an in-memory database.
- **Improvements:** Adding authentication, role-based access (admin/user), and a frontend UI for better usability.

## License
This project is open-source and free to use under the MIT license.

## Author
MD Gulam Abdul Quadir

---

