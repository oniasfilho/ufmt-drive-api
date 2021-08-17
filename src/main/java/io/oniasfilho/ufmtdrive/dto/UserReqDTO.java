package io.oniasfilho.ufmtdrive.dto;

import lombok.Data;

@Data
public class UserReqDTO {
    private Long id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
}
