package edu.ii.uph.tpsi.controllers;

import edu.ii.uph.tpsi.models.Doctor;
import edu.ii.uph.tpsi.models.Patient;
import edu.ii.uph.tpsi.services.DoctorService;
import edu.ii.uph.tpsi.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/patients")
public class PatientController
{
        private final PatientService patientService;

        @Autowired
        public PatientController ( PatientService patientService )
        {
                this.patientService = patientService;
        }

        @PostMapping
        public Patient create ( @RequestBody Patient patient )
        {
                return patientService.create( patient );
        }

        @GetMapping
        public List<Patient> findAll ()
        {
                return patientService.findAll();
        }

        @PutMapping
        public Patient update ( @RequestBody Patient patient )
        {
                return patientService.update( patient );
        }

        @DeleteMapping ("/{id}")
        public Patient removeById ( @PathVariable ("id") Long id )
        {
                return patientService.removeById( id );
        }
}
