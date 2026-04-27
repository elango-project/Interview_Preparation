package com.attendance.attendancebasedsystem.Service;

import com.attendance.attendancebasedsystem.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository repo;
}
