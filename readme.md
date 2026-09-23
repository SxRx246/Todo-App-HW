# Todo App – Spring Boot

## GitHub Repository

[GitHub Repository](https://github.com/SxRx246/Todo-App-HW)

## API Routes

### Test Application

| Method | Route    | Description            |
| ------ | -------- | ---------------------- |
| GET    | `/hello` | Returns `Hello World!` |

The `/hello` route is kept in a separate test application because it was part of the initial Spring Boot exercise.

### Todo Application – Categories

| Method | Route                          | Description             |
| ------ | ------------------------------ | ---------------------   |
| GET    | `/api/categories/`             | Get all categories      |
| POST   | `/api/categories/`             | Create a new category   |
| GET    | `/api/categories/{categoryId}` | Get a category by ID    |
| PUT    | `/api/categories/{categoryId}` | Update a category by ID |
| DELETE | `/api/categories/{categoryId}` | Delete a category by ID |


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

## Design Decisions

* **Separate Test Application:** Kept `/hello` separate from the Todo application because it was used for the initial Spring Boot exercise.
* **Spring Data JPA:** Simplifies database operations.
* **PostgreSQL:** Used as the relational database.
* **Service Layer:** Separates business logic from the controller.
* **Constructor Injection:** Used for dependency injection.
* **Spring Profiles:** Separates development-specific configuration.

## What Went Right

* Successfully created the Spring Boot application.
* Successfully connected PostgreSQL to the application.
* Implemented the Category GET and POST routes.
* Tested the API routes using Postman.
* Separated the initial `/hello` test from the main Todo application.

## Challenges

* Configuring PostgreSQL with the Spring `dev` profile.
* Understanding JPA requirements such as `@Id` and a no-argument constructor.
* Fixing dependency injection when `CategoryService` was `null`.
* Understanding how `findById()` works with `Optional`.

## What I Enjoyed Most

I enjoyed seeing how a request moves through the **Controller → Service → Repository → Database** layers and understanding how the different parts of a Spring Boot application work together.