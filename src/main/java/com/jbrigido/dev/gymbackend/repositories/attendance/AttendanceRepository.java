package com.jbrigido.dev.gymbackend.repositories.attendance;

import com.jbrigido.dev.gymbackend.entities.attendance.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
}
