package io.oniasfilho.ufmtdrive.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "user_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Note> notes;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}

