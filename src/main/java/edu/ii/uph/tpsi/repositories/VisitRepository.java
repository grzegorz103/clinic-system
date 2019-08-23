package edu.ii.uph.tpsi.repositories;

import edu.ii.uph.tpsi.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long>
{
        List<Visit> findByPatient_Doctor_Id(Long id);

        boolean existsByVisitDate(Instant visitDate);

        void deleteAllByPatient_Doctor_Id(Long id);
}
