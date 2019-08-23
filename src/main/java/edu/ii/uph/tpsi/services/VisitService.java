package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Patient;
import edu.ii.uph.tpsi.models.Visit;

import java.util.List;

public interface VisitService
{
        Visit create( Visit visit);

        List<Visit> findAll();

        Visit update(Visit visit);

        Visit removeById(Long id);

        List<Visit> findByDoctorId(Long doctorId);

        List<Visit> findByPatient();

        Visit findById ( Long id );
}
