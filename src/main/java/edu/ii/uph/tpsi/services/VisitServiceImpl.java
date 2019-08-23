package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Visit;
import edu.ii.uph.tpsi.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService
{
        private final VisitRepository visitRepository;

        @Autowired
        public VisitServiceImpl ( VisitRepository visitRepository )
        {
                this.visitRepository = visitRepository;
        }

        @Override
        public Visit create ( Visit visit )
        {
                return null;
        }

        @Override
        public List<Visit> findAll ()
        {
                return null;
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
                return null;
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
