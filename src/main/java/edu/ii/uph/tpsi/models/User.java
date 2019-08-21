package edu.ii.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
}
