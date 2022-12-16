package com.examenblanc.azizataboubiexamenblanc.Entities;

import com.examenblanc.azizataboubiexamenblanc.Entities.Project;
import com.examenblanc.azizataboubiexamenblanc.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private  String pwd;
    private String firstname;
    private  String lastname;
    private Role role;
    @ManyToMany(mappedBy = "intervenants")
    private List<Project> projects;
    @OneToMany
    private List<Project> projetsClient;
}
