package edu.ii.uph.tpsi.services;

import com.sun.istack.internal.NotNull;
import edu.ii.uph.tpsi.models.Doctor;
import edu.ii.uph.tpsi.repositories.DoctorRepository;
import edu.ii.uph.tpsi.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService
{
        private final DoctorRepository doctorRepository;
        private final VisitRepository visitRepository;

        @Autowired
        public DoctorServiceImpl ( DoctorRepository doctorRepository, VisitRepository visitRepository )
        {
                this.doctorRepository = doctorRepository;
                this.visitRepository = visitRepository;
        }

        @Override
        public Doctor create ( @NotNull Doctor doctor )
        {
                doctor.setDeleted( false );
                return doctorRepository.save( doctor );

        }

        @Override
        public List<Doctor> findAll ()
        {
                return doctorRepository.findAll()
                        .stream()
                        .filter( e -> !e.isDeleted() )
                        .collect( Collectors.toList() );
        }

        @Override
        public Doctor update ( @NotNull Doctor doctor )
        {
                return doctorRepository.save( doctor );
        }

        @SuppressWarnings ("ConstantConditions")
        @Override
        @Transactional
        public Doctor removeById ( Long id )
        {
                if ( !doctorRepository.existsById( id ) )
                {
                        throw new RuntimeException( "Doctor does not exists" );
                }

                Doctor fromDb = doctorRepository.findById( id ).get();

                fromDb.setDeleted( true );
                doctorRepository.save( fromDb );
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
