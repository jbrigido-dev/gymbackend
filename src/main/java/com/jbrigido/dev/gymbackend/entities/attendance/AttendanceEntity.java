package com.jbrigido.dev.gymbackend.entities.attendance;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "attendances")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAttendance;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity idUser;
    @Column(columnDefinition = "DATE default(current_date)")
    private LocalDate checkDate;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime checkIn;
    
}
