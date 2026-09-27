# Todo App – Spring Boot

## GitHub Repository

[GitHub Repository](https://github.com/SxRx246/Todo-App-HW)

---

## Steps Completed

### Step 1 – Spring Boot

* Created the Spring Boot application.
* Created the `/hello` endpoint.
* Tested the endpoint using Postman.

### Step 2 – Spring Profile

* Added the `dev` profile.
* Configured PostgreSQL for development.

### Step 3 – Spring Data

* Implemented Category and Item CRUD.
* Added JPA relationships.
* Added User and UserProfile.
* Implemented user registration.
* Added BCrypt password encoding.

### Step 4 – Spring Security

* Implemented JWT login and authentication.
* Added JWT validation using a request filter.
* Protected the Todo API endpoints.
* Kept registration and login public.
* Used stateless authentication.

---

# API Endpoints

## Test

| Method | Endpoint | Description            |
| ------ | -------- | ---------------------- |
| GET    | `/hello` | Returns `Hello World!` |

## Authentication

| Method | Endpoint               | Description             | Access |
| ------ | ---------------------- | ----------------------- | ------ |
| POST   | `/auth/users/register` | Register a new user     | Public |
| POST   | `/auth/users/login`    | Login and receive a JWT | Public |

Protected requests require:

`Authorization: Bearer <JWT>`

## Categories

| Method | Endpoint                       | Description        | Access  |
| ------ | ------------------------------ | ------------------ | ------- |
| GET    | `/api/categories`              | Get all categories | Private |
| POST   | `/api/categories`              | Create a category  | Private |
| GET    | `/api/categories/{categoryId}` | Get category by ID | Private |
| PUT    | `/api/categories/{categoryId}` | Update a category  | Private |
| DELETE | `/api/categories/{categoryId}` | Delete a category  | Private |

## Items

| Method | Endpoint                                      | Description                 | Access  |
| ------ | --------------------------------------------- | --------------------------- | ------- |
| GET    | `/api/categories/{categoryId}/items`          | Get all items in a category | Private |
| POST   | `/api/categories/{categoryId}/items`          | Create an item              | Private |
| GET    | `/api/categories/{categoryId}/items/{itemId}` | Get an item by ID           | Private |
| PUT    | `/api/categories/{categoryId}/items/{itemId}` | Update an item              | Private |
| DELETE | `/api/categories/{categoryId}/items/{itemId}` | Delete an item              | Private |

---

# Database Relationships

* `User` ↔ `UserProfile` — **1:1**
* `User` ↔ `Category` — **1:M**
* `User` ↔ `Item` — **1:M**
* `Category` ↔ `Item` — **1:M**

PostgreSQL is used with Spring Data JPA.

---

# Design Decisions

* **Spring Data JPA:** Used for database operations and relationships.
* **PostgreSQL:** Used as the database.
* **Layered structure:** Controller → Service → Repository.
* **JWT:** Used for stateless authentication.
* **BCrypt:** Used to encode passwords securely.

---

# What Went Right

* Category and Item CRUD.
* JPA entity relationships.
* User registration and login.
* JWT authentication and protected endpoints.

---

# Challenges

* Configuring PostgreSQL and the `dev` profile.
* Understanding JPA relationships.
* Implementing JWT authentication and validation.

---

# What I Enjoyed Most

I enjoyed building the CRUD functionality, connecting the entities with JPA relationships, and implementing JWT authentication.
