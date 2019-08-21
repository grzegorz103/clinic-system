package edu.ii.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor
{
        @Id
        @GeneratedValue
        private Long id;

        @Column(name="pesel")
        private String pesel;

        @Column(name="name")
        private String name;

        @Column(name="surname")
        private String surname;

        @OneToMany (mappedBy = "doctor", fetch = FetchType.EAGER)
        private List<Patient> patients;
}
