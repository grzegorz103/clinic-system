package edu.ii.uph.tpsi.repositories;

import edu.ii.uph.tpsi.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long>
{
}
