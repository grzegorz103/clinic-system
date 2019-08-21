package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.repositories.PatientRepository;
import edu.ii.uph.tpsi.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService
{
        private final PatientRepository patientRepository;

        @Autowired
        public PatientServiceImpl ( PatientRepository patientRepository )
        {
                this.patientRepository = patientRepository;
        }

        @Override
        public Patient create ( @NotNull Patient doctor )
        {
                if ( patientRepository.existsByPesel( doctor.getPesel() ) )
                {
                        throw new RuntimeException( "Doctor already exists" );
                }

                return patientRepository.save( doctor );
        }

        @Override
        public List<Patient> findAll ()
        {
                return patientRepository.findAll();
        }

        @Override
        public Patient update ( @NotNull Patient patient )
        {
                Patient fromDb = patientRepository.findByPesel( patient.getPesel() );

                if ( fromDb == null )
                {
                        throw new RuntimeException( "Patient does not exists" );
                }

                fromDb.setDateOfBirth( patient.getDateOfBirth() );
                fromDb.setName( patient.getName() );
                fromDb.setDateOfBirth( patient.getDateOfBirth() );
                fromDb.setSurname( patient.getSurname() );

                return patientRepository.save( fromDb );
        }

        @Override
        public Patient removeById ( Long id )
        {
                if ( !patientRepository.existsById( id ) )
                {
                        throw new RuntimeException( "Patient does not exists" );
                }

                Patient fromDb = patientRepository.findById( id ).get();
                patientRepository.delete( fromDb );

                return fromDb;
        }
}
