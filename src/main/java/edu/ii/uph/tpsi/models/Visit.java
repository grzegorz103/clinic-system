package edu.ii.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table (name="visits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="visit_date")
        private Instant visitDate;

        @ManyToOne
        @JoinColumn (name = "patient_id")
        private Patient patient;
}
