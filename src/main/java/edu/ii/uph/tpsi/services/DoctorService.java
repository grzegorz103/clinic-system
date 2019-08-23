package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Doctor;

import java.util.List;

public interface DoctorService
{
        Doctor create(Doctor doctor);

        List<Doctor> findAll();

        Doctor update(Doctor doctor);

        Doctor removeById(Long id);
}
