package edu.ii.uph.tpsi.controllers;

import edu.ii.uph.tpsi.models.Doctor;
import edu.ii.uph.tpsi.models.Patient;
import edu.ii.uph.tpsi.models.User;
import edu.ii.uph.tpsi.services.DoctorService;
import edu.ii.uph.tpsi.services.PatientService;
import edu.ii.uph.tpsi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController
{
        private final UserService userService;

        @Autowired
        public UserController ( UserService userService )
        {
                this.userService = userService;
        }

        @PostMapping
        public User create ( @RequestBody User user )
        {
                return userService.create( user );
        }

        @GetMapping
        public List<User> findAll ()
        {
                return userService.findAll();
        }

        @PutMapping
        public User update ( @RequestBody User user )
        {
                return userService.update( user );
        }

        @DeleteMapping ("/{id}")
        public User removeById ( @PathVariable ("id") Long id )
        {
                return userService.removeById( id );
        }
}
