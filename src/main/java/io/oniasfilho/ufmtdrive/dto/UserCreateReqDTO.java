package io.oniasfilho.ufmtdrive.dto;

import lombok.Data;

@Data
public class UserCreateReqDTO {
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private AddressCreateReqDTO address;
}