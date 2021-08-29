package io.oniasfilho.ufmtdrive.dto;

import lombok.Data;

@Data
public class AddressRespDTO {
    private Long id;
    private String city;
    private String state;
    private String street;
    private String zip_code;
    private Long user_id;
}
