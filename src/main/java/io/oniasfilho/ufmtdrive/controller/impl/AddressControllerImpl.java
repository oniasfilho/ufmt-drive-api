package io.oniasfilho.ufmtdrive.controller.impl;

import io.oniasfilho.ufmtdrive.controller.AddressController;
import io.oniasfilho.ufmtdrive.dto.AddressRespDTO;
import io.oniasfilho.ufmtdrive.entity.Address;
import io.oniasfilho.ufmtdrive.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AddressControllerImpl implements AddressController {

    AddressService service;

    public AddressControllerImpl(AddressService service) {
        this.service = service;
    }

    @PostMapping("/api/address")
    public Address createAddress(@RequestBody Address address) {
            return service.createAddress(address);
    }

    @GetMapping("/api/address")
    public List<AddressRespDTO> getAllAddress() {
        return service.getAllAddress();
    }

    @GetMapping("/api/address/{id}")
    public AddressRespDTO getAddressById(@PathVariable(name = "id") Long id) {
        return service.getAddressById(id);
    }

    @PutMapping("/api/address")
    public AddressRespDTO updateAddress(@RequestBody AddressRespDTO address) {
        return service.updateAddress(address);
    }

    @DeleteMapping("/api/address/{id}")
    public Long deleteAddress(@PathVariable(name="id") Long id) {
        return service.deleteAddress(id);
    }
}
