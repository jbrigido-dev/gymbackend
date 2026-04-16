package com.jbrigido.dev.gymbackend.entities.membership;

import com.jbrigido.dev.gymbackend.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "Memberships")
public class MembershipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembership;
    @Column(columnDefinition = "boolean default 1")
    private Boolean status;
    @Column(columnDefinition = "date default (current_date)")
    private LocalDate start_date;
    private LocalDate end_date;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime created_at;
    @Enumerated(EnumType.STRING)
    private TypeMembership type;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity idUser;

    public enum TypeMembership {
        DAILY,
        WEEKLY,
        BIWEEKLY,
        MONTHLY,
        YEARLY
    }
}
