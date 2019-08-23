package edu.ii.uph.tpsi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.Set;

@Entity
@Table (name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (name = "username")
        private String username;

        @Column (name = "password")
        private String password;

        @Column (name = "pesel")
        @NotEmpty
        private String pesel;

        @Column (name = "name")
        @NotEmpty
        private String name;

        @Column (name = "surname")
        @NotEmpty        private String surname;

        @ManyToMany (fetch = FetchType.EAGER)
        @JoinTable (name = "users_roles",
                joinColumns = @JoinColumn (name = "user_id"),
                inverseJoinColumns = @JoinColumn (name = "role_id"))
        private Set<UserRole> userRoles;

        @OneToOne (mappedBy = "user", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY, optional = false)
        @JsonIgnore
        private Doctor doctor;

        @OneToOne (mappedBy = "user", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY, optional = false)
        private Patient patient;

        private String email;
}
