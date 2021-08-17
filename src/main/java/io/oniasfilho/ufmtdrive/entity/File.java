package io.oniasfilho.ufmtdrive.entity;

import javax.persistence.*;
@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String contentType;
    private String fileSize;
    @ManyToOne
    private User user;
}
