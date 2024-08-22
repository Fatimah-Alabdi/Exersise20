package com.example.exersise19.Service;

import com.example.exersise19.Api.ApiException;
import com.example.exersise19.DTO.AddressDTO;
import com.example.exersise19.Model.Address;
import com.example.exersise19.Model.Teacher;
import com.example.exersise19.Repository.AddressRepository;
import com.example.exersise19.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public List<Address> findAllTeacherAddress() {
        return addressRepository.findAll();
    }
    public void addTeacherAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("teacher not found");

        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);


    }
    public void updateAddress(AddressDTO addressDTO) {
        Address address=addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            throw new ApiException("address not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
    }
    public void deleteAddress(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("teacher not found");
        }
        teacherRepository.delete(teacher);
    }
}
