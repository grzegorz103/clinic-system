package edu.ii.uph.tpsi.repositories;

import edu.ii.uph.tpsi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
        boolean existsByUsername ( String username );

        User findByUsername ( String s );
}
