# **Nimap Task - CRUD Application**

## **Features**

1. **Product Management**:

   - Create, Read, Update, and Delete products.
   - Pagination support for fetching products.
   - Association of products with categories.

2. **Category Management**:

   - Create, Read, Update, and Delete categories.
   - Pagination support for fetching categories.
   - Categories are independent and not affected by products.

3. **Error Handling**:

   - Custom exception handling using a `GlobalExceptionHandler`.
   - Clear error messages for invalid or missing resources.

4. **Database**:
   - MySQL database integration for persistent storage.
   - JPA and Hibernate for ORM.

---

## **Technologies Used**

1. **Backend**:

   - Java 17
   - Spring Boot 3
   - Spring Data JPA
   - Spring Web

2. **Database**:

   - MySQL 8

3. **Build Tools**:

   - Maven

4. **Testing**:
   - Postman (for manual API testing)

---

## **Setup and Installation**

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/your-username/nimap-task.git
   cd nimap-task
   ```

2. **Update `application.properties`**:
   Configure database connection in the `src/main/resources/application.properties` file:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build and Run**:

   - Build the application:
     ```bash
     mvn clean install
     ```
   - Run the application:
     ```bash
     mvn spring-boot:run
     ```

4. **Test APIs**:
   Use **Postman** to test the RESTful APIs. Refer to the API documentation below for endpoints.

---

## **API Documentation**

### **Categories**

| Method | Endpoint                 | Description                    | Request Body                |
| ------ | ------------------------ | ------------------------------ | --------------------------- |
| POST   | `/api/categories`        | Create a new category          | `{ "name": "Electronics" }` |
| GET    | `/api/categories?page=0` | Get all categories (paginated) | N/A                         |
| GET    | `/api/categories/{id}`   | Get category by ID             | N/A                         |
| PUT    | `/api/categories/{id}`   | Update category by ID          | `{ "name": "Gadgets" }`     |
| DELETE | `/api/categories/{id}`   | Delete category by ID          | N/A                         |

---

### **Products**

| Method | Endpoint               | Description                  | Request Body                                                             |
| ------ | ---------------------- | ---------------------------- | ------------------------------------------------------------------------ |
| POST   | `/api/products`        | Create a new product         | `{ "name": "Laptop", "price": 1500, "category": { "catId": 1 } }`        |
| GET    | `/api/products?page=0` | Get all products (paginated) | N/A                                                                      |
| GET    | `/api/products/{id}`   | Get product by ID            | N/A                                                                      |
| PUT    | `/api/products/{id}`   | Update product by ID         | `{ "name": "Gaming Laptop", "price": 2000, "category": { "catId": 2 } }` |
| DELETE | `/api/products/{id}`   | Delete product by ID         | N/A                                                                      |

---

## **API Testing with Postman**

To test the APIs using **Postman**, click on the button below to import the API collection directly into your Postman workspace:

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/23803397-23c8fd02-44fc-4d6d-8d39-9c16936cff51?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D23803397-23c8fd02-44fc-4d6d-8d39-9c16936cff51%26entityType%3Dcollection%26workspaceId%3Df6aebfdc-4fe0-47e1-bbc0-54b9441dea5d)

---

## **Contact**

- **Name**: Ritesh Gaygawali
- **Email**: gaygawaliritesh@gmail.com

---
