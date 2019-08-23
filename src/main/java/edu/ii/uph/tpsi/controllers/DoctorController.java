package edu.ii.uph.tpsi.controllers;

import edu.ii.uph.tpsi.models.Doctor;
import edu.ii.uph.tpsi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/doctors")
@CrossOrigin
public class DoctorController
{
        private final DoctorService doctorService;

        @Autowired
        public DoctorController ( DoctorService doctorService )
        {
                this.doctorService = doctorService;
        }

        @PostMapping
        public Doctor create ( @RequestBody Doctor doctor )
        {
                return doctorService.create( doctor );
        }

        @GetMapping
        public List<Doctor> findAll ()
        {
                return doctorService.findAll();
        }

        @PutMapping
        public Doctor update ( @RequestBody Doctor doctor )
        {
                return doctorService.update( doctor );
        }

        @DeleteMapping ("/{id}")
        public Doctor removeById ( @PathVariable ("id") Long id )
        {
                return doctorService.removeById( id );
        }

        @GetMapping("/my")
        public Doctor findUsers(){
                return doctorService.findUsers();
        }
}
