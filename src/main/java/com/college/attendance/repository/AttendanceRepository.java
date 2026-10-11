package com.college.attendance.repository;

import com.college.attendance.model.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<AttendanceRecord, Long> {
    List<AttendanceRecord> findByAttendanceDate(LocalDate attendanceDate);
    List<AttendanceRecord> findByStudentIdOrderByAttendanceDateDesc(Long studentId);
    Optional<AttendanceRecord> findByStudentIdAndAttendanceDate(Long studentId, LocalDate date);
    long countByStudentIdAndStatus(Long studentId, com.college.attendance.model.AttendanceStatus status);
}
