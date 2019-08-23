package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Visit;
import edu.ii.uph.tpsi.repositories.PatientRepository;
import edu.ii.uph.tpsi.repositories.UserRepository;
import edu.ii.uph.tpsi.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService
{
        private final VisitRepository visitRepository;

        private final UserRepository userRepository;

        @Autowired
        public VisitServiceImpl ( VisitRepository visitRepository, UserRepository userRepository )
        {
                this.visitRepository = visitRepository;
                this.userRepository = userRepository;
        }

        @Override
        public Visit create ( @NotNull Visit visit )
        {
                Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
                String username = loggedInUser.getName();
                visit.setPatient( userRepository.findByUsername( username ).getPatient() );
                return visitRepository.save( visit );
        }

        @Override
        public Visit update ( Visit visit )
        {
                if ( visitRepository.existsByVisitDate( visit.getVisitDate() ) )
                {
                        throw new RuntimeException( "Invalid date" );
                }
                Visit fromDb = visitRepository.findById( visit.getId() ).orElse( null );

                if ( fromDb == null )
                {
                        throw new RuntimeException( "Visit not found exception" );
                }

                if ( visitRepository.findByPatient_Doctor_Id(
                        fromDb.getPatient()
                                .getDoctor()
                                .getId() )
                        .stream()
                        .anyMatch( e -> e.getVisitDate().equals( visit.getVisitDate() ) ) )
                {
                        throw new RuntimeException( "Date is taken" );
                }

                fromDb.setVisitDate( visit.getVisitDate() );
                return visitRepository.save( fromDb );
        }

        @Override
        public Visit removeById ( Long id )
        {
                Visit visit = visitRepository.findById( id ).orElse( null );

                if ( visit == null )
                {
                        throw new RuntimeException( "Not found exception" );
                }

                visitRepository.delete( visit );

                return visit;
        }

        @Override
        public List<Visit> findByDoctorId ( Long doctorId )
        {
                return visitRepository.findByPatient_Doctor_Id( doctorId );
        }

        @Override
        public List<Visit> findByPatient ()
        {
                Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
                String username = loggedInUser.getName();
                return visitRepository.findAll()
                        .stream()
                        .filter( e -> e.getPatient().getUser().getUsername().equals( username ) )
                        .collect( Collectors.toList() );
        }

        @Override
        public Visit findById ( Long id )
        {
                return visitRepository.findById( id ).get();
        }
}
