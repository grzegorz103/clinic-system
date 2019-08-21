package edu.ii.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

        @Column (name = "pesel")
        private String pesel;

        @Column (name = "name")
        private String name;

        @Column (name = "surname")
        private String surname;

        @Column (name = "date_of_birth")
        private Instant dateOfBirth;

        @OneToOne
        @JoinColumn (name = "user_id")
        private User user;

        @OneToMany (mappedBy = "patient")
        @LazyCollection (LazyCollectionOption.FALSE)
        private List<Visit> visits;

        @ManyToOne
        @JoinColumn (name = "doctor_id")
        private Doctor doctor;
}
