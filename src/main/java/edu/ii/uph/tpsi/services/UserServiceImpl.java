package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Patient;
import edu.ii.uph.tpsi.models.User;
import edu.ii.uph.tpsi.models.UserRole;
import edu.ii.uph.tpsi.repositories.PatientRepository;
import edu.ii.uph.tpsi.repositories.UserRepository;
import edu.ii.uph.tpsi.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
        private final UserRepository userRepository;

        private final PatientRepository patientRepository;

        private final UserRoleRepository userRoleRepository;

        @Autowired
        public UserServiceImpl ( UserRepository userRepository, PatientRepository patientRepository, UserRoleRepository userRoleRepository )
        {
                this.userRepository = userRepository;
                this.patientRepository = patientRepository;
                this.userRoleRepository = userRoleRepository;
        }

        @Override
        public User create ( @NotNull User user )
        {
                if ( userRepository.existsByUsername( user.getUsername() ) )
                {
                        throw new RuntimeException( "User already exists" );
                }

                user.setUserRoles( new HashSet<>( Collections.singletonList( userRoleRepository.findByUserType( UserRole.UserType.ROLE_USER ) ) ) );

                User saved = userRepository.save( user );
                patientRepository.save( Patient.builder().user( saved ).build() );
                return saved;
        }

        @Override
        public List<User> findAll ()
        {
                return null;
        }

        @Override
        public User update ( User doctor )
        {
                return null;
        }

        @Override
        public User removeById ( Long id )
        {
                return null;
        }
}
