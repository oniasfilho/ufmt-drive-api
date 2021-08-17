package io.oniasfilho.ufmtdrive.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String noteTitle;
    private String noteDescription;
    @ManyToOne
    private User user;
}
