package edu.ii.uph.tpsi.repositories;

import edu.ii.uph.tpsi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/patients")
public interface PatientRepository extends JpaRepository<Patient, Long>
{

}
