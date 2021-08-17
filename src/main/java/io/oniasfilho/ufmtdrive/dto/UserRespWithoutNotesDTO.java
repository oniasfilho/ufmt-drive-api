package io.oniasfilho.ufmtdrive.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserRespWithoutNotesDTO {
    private Long id;
    private String username;
    private String first_name;
    private String last_name;
}
