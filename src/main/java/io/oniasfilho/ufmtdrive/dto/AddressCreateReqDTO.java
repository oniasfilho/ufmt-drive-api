package io.oniasfilho.ufmtdrive.dto;

import lombok.Data;

@Data
public class AddressCreateReqDTO {
    private String street;
    private String city;
    private String state;
    private String zip_code;
}
