package edu.ii.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToMany (fetch = FetchType.EAGER)
        @JoinTable (name = "users_roles",
                joinColumns = @JoinColumn (name = "user_id"),
                inverseJoinColumns = @JoinColumn (name = "role_id"))
        private Set<UserRole> userRoles;

        @OneToOne (mappedBy = "user", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY, optional = false)
        private Doctor doctor;

        @OneToOne (mappedBy = "user", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY, optional = false)
        private Patient patient;
}
