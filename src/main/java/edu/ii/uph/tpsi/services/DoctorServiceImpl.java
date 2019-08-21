package edu.ii.uph.tpsi.services;

import com.sun.istack.internal.NotNull;
import edu.ii.uph.tpsi.models.Doctor;
import edu.ii.uph.tpsi.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
                if ( doctorRepository.existsByPesel( doctor.getPesel() ) )
                {
                        throw new RuntimeException( "Doctor already exists" );
                }

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
                Doctor fromDb = doctorRepository.findByPesel( doctor.getPesel() );
                if ( fromDb == null )
                {
                        throw new RuntimeException( "Doctor does not exists" );
                }

                fromDb.setName( doctor.getName() );
                fromDb.setPesel( doctor.getPesel() );
                fromDb.setSurname( doctor.getSurname() );

                return doctorRepository.save( fromDb );
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
}
