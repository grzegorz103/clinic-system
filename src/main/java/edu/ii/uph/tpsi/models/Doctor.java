package edu.ii.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor
{
        @Id
        @GeneratedValue
        private Long id;

        @OneToOne
        @JoinColumn (name = "user_id")
        private User user;

        @OneToMany (mappedBy = "doctor", fetch = FetchType.EAGER)
        @LazyCollection (LazyCollectionOption.FALSE)
        private List<Patient> patients;
}
