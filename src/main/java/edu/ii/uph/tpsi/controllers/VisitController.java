package edu.ii.uph.tpsi.controllers;

import edu.ii.uph.tpsi.models.Doctor;
import edu.ii.uph.tpsi.models.Visit;
import edu.ii.uph.tpsi.services.DoctorService;
import edu.ii.uph.tpsi.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/visits")
public class VisitController
{
        private final VisitService visitService;

        @Autowired
        public VisitController ( VisitService visitService )
        {
                this.visitService = visitService;
        }

        @PostMapping
        public Visit create ( @RequestBody Visit visit )
        {
                return visitService.create( visit );
        }

        @GetMapping
        public List<Visit> findAll ()
        {
                return visitService.findAll();
        }

        @PutMapping
        public Visit update ( @RequestBody Visit visit )
        {
                return visitService.update( visit );
        }

        @DeleteMapping ("/{id}")
        public Visit removeById ( @PathVariable ("id") Long id )
        {
                return visitService.removeById( id );
        }
}
