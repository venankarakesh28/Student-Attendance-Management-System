# Student Attendance Management System

A starter college project built with Java 17, Spring Boot, Spring Data JPA, Hibernate, MySQL, and HTML/CSS/JavaScript.

## Features
- Add and list students, including roll number, department, year, and email.
- Mark attendance as `PRESENT`, `ABSENT`, `LATE`, or `ON_LEAVE`.
- Filter attendance records by date or student.
- View a per-student attendance summary and present percentage.
- Prevent duplicate roll numbers and duplicate attendance for the same student/date.

## Requirements
- JDK 17+
- Maven 3.8+
- MySQL 8+

## Run
1. Start MySQL and create a database (optional; the JDBC URL can create it):
   ```sql
   CREATE DATABASE attendance_db;
   ```
2. Set credentials if needed. Defaults are `root` and an empty password:
   - Windows PowerShell:
     ```powershell
     $env:DB_USERNAME="root"
     $env:DB_PASSWORD="your_password"
     ```
   - macOS/Linux:
     ```bash
     export DB_USERNAME=root
     export DB_PASSWORD='your_password'
     ```
3. From this folder run:
   ```bash
   mvn spring-boot:run
   ```
4. Open `http://localhost:8080`.

## REST API
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/students` | List students |
| GET | `/api/students/{id}` | Get one student |
| POST | `/api/students` | Add student (JSON body) |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |
| GET | `/api/attendance` | List all records |
| GET | `/api/attendance?date=2026-10-11` | Filter by date |
| GET | `/api/attendance?studentId=1` | Filter by student |
| POST | `/api/attendance` | Mark attendance |
| PUT | `/api/attendance/{id}` | Update attendance |
| GET | `/api/attendance/summary/{studentId}` | Attendance summary |

Example student JSON:
```json
{"rollNumber":"CS101","fullName":"Asha Kumar","department":"CSE","yearOfStudy":"2","email":"asha@example.com"}
```
Example attendance JSON:
```json
{"studentId":1,"attendanceDate":"2026-10-11","status":"PRESENT","subject":"Database Systems"}
```

## Architecture
Browser UI (HTML/CSS/JS) → REST Controllers → Spring Data JPA Repositories / Hibernate → MySQL.

## Important scope notes
This is an educational starter implementation, not a production-ready campus system. It does not yet implement user login, role-based access control, CSV/PDF export, bulk attendance, or audit history. Add authentication, authorization, stronger DTO validation, database migration tooling, and backups before handling real student data. Deleting a student with attendance records may be rejected by the database due to referential integrity; remove or archive related records first.
