package edu.ii.uph.tpsi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn (name = "user_id")
        private User user;

        @OneToMany (mappedBy = "doctor", fetch = FetchType.EAGER)
        @LazyCollection (LazyCollectionOption.FALSE)
        @JsonIgnore
        private List<Patient> patients;

        @Column (name = "deleted")
        private boolean deleted;
}
