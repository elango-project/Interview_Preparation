package com.attendance.attendancebasedsystem.Repository;

import com.attendance.attendancebasedsystem.Entity.AttendenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendenceEntity,Integer> {

}
