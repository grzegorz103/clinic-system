package edu.ii.uph.tpsi.config;


import edu.ii.uph.tpsi.models.User;
import edu.ii.uph.tpsi.models.UserRole;
import edu.ii.uph.tpsi.repositories.UserRepository;
import edu.ii.uph.tpsi.repositories.UserRoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Configuration
public class RepositoryInitializer
{
        private final UserRoleRepository userRoleRepository;

        private final UserRepository userRepository;

        private final PasswordEncoder encoder;

        @Autowired
        public RepositoryInitializer ( UserRoleRepository userRoleRepository, UserRepository userRepository, PasswordEncoder encoder )
        {
                this.userRoleRepository = userRoleRepository;
                this.userRepository = userRepository;
                this.encoder = encoder;
        }

        @Bean
        public InitializingBean initializingBean ()
        {
                return () -> {


                        if ( userRoleRepository.findAll().isEmpty() )
                        {
                                userRoleRepository.save( new UserRole( 1L, UserRole.UserType.ROLE_USER ) );
                                userRoleRepository.save( new UserRole( 2L, UserRole.UserType.ROLE_ADMIN ) );
                        }

                        if ( userRepository.findAll().isEmpty() )
                        {
                                userRepository.save(
                                        User.builder()
                                                .username( "admin" )
                                                .password( encoder.encode( "admin1" ) )
                                                .userRoles( new HashSet<>( Arrays.asList( userRoleRepository.findByUserType( UserRole.UserType.ROLE_ADMIN ), userRoleRepository.findByUserType( UserRole.UserType.ROLE_USER ) ) ) )
                                                .build()
                                );

                                userRepository.save(
                                        User.builder()
                                                .username( "user1" )
                                                .password( encoder.encode( "usertest" ) )
                                                .userRoles( new HashSet<>( Collections.singleton( userRoleRepository.findByUserType( UserRole.UserType.ROLE_USER ) ) ) )
                                                .build()
                                );

                                userRepository.save(
                                        User.builder()
                                                .username( "user2" )
                                                .password( encoder.encode( "usertest2" ) )
                                                .userRoles( new HashSet<>( Collections.singleton( userRoleRepository.findByUserType( UserRole.UserType.ROLE_USER ) ) ) )
                                                .build()
                                );
                        }

                };
        }
}
