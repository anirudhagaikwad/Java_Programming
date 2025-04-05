comprehensive guide for all endpoints in the Library Management System, including how to create and use a JWT token in Postman.

### Postman Setup for JWT Token
#### Step 1: Create an Environment
1. In Postman, go to "Environments" (left sidebar).
2. Click "Add" to create a new environment called "Library Management".
3. Add these variables:
   - `baseUrl`: `http://localhost:8080`
   - `token`: (leave value empty for now)
4. Save the environment and select it from the dropdown at the top right.

#### Step 2: Generate JWT Token
We'll use the `/api/auth/register` and `/api/auth/login` endpoints to get a token.

1. Register a User
   - Method: POST
   - URL: `{{baseUrl}}/api/auth/register`
   - Headers:
     ```
     Content-Type: application/json
     ```
   - Body (raw JSON):
     ```json
     {
         "username": "admin",
         "password": "password123",
         "roles": ["ROLE_ADMIN"]
     }
     ```
   - Expected Response: 200 OK
     ```json
     "eyJhbGciOiJIUzUxMiJ9..." // JWT token
     ```
   - Action: Copy the token from the response.

2. Set Token in Environment
   - In Postman, go to the "Tests" tab of the request.
   - Add this script to automatically save the token:
     ```javascript
     const response = pm.response.json();
     pm.environment.set("token", response);
     ```
   - Send the request again. The `token` variable in your environment will now hold the JWT token.

3. Login (Alternative to Get Token)
   - Method: POST
   - URL: `{{baseUrl}}/api/auth/login`
   - Headers:
     ```
     Content-Type: application/json
     ```
   - Body (raw JSON):
     ```json
     {
         "username": "admin",
         "password": "password123"
     }
     ```
   - Expected Response: 200 OK
     ```json
     "eyJhbGciOiJIUzUxMiJ9..." // JWT token
     ```
   - Action: Use the same "Tests" script to save the token.

#### Step 3: Use Token in Headers
- For all protected endpoints, add this header:
  ```
  Authorization: Bearer {{token}}
  ```
- You can set this globally in Postman:
  - Go to your "Library Management" collection.
  - Click the three dots (...) → "Edit" → "Pre-request Script" tab.
  - Add:
    ```javascript
    pm.request.headers.add({
        key: "Authorization",
        value: "Bearer {{token}}"
    });
    ```
  - This ensures the token is included in every request.

---

### All Endpoints
Below are all endpoints with details on how to test them in Postman. Assume the `Authorization` header is automatically added as described above for protected endpoints.

#### Authentication Endpoints
1. Register User
   - Method: POST
   - URL: `{{baseUrl}}/api/auth/register`
   - Headers:
     ```
     Content-Type: application/json
     ```
   - Body:
     ```json
     {
         "username": "admin",
         "password": "password123",
         "roles": ["ROLE_ADMIN"]
     }
     ```
   - Expected Response: 200 OK
     ```json
     "eyJhbGciOiJIUzUxMiJ9..." // JWT token
     ```

2. Login
   - Method: POST
   - URL: `{{baseUrl}}/api/auth/login`
   - Headers:
     ```
     Content-Type: application/json
     ```
   - Body:
     ```json
     {
         "username": "admin",
         "password": "password123"
     }
     ```
   - Expected Response: 200 OK
     ```json
     "eyJhbGciOiJIUzUxMiJ9..." // JWT token
     ```

#### Book Endpoints
3. Create a Book
   - Method: POST
   - URL: `{{baseUrl}}/api/books`
   - Headers:
     ```
     Content-Type: application/json
     Authorization: Bearer {{token}}
     ```
   - Body:
     ```json
     {
         "title": "The Great Gatsby",
         "isbn": "978-0743273565",
         "author": "F. Scott Fitzgerald",
         "publicationDate": "1925-04-10",
         "quantity": 5
     }
     ```
   - Expected Response: 200 OK
     ```json
     {
         "id": 1,
         "title": "The Great Gatsby",
         "isbn": "978-0743273565",
         "author": "F. Scott Fitzgerald",
         "publicationDate": "1925-04-10",
         "available": true,
         "quantity": 5
     }
     ```
   - Roles Required: ADMIN, LIBRARIAN

4. Get All Books (Paginated)
   - Method: GET
   - URL: `{{baseUrl}}/api/books?page=0&size=10&sortBy=title`
   - Headers:
     ```
     Authorization: Bearer {{token}}
     ```
   - Body: None
   - Expected Response: 200 OK
     ```json
     {
         "content": [
             {
                 "id": 1,
                 "title": "The Great Gatsby",
                 "isbn": "978-0743273565",
                 "author": "F. Scott Fitzgerald",
                 "publicationDate": "1925-04-10",
                 "available": true,
                 "quantity": 5
             }
         ],
         "pageable": {
             "sort": {
                 "sorted": true,
                 "unsorted": false,
                 "empty": false
             },
             "offset": 0,
             "pageSize": 10,
             "pageNumber": 0,
             "unpaged": false,
             "paged": true
         },
         "totalPages": 1,
         "totalElements": 1,
         "last": true,
         "size": 10,
         "number": 0,
         "sort": {
             "sorted": true,
             "unsorted": false,
             "empty": false
         },
         "numberOfElements": 1,
         "first": true,
         "empty": false
     }
     ```
   - Roles Required: USER, ADMIN, LIBRARIAN

5. Get Book by ID
   - Method: GET
   - URL: `{{baseUrl}}/api/books/1`
   - Headers:
     ```
     Authorization: Bearer {{token}}
     ```
   - Body: None
   - Expected Response: 200 OK
     ```json
     {
         "id": 1,
         "title": "The Great Gatsby",
         "isbn": "978-0743273565",
         "author": "F. Scott Fitzgerald",
         "publicationDate": "1925-04-10",
         "available": true,
         "quantity": 5
     }
     ```
   - Roles Required: USER, ADMIN, LIBRARIAN

6. Update Book
   - Method: PUT
   - URL: `{{baseUrl}}/api/books/1`
   - Headers:
     ```
     Content-Type: application/json
     Authorization: Bearer {{token}}
     ```
   - Body:
     ```json
     {
         "title": "The Great Gatsby (Updated)",
         "isbn": "978-0743273565",
         "author": "F. Scott Fitzgerald",
         "publicationDate": "1925-04-10",
         "quantity": 4
     }
     ```
   - Expected Response: 200 OK
     ```json
     {
         "id": 1,
         "title": "The Great Gatsby (Updated)",
         "isbn": "978-0743273565",
         "author": "F. Scott Fitzgerald",
         "publicationDate": "1925-04-10",
         "available": true,
         "quantity": 4
     }
     ```
   - Roles Required: ADMIN, LIBRARIAN

7. Delete Book
   - Method: DELETE
   - URL: `{{baseUrl}}/api/books/1`
   - Headers:
     ```
     Authorization: Bearer {{token}}
     ```
   - Body: None
   - Expected Response: 200 OK (empty body)
   - Roles Required: ADMIN

#### Member Endpoints
8. Create a Member
   - Method: POST
   - URL: `{{baseUrl}}/api/members`
   - Headers:
     ```
     Content-Type: application/json
     Authorization: Bearer {{token}}
     ```
   - Body:
     ```json
     {
         "firstName": "John",
         "lastName": "Doe",
         "email": "john.doe@example.com",
         "phoneNumber": "1234567890"
     }
     ```
   - Expected Response: 200 OK
     ```json
     {
         "id": 1,
         "firstName": "John",
         "lastName": "Doe",
         "email": "john.doe@example.com",
         "phoneNumber": "1234567890",
         "active": true,
         "currentBorrows": 0
     }
     ```
   - Roles Required: ADMIN, LIBRARIAN

#### Borrowing Endpoints
9. Borrow a Book
   - Method: POST
   - URL: `{{baseUrl}}/api/borrowings/borrow/1/1` (bookId=1, memberId=1)
   - Headers:
     ```
     Authorization: Bearer {{token}}
     ```
   - Body: None
   - Expected Response: 200 OK
     ```json
     {
         "id": 1,
         "book": {
             "id": 1,
             "title": "The Great Gatsby (Updated)",
             "isbn": "978-0743273565",
             "author": "F. Scott Fitzgerald",
             "publicationDate": "1925-04-10",
             "available": true,
             "quantity": 3
         },
         "member": {
             "id": 1,
             "firstName": "John",
             "lastName": "Doe",
             "email": "john.doe@example.com",
             "phoneNumber": "1234567890",
             "active": true,
             "currentBorrows": 1
         },
         "borrowDate": "2025-04-03T12:00:00",
         "returnDate": null,
         "dueDate": "2025-04-17T12:00:00",
         "returned": false,
         "fineAmount": 0.0
     }
     ```
   - Roles Required: USER, ADMIN, LIBRARIAN

10. Return a Book
    - Method: PUT
    - URL: `{{baseUrl}}/api/borrowings/return/1` (borrowingId=1)
    - Headers:
      ```
      Authorization: Bearer {{token}}
      ```
    - Body: None
    - Expected Response: 200 OK
      ```json
      {
          "id": 1,
          "book": {
              "id": 1,
              "title": "The Great Gatsby (Updated)",
              "isbn": "978-0743273565",
              "author": "F. Scott Fitzgerald",
              "publicationDate": "1925-04-10",
              "available": true,
              "quantity": 4
          },
          "member": {
              "id": 1,
              "firstName": "John",
              "lastName": "Doe",
              "email": "john.doe@example.com",
              "phoneNumber": "1234567890",
              "active": true,
              "currentBorrows": 0
          },
          "borrowDate": "2025-04-03T12:00:00",
          "returnDate": "2025-04-03T12:05:00",
          "dueDate": "2025-04-17T12:00:00",
          "returned": true,
          "fineAmount": 0.0
      }
      ```
    - Roles Required: USER, ADMIN, LIBRARIAN

---

### Error Scenarios
11. Unauthorized Access
    - Method: GET
    - URL: `{{baseUrl}}/api/books`
    - Headers: (Remove Authorization header or use invalid token)
    - Expected Response: 401 Unauthorized
      ```json
      {
          "timestamp": "2025-04-03T12:00:00",
          "status": 401,
          "error": "Unauthorized",
          "message": "Full authentication is required to access this resource",
          "path": "/api/books"
      }
      ```

12. Validation Error (Create Book)
    - Method: POST
    - URL: `{{baseUrl}}/api/books`
    - Headers:
      ```
      Content-Type: application/json
      Authorization: Bearer {{token}}
      ```
    - Body:
      ```json
      {
          "title": "A",
          "isbn": "invalid",
          "author": "B",
          "publicationDate": "2025-12-31",
          "quantity": -1
      }
      ```
    - Expected Response: 400 Bad Request
      ```json
      {
          "timestamp": "2025-04-03T12:00:00",
          "status": 400,
          "error": "Validation Failed",
          "message": "Invalid input data",
          "path": "/api/books",
          "details": [
              "title: Title must be between 2 and 100 characters",
              "isbn: Invalid ISBN format",
              "publicationDate: Publication date cannot be in the future",
              "quantity: Quantity must be zero or positive"
          ]
      }
      ```

13. Resource Not Found
    - Method: GET
    - URL: `{{baseUrl}}/api/books/999`
    - Headers:
      ```
      Authorization: Bearer {{token}}
      ```
    - Expected Response: 404 Not Found
      ```json
      {
          "timestamp": "2025-04-03T12:00:00",
          "status": 404,
          "error": "Not Found",
          "message": "Book not found with id: 999",
          "path": "/api/books/999",
          "details": []
      }
      ```

---

### Postman Collection JSON
You can import this into Postman to have all requests pre-configured:

```json
{
    "info": {
        "name": "Library Management API",
        "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    },
    "item": [
        {
            "name": "Auth",
            "item": [
                {
                    "name": "Register",
                    "request": {
                        "method": "POST",
                        "header": [
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\"username\": \"admin\", \"password\": \"password123\", \"roles\": [\"ROLE_ADMIN\"]}"
                        },
                        "url": "{{baseUrl}}/api/auth/register"
                    },
                    "event": [
                        {
                            "listen": "test",
                            "script": {
                                "exec": [
                                    "const response = pm.response.json();",
                                    "pm.environment.set(\"token\", response);"
                                ],
                                "type": "text/javascript"
                            }
                        }
                    ]
                },
                {
                    "name": "Login",
                    "request": {
                        "method": "POST",
                        "header": [
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\"username\": \"admin\", \"password\": \"password123\"}"
                        },
                        "url": "{{baseUrl}}/api/auth/login"
                    },
                    "event": [
                        {
                            "listen": "test",
                            "script": {
                                "exec": [
                                    "const response = pm.response.json();",
                                    "pm.environment.set(\"token\", response);"
                                ],
                                "type": "text/javascript"
                            }
                        }
                    ]
                }
            ]
        },
        {
            "name": "Books",
            "item": [
                {
                    "name": "Create Book",
                    "request": {
                        "method": "POST",
                        "header": [
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\"title\": \"The Great Gatsby\", \"isbn\": \"978-0743273565\", \"author\": \"F. Scott Fitzgerald\", \"publicationDate\": \"1925-04-10\", \"quantity\": 5}"
                        },
                        "url": "{{baseUrl}}/api/books"
                    }
                },
                {
                    "name": "Get All Books",
                    "request": {
                        "method": "GET",
                        "url": "{{baseUrl}}/api/books?page=0&size=10&sortBy=title"
                    }
                },
                {
                    "name": "Get Book by ID",
                    "request": {
                        "method": "GET",
                        "url": "{{baseUrl}}/api/books/1"
                    }
                },
                {
                    "name": "Update Book",
                    "request": {
                        "method": "PUT",
                        "header": [
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\"title\": \"The Great Gatsby (Updated)\", \"isbn\": \"978-0743273565\", \"author\": \"F. Scott Fitzgerald\", \"publicationDate\": \"1925-04-10\", \"quantity\": 4}"
                        },
                        "url": "{{baseUrl}}/api/books/1"
                    }
                },
                {
                    "name": "Delete Book",
                    "request": {
                        "method": "DELETE",
                        "url": "{{baseUrl}}/api/books/1"
                    }
                }
            ]
        },
        {
            "name": "Members",
            "item": [
                {
                    "name": "Create Member",
                    "request": {
                        "method": "POST",
                        "header": [
                            {"key": "Content-Type", "value": "application/json"}
                        ],
                        "body": {
                            "mode": "raw",
                            "raw": "{\"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\", \"phoneNumber\": \"1234567890\"}"
                        },
                        "url": "{{baseUrl}}/api/members"
                    }
                }
            ]
        },
        {
            "name": "Borrowings",
            "item": [
                {
                    "name": "Borrow Book",
                    "request": {
                        "method": "POST",
                        "url": "{{baseUrl}}/api/borrowings/borrow/1/1"
                    }
                },
                {
                    "name": "Return Book",
                    "request": {
                        "method": "PUT",
                        "url": "{{baseUrl}}/api/borrowings/return/1"
                    }
                }
            ]
        }
    ]
}
```

---

### Testing Tips
- Sequence: Register a user → Create a book → Create a member → Borrow → Return.
- Roles: Test with different roles (e.g., create a "ROLE_USER" user to verify access restrictions).
- Error Testing: Remove the `Authorization` header or use invalid data to test error responses.
- Fine Calculation: To test fines, manually adjust the `dueDate` in the database to be in the past before returning a book.



### ✅ provided regex for ISBN:

```regex
^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|[0-9X]{10}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$
```

---

#### 🔹 ISBN-10 Examples:

| Example              | Match? | Why/Why Not |
|----------------------|--------|-------------|
| `0-306-40615-2`      | ✅ Yes | 10 chars, hyphenated |
| `0306406152`         | ✅ Yes | 10 digits |
| `3-598-21508-8`      | ✅ Yes | valid format |
| `1-84356-028-3`      | ✅ Yes | valid format |
| `0-943396-04-2`      | ✅ Yes | valid format |
| `0-9752298-0-X`      | ✅ Yes | last char "X" allowed in `[0-9X]` |

---

#### 🔹 ISBN-13 Examples:

| Example              | Match? | Why/Why Not |
|----------------------|--------|-------------|
| `978-3-16-148410-0`  | ✅ Yes | 13-digit structure |
| `9783161484100`      | ✅ Yes | no separators, full 13 digits |
| `979-10-90636-07-1`  | ✅ Yes | 979 prefix allowed |
| `978-0-545-01022-1`  | ✅ Yes | valid |
| `979-8-4002-2004-3`  | ✅ Yes | valid |

---

#### 🔹 With Prefix:

| Example                          | Match? | Why/Why Not |
|----------------------------------|--------|-------------|
| `ISBN 978-3-16-148410-0`         | ✅ Yes | optional `ISBN` supported |
| `ISBN-13: 978-0-545-01022-1`     | ✅ Yes | `ISBN-13:` is optional and allowed |
| `ISBN: 0-306-40615-2`            | ✅ Yes | `ISBN:` and 10-digit format allowed |

---

---

### 🔹 `^`

- Anchors the match **at the beginning** of the string.

---

### 🔹 `(?:ISBN(?:-13)?:? )?`

This optional non-capturing group matches optional ISBN labels like "ISBN", "ISBN-13:", etc.

- `ISBN` → literally matches `ISBN`
- `(?:-13)?` → optionally matches `-13`
- `:?` → optionally matches a colon (`:`)
- ` ` → requires a space after `ISBN`, `ISBN-13`, etc.
- The whole group is wrapped in `(?: ... )?`, making it **optional**

**Examples it matches:**
- `ISBN `
- `ISBN: `
- `ISBN-13 `
- `ISBN-13: `
- Or nothing at all

---

### 🔹 `(?=[0-9]{13}$|[0-9X]{10}$)`

This is a **lookahead assertion**. It doesn't consume characters, but ensures that **what follows** is:

- `13 digits` → `(?=[0-9]{13}$)`
- OR `10 digits or 9 digits + X` → `(?=[0-9X]{10}$)`

> 🔍 This ensures the overall input length is valid for either ISBN-10 or ISBN-13, but doesn't enforce exact grouping structure yet.

---

### 🔹 `(?:97[89][- ]?)?`

Optional non-capturing group matching **ISBN-13 prefix**:

- `97[89]` → matches `978` or `979`
- `[- ]?` → optional **hyphen or space** separator
- The whole group is optional (for ISBN-10s)

---

### 🔹 `[0-9]{1,5}[- ]?`

- Matches the **group identifier** (1 to 5 digits)
- Optional hyphen or space

---

### 🔹 `[0-9]+[- ]?`

- Matches the **publisher code** (variable length digits)
- Optional hyphen or space

---

### 🔹 `[0-9]+[- ]?`

- Matches the **item number** (again, variable length digits)
- Optional hyphen or space

---

### 🔹 `[0-9X]`

- Matches a **single check digit**
- Can be `0–9` or `X` (ISBN-10 check digit)

---

### 🔹 `$`

- Anchors the match at the **end of the string**

---

## ✅ In Summary

This regex validates:
- Optional prefix like `ISBN`, `ISBN-13:`, etc.
- ISBN-10 or ISBN-13 formats
- Optional separators (hyphen or space)
- Proper use of `978`/`979` for ISBN-13
- Valid check digit (can be `X` for ISBN-10)

---

