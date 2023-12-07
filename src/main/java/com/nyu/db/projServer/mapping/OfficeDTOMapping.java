package com.nyu.db.projServer.mapping;

import com.nyu.db.projServer.DTO.Response.AddressDTO;
import com.nyu.db.projServer.DTO.Response.OfficeDTO;
import com.nyu.db.projServer.model.Office;

public class OfficeDTOMapping {
    public static OfficeDTO toOfficeDTO(Office office) {
        OfficeDTO officeDTO = new OfficeDTO();
        officeDTO.setOfficeID(office.getOfficeID());

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressID(office.getAddress().getAddressID());
        addressDTO.setStreet(office.getAddress().getStreet());
        addressDTO.setCity(office.getAddress().getCity());
        addressDTO.setState(office.getAddress().getState());
        addressDTO.setZipCode(office.getAddress().getZipCode());
        officeDTO.setAddress(addressDTO);
        officeDTO.setPhone(office.getPhone());

        return officeDTO;
    }
}
