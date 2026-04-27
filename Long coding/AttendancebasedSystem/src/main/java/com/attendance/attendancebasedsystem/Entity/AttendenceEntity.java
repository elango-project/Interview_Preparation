package com.attendance.attendancebasedsystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AttendenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Student_Name")
    private String name;
    @Column(name = "Student_Attendance")
    private String attendance;
}
