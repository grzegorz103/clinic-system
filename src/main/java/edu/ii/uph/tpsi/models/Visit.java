package edu.ii.uph.tpsi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table (name = "visits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (name = "visit_date")
        private Instant visitDate;

        @Column (name = "reason")
        private String reason;

        @ManyToOne
        @JoinColumn (name = "patient_id")
        @JsonIgnore
        private Patient patient;

}
