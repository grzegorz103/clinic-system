package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Visit;
import edu.ii.uph.tpsi.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                Visit fromDb = visitRepository.findById( visit.getId() ).orElse( null );

                if ( fromDb == null )
                {
                        throw new RuntimeException( "Visit not found exception" );
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
}
