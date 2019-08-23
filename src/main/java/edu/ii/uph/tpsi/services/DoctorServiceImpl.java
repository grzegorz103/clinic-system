package edu.ii.uph.tpsi.services;

import com.sun.istack.internal.NotNull;
import edu.ii.uph.tpsi.models.Doctor;
import edu.ii.uph.tpsi.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService
{
        private final DoctorRepository doctorRepository;

        @Autowired
        public DoctorServiceImpl ( DoctorRepository doctorRepository )
        {
                this.doctorRepository = doctorRepository;
        }

        @Override
        public Doctor create ( @NotNull Doctor doctor )
        {
                return doctorRepository.save( doctor );
        }

        @Override
        public List<Doctor> findAll ()
        {
                return doctorRepository.findAll();
        }

        @Override
        public Doctor update ( @NotNull Doctor doctor )
        {
                return doctorRepository.save( doctor );
        }

        @SuppressWarnings ("ConstantConditions")
        @Override
        public Doctor removeById ( Long id )
        {
                if ( !doctorRepository.existsById( id ) )
                {
                        throw new RuntimeException( "Doctor does not exists" );
                }

                Doctor fromDb = doctorRepository.findById( id ).get();
                doctorRepository.delete( fromDb );

                return fromDb;
        }

        @Override
        public Doctor findUsers ()
        {
                Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
                String username = loggedInUser.getName();
                return doctorRepository.findAll()
                        .stream()
                        .filter( e -> e.getPatients()
                                .stream()
                                .filter( g -> g.getUser() != null )
                                .anyMatch( f -> f.getUser().getUsername().equals( username ) )
                        )
                        .findFirst()
                        .orElse( null );
        }
}
