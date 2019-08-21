package edu.ii.uph.tpsi.services;

import edu.ii.uph.tpsi.models.Patient;
import edu.ii.uph.tpsi.models.Visit;

import java.util.List;

public interface VisitService
{
        Visit create( Visit doctor);

        List<Visit> findAll();

        Visit update(Visit doctor);

        Visit removeById(Long id);
}
