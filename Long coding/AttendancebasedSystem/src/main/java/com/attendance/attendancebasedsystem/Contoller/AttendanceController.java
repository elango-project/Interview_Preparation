package com.attendance.attendancebasedsystem.Contoller;

import com.attendance.attendancebasedsystem.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService service;

}
