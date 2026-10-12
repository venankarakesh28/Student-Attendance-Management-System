# Student Attendance Management System

A web-based application developed using Java, Spring Boot, Spring Data JPA, Hibernate, MySQL, HTML, CSS, and JavaScript to manage student details and attendance records efficiently.

## 🚀 Live Demo

- **Deployed Application:** https://student-attendance-management-system-609m.onrender.com
- **GitHub Repository:** https://github.com/venankarakesh28/Student-Attendance-Management-System

> Note: The deployed application may take some time to load if the hosting service is waking up. Database connectivity depends on the deployed configuration.

## 📌 Project Overview

The Student Attendance Management System simplifies the process of maintaining student information and attendance records. It allows users to manage student details, record attendance, and view attendance information through a web interface.

## ✨ Features

- Add new student details
- View the list of students
- Update student information
- Delete student records
- Record student attendance
- Update attendance records
- Filter attendance by date or student
- View student-wise attendance summaries
- Store data using a MySQL database
- Access the application through a web browser

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Backend programming |
| Spring Boot | Application framework |
| Spring Data JPA | Database operations |
| Hibernate | ORM and entity management |
| MySQL | Relational database |
| HTML | Web page structure |
| CSS | Styling |
| JavaScript | Frontend interactions |
| Maven | Build and dependency management |
| Git and GitHub | Version control and source code hosting |
| Render | Application deployment |

## 🏗️ Project Architecture

The application follows a layered architecture:

1. **Frontend:** HTML, CSS, and JavaScript provide the user interface.
2. **Controller Layer:** Spring Boot REST controllers handle HTTP requests.
3. **Repository Layer:** Spring Data JPA repositories interact with the database.
4. **Model Layer:** Student and attendance entities represent application data.
5. **Database:** MySQL stores student details and attendance records.

## 📂 Project Structure

```text
Student-Attendance-Management-System/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/college/attendance/
│       │       ├── AttendanceManagementApplication.java
│       │       ├── controller/
│       │       ├── model/
│       │       └── repository/
│       └── resources/
│           ├── application.properties
│           └── static/
│               └── index.html
├── database/
│   └── schema.sql
├── docs/
│   ├── architecture.mmd
│   └── use-case.mmd
├── pom.xml
└── README.md
```

*Note: The exact package subfolders may vary slightly depending on the current source code.*

## ⚙️ Prerequisites

Install the following software before running the project locally:

- JDK 17 or later
- Apache Maven
- MySQL Server 8.0 or compatible version
- Visual Studio Code or another Java IDE
- Git (optional, for cloning and pushing changes)

## 💻 Run the Project Locally

### 1. Clone the repository

```bash
git clone https://github.com/venankarakesh28/Student-Attendance-Management-System.git
```

### 2. Open the project folder

```bash
cd Student-Attendance-Management-System
```

### 3. Create the MySQL database

Open MySQL Command Line Client and execute:

```sql
CREATE DATABASE attendance_db;
```

### 4. Configure the database

Open `src/main/resources/application.properties` and configure the MySQL connection.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/attendance_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace `YOUR_MYSQL_PASSWORD` with your local MySQL password. Never commit real database passwords to a public repository.

### 5. Start the application

From the folder containing `pom.xml`, run:

```bash
mvn spring-boot:run
```

### 6. Open the application

Visit:

http://localhost:8080

## 🌐 Deployment

The project is deployed using Render.

- **Live Application:** https://student-attendance-management-system-609m.onrender.com
- **Source Code:** https://github.com/venankarakesh28/Student-Attendance-Management-System

For a persistent production deployment, configure the database connection using environment variables and a database service accessible to Render. Do not rely on local MySQL running on your personal computer for a public deployment.

## 🔒 Security Notes

- Do not publish database passwords or other secrets in source code.
- Use environment variables for production credentials.
- Restrict access to student information in a production environment.
- Add authentication and authorization before using the application with real student data if they are not already implemented.

## 🎯 Future Enhancements

- Admin and faculty login
- Role-based access control
- Student attendance dashboard
- Attendance reports and downloadable CSV/PDF files
- Attendance percentage calculation
- Search and pagination
- Improved responsive UI
- Automated testing and validation

## 👨‍💻 Author

**Rakesh Venanka**

GitHub: https://github.com/venankarakesh28

## 📄 License

This project is intended for educational and learning purposes. Add a license file if you want to distribute the project under a specific open-source license.
