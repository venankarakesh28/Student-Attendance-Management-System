# Project proposal notes

Use `Student_Attendance_Management_2_Page_Project.pdf` for the concise proposal and `Student_Attendance_Management_Complete_Report.pdf` for the full report. Add your institution-specific details and screenshots before submission.

## Architecture
Browser (HTML/CSS/JS) → Spring Boot REST controllers → Spring Data JPA/Hibernate → MySQL.

## Use-case actors
- Faculty: add student records and mark/update attendance.
- Administrator: manage records and review reports (secure role management is future work in this starter).
- Student: attendance summary viewing is a proposed role; the starter UI summary currently assumes an authorized operator is using the app.
