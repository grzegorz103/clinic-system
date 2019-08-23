package edu.ii.uph.tpsi.repositories;

import edu.ii.uph.tpsi.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>
{
        UserRole findByUserType ( UserRole.UserType roleAdmin );
}
