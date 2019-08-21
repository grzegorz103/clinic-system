package edu.ii.uph.tpsi.repositories;

import edu.ii.uph.tpsi.models.Doctor;
import edu.ii.uph.tpsi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>
{
}
