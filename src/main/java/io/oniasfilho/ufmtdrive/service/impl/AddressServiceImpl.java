package io.oniasfilho.ufmtdrive.service.impl;

import io.oniasfilho.ufmtdrive.dto.AddressRespDTO;
import io.oniasfilho.ufmtdrive.entity.Address;
import io.oniasfilho.ufmtdrive.repository.AddressRepository;
import io.oniasfilho.ufmtdrive.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address createAddress(Address address) {
        return repository.save(address);
    }

    @Override
    public List<AddressRespDTO> getAllAddress() {
        Iterable<Address> allAddresses = repository.findAll();
        List<AddressRespDTO> resp = new ArrayList<>();

        allAddresses.forEach(address -> {
            AddressRespDTO dto = new AddressRespDTO();

            dto.setId(address.getId());
            dto.setCity(address.getCity());
            dto.setState(address.getState());
            dto.setStreet(address.getStreet());
            dto.setZip_code(address.getZip_code());
//            dto.setUser_id(address.getUser().getId());

            resp.add(dto);
        });

        return resp;
    }

    @Override
    public AddressRespDTO getAddressById(Long id) {
        Address recebido = repository.findById(id).get();
        AddressRespDTO dto = new AddressRespDTO();
        dto.setId(recebido.getId());
        dto.setCity(recebido.getCity());
        dto.setState(recebido.getState());
        dto.setStreet(recebido.getStreet());
        dto.setZip_code(recebido.getZip_code());
//        dto.setUser_id(recebido.getUser().getId());
        return dto;
    }

    @Override
    public AddressRespDTO updateAddress(AddressRespDTO ReqDto) {
        return null;
    }

    @Override
    public Long deleteAddress(Long id) {
        repository.deleteById(id);
        return id;
    }
}
