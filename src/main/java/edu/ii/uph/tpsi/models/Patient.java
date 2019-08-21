package edu.ii.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table (name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="pesel")
        private String pesel;

        @Column(name="name")
        private String name;

        @Column(name="surname")
        private String surname;

        @Column(name="date_of_birth")
        private Instant dateOfBirth;

        @OneToMany (mappedBy = "patient", fetch = FetchType.EAGER)
        private List<Visit> patients;

        @ManyToOne
        @JoinColumn (name = "doctor_id")
        private Doctor doctor;
}
