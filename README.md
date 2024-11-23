# Inventory Management System

## Overview
The **Inventory Management System** is a Java-based application designed to help businesses efficiently manage their inventory. It allows users to perform CRUD (Create, Read, Update, Delete) operations on inventory items and provides real-time tracking of stock levels. The system is ideal for small to medium-sized businesses looking for a simple and effective inventory management tool.

## Features
- Add, update, delete, and view inventory items.
- Track stock quantities and reorder levels.
- Generate reports on inventory status.
- User-friendly interface for easy interaction.

---

## Prerequisites
Before running this application, ensure the following prerequisites are met:

1. **Java Development Kit (JDK)**:
   - Install JDK 8 or later. You can download it [here](https://www.oracle.com/java/technologies/javase-downloads.html).
   - Verify installation:
     ```bash
     java -version
     ```

2. **Database Setup**:
   - The application uses a database to store inventory data. Ensure you have one of the following installed:
     - MySQL
     - PostgreSQL (or any other supported database)
   - Create a database for the application.

3. **SQL File**:
   - The project includes an SQL file that sets up the necessary database tables and initial data.
   - To use the SQL file:
     1. Import the provided `.sql` file into your database management system (e.g., MySQL, PostgreSQL).
     2. The SQL file contains queries to create tables and insert sample data.
     
     Example for MySQL:
     - Open your MySQL command line or a database management tool like **phpMyAdmin** or **MySQL Workbench**.
     - Create a new database:
       ```sql
       CREATE DATABASE inventory_db;
       ```
     - Use the created database:
       ```sql
       USE inventory_db;
       ```
     - Run the SQL script to set up the schema:
       ```sql
       SOURCE path_to_your_sql_file.sql;
       ```
     
     This will create the required tables and insert sample data to help you get started.

4. **DbConnection.java**:
   - The `DbConnection.java` file manages the database connection. 
   - You will need to configure the database connection details (URL, username, password) in this file.
   - Open `DbConnection.java` and ensure the connection details are correct.
   
   Example code in `DbConnection.java`:
   ```java
   public class DbConnection {
       private static final String DB_URL = "jdbc:mysql://localhost:3306/inventory_db";
       private static final String USER = "root";
       private static final String PASSWORD = "password";
       
       public static Connection getConnection() throws SQLException {
           return DriverManager.getConnection(DB_URL, USER, PASSWORD);
       }
   }
   ```
   - Ensure you have the required JDBC driver for MySQL or PostgreSQL in your project dependencies.

5. **IDE**:
   - Use an Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or NetBeans for development and running the project.

---

## How to Run

### 1. Clone the Repository
Clone this repository to your local machine:
```bash
git clone https://github.com/tharunprasath12/Inventory-Management-System.git
cd Inventory-Management-System
```

### 2. Configure the Database Connection
- Open the `DbConnection.java` file in the project.
- Update the database connection details (e.g., URL, username, password) in the `DbConnection` class.

Example:
```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/inventory_db";
private static final String USER = "root";
private static final String PASSWORD = "password";
```

- Import the SQL file (mentioned in the **SQL File** section) to set up initial tables and data.

### 3. Open in IDE
- Open the project in your preferred IDE.
- If using IntelliJ IDEA, make sure to delete the `.idea` folder before importing.

### 4. Run the Application
- Locate the main class (e.g., `Main.java` or `InventoryManagementApp.java`).
- Run the main class from your IDE.

### 5. Access the Application
- If the application has a web interface, open your browser and navigate to:
  ```
  http://localhost:8080
  ```
- Otherwise, interact with the console-based application directly in the IDE.

---

## Technologies Used
- **Programming Language**: Java
- **Database**: MySQL (or other supported DBMS)
- **IDE**: IntelliJ IDEA (preferred) or any other Java IDE
