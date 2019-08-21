package edu.ii.uph.tpsi.repositories;

import edu.ii.uph.tpsi.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long>
{
}
