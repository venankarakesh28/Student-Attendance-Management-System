package com.college.attendance.controller;

import com.college.attendance.model.*;
import com.college.attendance.repository.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {
    private final AttendanceRepository attendance;
    private final StudentRepository students;
    public AttendanceController(AttendanceRepository attendance, StudentRepository students) {
        this.attendance = attendance; this.students = students;
    }

    public static class AttendanceRequest {
        @jakarta.validation.constraints.NotNull public Long studentId;
        @jakarta.validation.constraints.NotNull public LocalDate attendanceDate;
        @jakarta.validation.constraints.NotNull public AttendanceStatus status;
        public String subject;
    }

    @GetMapping public List<AttendanceRecord> all(@RequestParam(required=false) LocalDate date,
                                                  @RequestParam(required=false) Long studentId) {
        if (date != null) return attendance.findByAttendanceDate(date);
        if (studentId != null) return attendance.findByStudentIdOrderByAttendanceDateDesc(studentId);
        return attendance.findAll();
    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public AttendanceRecord mark(@Valid @RequestBody AttendanceRequest request) {
        Student student = students.findById(request.studentId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        if (attendance.findByStudentIdAndAttendanceDate(request.studentId, request.attendanceDate).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Attendance already marked for this student and date");
        return attendance.save(new AttendanceRecord(student, request.attendanceDate, request.status, request.subject));
    }

    @PutMapping("/{id}") public AttendanceRecord update(@PathVariable Long id, @RequestBody AttendanceRequest request) {
        AttendanceRecord record = attendance.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendance record not found"));
        Student student = students.findById(request.studentId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        record.setStudent(student); record.setAttendanceDate(request.attendanceDate);
        record.setStatus(request.status); record.setSubject(request.subject);
        return attendance.save(record);
    }

    @GetMapping("/summary/{studentId}") public Map<String, Object> summary(@PathVariable Long studentId) {
        students.findById(studentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        long present = attendance.countByStudentIdAndStatus(studentId, AttendanceStatus.PRESENT);
        long absent = attendance.countByStudentIdAndStatus(studentId, AttendanceStatus.ABSENT);
        long late = attendance.countByStudentIdAndStatus(studentId, AttendanceStatus.LATE);
        long leave = attendance.countByStudentIdAndStatus(studentId, AttendanceStatus.ON_LEAVE);
        long total = present + absent + late + leave;
        double percentage = total == 0 ? 0.0 : (present * 100.0 / total);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("studentId", studentId); result.put("present", present); result.put("absent", absent);
        result.put("late", late); result.put("onLeave", leave); result.put("totalMarked", total);
        result.put("attendancePercentage", Math.round(percentage * 100.0) / 100.0);
        return result;
    }
}
