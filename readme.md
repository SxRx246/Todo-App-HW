# Todo App – Spring Boot

## GitHub Repository

[GitHub Repository](https://github.com/SxRx246/Todo-App-HW)

## API Routes

### Test Application

| Method | Route    | Description            |
| ------ | -------- | ---------------------- |
| GET    | `/hello` | Returns `Hello World!` |

The `/hello` route is kept in a separate test application because it was part of the initial Spring Boot exercise.

---

### Todo Application – Categories

| Method | Route                          | Description             |
| ------ | ------------------------------ | ----------------------- |
| GET    | `/api/categories/`             | Get all categories      |
| POST   | `/api/categories/`             | Create a new category   |
| GET    | `/api/categories/{categoryId}` | Get a category by ID    |
| PUT    | `/api/categories/{categoryId}` | Update a category by ID |
| DELETE | `/api/categories/{categoryId}` | Delete a category by ID |

---

### Todo Application – Items

| Method | Route                                         | Description                           |
| ------ | --------------------------------------------- | ------------------------------------- |
| POST   | `/api/categories/{categoryId}/items`          | Create a new item for a category      |
| GET    | `/api/categories/{categoryId}/items`          | Get all items belonging to a category |
| GET    | `/api/categories/{categoryId}/items/{itemId}` | Get an item by ID                     |
| PUT    | `/api/categories/{categoryId}/items/{itemId}` | Update an item by ID                  |
| DELETE | `/api/categories/{categoryId}/items/{itemId}` | Delete an item by ID                  |

The Item endpoints use the `categoryId` in the URL to associate items with a specific category when creating and retrieving items.

---

## Steps Completed

### Step 1 – Spring Boot

* Created a separate test application for the initial Spring Boot exercise.
* Created `TestController`.
* Implemented the `/hello` route.
* Tested the route using Postman.

### Step 2 – Spring Profiles

* Added `application-dev.properties`.
* Separated development-specific configuration.
* Configured PostgreSQL for the development environment.

### Step 3 – Spring Data

* Connected Spring Boot to PostgreSQL using Spring Data JPA.
* Created the `Category` entity with `id`, `name`, and `description`.
* Created the Repository, Service, and Controller layers.
* Implemented GET and POST operations for categories.

### Step 4 – Category CRUD

* Implemented retrieving a category by ID.
* Implemented updating a category by ID.
* Implemented deleting a category by ID.
* Tested the Category CRUD endpoints using Postman.

### Step 5 – Item CRUD

* Created the `Item` entity.
* Connected `Item` to `Category`.
* Created the `ItemRepository`.
* Created the `ItemService`.
* Created the `ItemController`.
* Implemented creating an item under a specific category.
* Implemented retrieving all items belonging to a category.
* Implemented retrieving an individual item by ID.
* Implemented updating an item by ID.
* Implemented deleting an item by ID.
* Tested the Item endpoints using Postman.

### Step 6 – Dependency Injection

* Used constructor-based dependency injection for services and controllers.
* Used Lombok annotations such as `@AllArgsConstructor` to generate constructors.
* Learned that dependencies such as `ItemRepository` and `CategoryRepository` must be injected before they can be used.
* Fixed dependency injection issues that caused `NullPointerException` errors.

### Step 7 – Request Body and Path Variables

* Used `@RequestBody` to receive JSON data from POST and PUT requests.
* Used `@PathVariable` to retrieve IDs from API routes.
* Learned the difference between data provided through the URL and data provided through the request body.

---

## Design Decisions

* **Separate Test Application:** Kept `/hello` separate from the Todo application because it was used for the initial Spring Boot exercise.
* **Spring Data JPA:** Simplifies database operations and repository implementation.
* **PostgreSQL:** Used as the relational database.
* **Service Layer:** Separates business logic from the controller.
* **Repository Layer:** Handles communication with the database through Spring Data JPA.
* **Constructor Injection:** Used for dependency injection between controllers, services, and repositories.
* **Spring Profiles:** Separates development-specific configuration.
* **REST API:** Uses HTTP methods such as GET, POST, PUT, and DELETE to perform CRUD operations.
* **Category–Item Relationship:** Items are associated with categories using a category ID.

---

## What Went Right

* Successfully created the Spring Boot application.
* Successfully connected PostgreSQL to the application.
* Implemented the Category CRUD routes.
* Implemented the Item CRUD routes.
* Successfully connected Items to Categories.
* Successfully tested the API routes using Postman.
* Learned how requests move through the Controller, Service, and Repository layers.
* Successfully implemented dependency injection.
* Separated the initial `/hello` test from the main Todo application.

---

## Challenges

* Configuring PostgreSQL with the Spring `dev` profile.
* Understanding JPA requirements such as `@Id` and a no-argument constructor.
* Fixing dependency injection when `CategoryService` was `null`.
* Understanding how `findById()` works with `Optional`.

---

## What I Enjoyed Most

I enjoyed seeing how a request moves through the **Controller → Service → Repository → Database** layers and understanding how the different parts of a Spring Boot application work together.

I also enjoyed implementing the relationship between **Categories and Items** and seeing how REST API endpoints can be used to create, retrieve, update, and delete data from the database.
