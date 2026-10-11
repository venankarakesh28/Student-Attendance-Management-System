package com.college.attendance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = "rollNumber"))
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String rollNumber;
    @NotBlank private String fullName;
    private String department;
    private String yearOfStudy;
    private String email;

    public Student() {}
    public Student(String rollNumber, String fullName, String department, String yearOfStudy, String email) {
        this.rollNumber = rollNumber; this.fullName = fullName; this.department = department;
        this.yearOfStudy = yearOfStudy; this.email = email;
    }
    public Long getId() { return id; }
    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getYearOfStudy() { return yearOfStudy; }
    public void setYearOfStudy(String yearOfStudy) { this.yearOfStudy = yearOfStudy; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
