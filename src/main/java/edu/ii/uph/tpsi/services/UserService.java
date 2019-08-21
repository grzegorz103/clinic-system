package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Patient;

import java.util.List;

public interface UserService
{
        Patient create( Patient doctor);

        List<Patient> findAll();

        Patient update(Patient doctor);

        Patient removeById(Long id);
}
