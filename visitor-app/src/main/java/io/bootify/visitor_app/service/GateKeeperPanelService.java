package io.bootify.visitor_app.service;

import io.bootify.visitor_app.domain.Visitor;
import io.bootify.visitor_app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GateKeeperPanelService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private VisitorService visitorService;
    public Long create(final CreateVisitorRequestDTO createVisitorRequestDTO) {

        AddressDTO addressDTO=new AddressDTO();
        addressDTO.setLine1(createVisitorRequestDTO.getLine1());
        addressDTO.setLine2(createVisitorRequestDTO.getLine2());
       addressDTO.setCity(createVisitorRequestDTO.getCity());
       addressDTO.setPincode(createVisitorRequestDTO.getPincode());
       addressDTO.setState(createVisitorRequestDTO.getState());
       addressDTO.setCountry(createVisitorRequestDTO.getCountry());
       Long addressId=addressService.create(addressDTO);

      VisitorDTO visitorDTO=  VisitorDTO.builder().name(createVisitorRequestDTO.getName())
                .email(createVisitorRequestDTO.getEmail())
                .address(addressId)
                .idnumber(createVisitorRequestDTO.getIdnumber())
                .phone(createVisitorRequestDTO.getPhone()).build();
      return visitorService.create(visitorDTO);

    }
}
