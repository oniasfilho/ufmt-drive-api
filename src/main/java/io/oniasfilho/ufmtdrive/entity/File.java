package io.oniasfilho.ufmtdrive.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
@Entity
@ConfigurationProperties(prefix = "file")
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
