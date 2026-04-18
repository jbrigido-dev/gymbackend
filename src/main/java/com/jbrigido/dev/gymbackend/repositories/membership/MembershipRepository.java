package com.jbrigido.dev.gymbackend.repositories.membership;

import com.jbrigido.dev.gymbackend.entities.membership.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface MembershipRepository extends JpaRepository<MembershipEntity, Long> {
}
