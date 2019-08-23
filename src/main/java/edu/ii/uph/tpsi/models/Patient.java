package edu.ii.uph.tpsi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Patient
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne(cascade = CascadeType.ALL)
        @JsonIgnore
        @JoinColumn (name = "user_id")
        private User user;

        @OneToMany (mappedBy = "patient")
        @LazyCollection (LazyCollectionOption.FALSE)
        private List<Visit> visits;

        @ManyToOne
        @JoinColumn (name = "doctor_id")
        private Doctor doctor;
}
