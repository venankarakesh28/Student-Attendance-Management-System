package com.college.attendance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "attendance_records",
       uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "attendance_date"}))
public class AttendanceRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;
    @NotNull private LocalDate attendanceDate;
    @Enumerated(EnumType.STRING) @NotNull
    private AttendanceStatus status;
    private String subject;

    public AttendanceRecord() {}
    public AttendanceRecord(Student student, LocalDate attendanceDate, AttendanceStatus status, String subject) {
        this.student = student; this.attendanceDate = attendanceDate; this.status = status; this.subject = subject;
    }
    public Long getId() { return id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public LocalDate getAttendanceDate() { return attendanceDate; }
    public void setAttendanceDate(LocalDate attendanceDate) { this.attendanceDate = attendanceDate; }
    public AttendanceStatus getStatus() { return status; }
    public void setStatus(AttendanceStatus status) { this.status = status; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
