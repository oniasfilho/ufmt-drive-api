package io.oniasfilho.ufmtdrive.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String url;
    private String username;
    private String key;
    private String password;
    @ManyToOne
    private User user;
}
