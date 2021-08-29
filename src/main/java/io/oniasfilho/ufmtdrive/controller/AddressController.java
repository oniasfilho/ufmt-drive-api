package io.oniasfilho.ufmtdrive.controller;

import io.oniasfilho.ufmtdrive.dto.AddressRespDTO;
import io.oniasfilho.ufmtdrive.entity.Address;

import java.util.List;

public interface AddressController {
    public Address createAddress(Address address);
    public List<AddressRespDTO> getAllAddress();
    public AddressRespDTO getAddressById(Long id);
    public AddressRespDTO updateAddress(AddressRespDTO address);
    public Long deleteAddress(Long id);
}
