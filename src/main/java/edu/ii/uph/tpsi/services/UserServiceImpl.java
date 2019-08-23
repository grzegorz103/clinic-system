package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Patient;
import edu.ii.uph.tpsi.models.User;
import edu.ii.uph.tpsi.models.UserRole;
import edu.ii.uph.tpsi.repositories.PatientRepository;
import edu.ii.uph.tpsi.repositories.UserRepository;
import edu.ii.uph.tpsi.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
        private final UserRepository userRepository;

        private final PatientRepository patientRepository;

        private final UserRoleRepository userRoleRepository;

        private final BCryptPasswordEncoder encoder;

        @Autowired
        public UserServiceImpl ( UserRepository userRepository,
                                 PatientRepository patientRepository,
                                 UserRoleRepository userRoleRepository,
                                 BCryptPasswordEncoder encoder )
        {
                this.userRepository = userRepository;
                this.patientRepository = patientRepository;
                this.userRoleRepository = userRoleRepository;
                this.encoder = encoder;
        }

        @Override
        public User create ( @NotNull User user )
        {
                if ( userRepository.existsByUsername( user.getUsername() ) )
                {
                        throw new RuntimeException( "User already exists" );
                }

                user.setUserRoles( new HashSet<>( Collections.singletonList( userRoleRepository.findByUserType( UserRole.UserType.ROLE_USER ) ) ) );
                user.setPassword( encoder.encode( user.getPassword() ) );
                User saved = userRepository.save( user );
                patientRepository.save( Patient.builder().doctor( user.getPatient().getDoctor() ).user( saved ).build() );
                return saved;
        }


        @Override
        public UserDetails loadUserByUsername ( String s ) throws UsernameNotFoundException
        {
                User u = userRepository.findByUsername( s );

                if ( u == null )
                {
                        throw new UsernameNotFoundException( "User not found" );
                }

                return new org.springframework.security.core.userdetails.User(
                        u.getUsername(),
                        u.getPassword(),
                        u.getUserRoles().stream()
                                .map( e -> new SimpleGrantedAuthority( e.getUserType().name() ) )
                                .collect( Collectors.toList() )
                );
        }

        @Override
        public boolean isLoginCorrect ( String username, String password )
        {
                User u = userRepository.findByUsername( username );
                if ( u == null )
                {
                        return false;
                }

                return u.getUsername().equals( username )
                        && encoder.matches( password, u.getPassword() );
        }

        @Override
        public boolean hasAdminRole ()
        {
                return (( org.springframework.security.core.userdetails.User ) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal()
                ).getAuthorities()
                        .stream()
                        .anyMatch( e -> e.getAuthority().equals( "ROLE_ADMIN" ) );
        }
}

