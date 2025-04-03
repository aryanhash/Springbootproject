package com.example._stproject.services;

import com.example._stproject.dto.EmployeeDto;
import com.example._stproject.entities.EmployeeEntity;
import com.example._stproject.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = new ModelMapper();
    }
    public EmployeeDto getEmployeeById(Long id) {
        EmployeeEntity employeeEntity= employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDto.class);

    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
        return  employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto createNewEmployee(EmployeeDto inputEmployee) {
        EmployeeEntity employeeEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedemployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedemployeeEntity, EmployeeDto.class);
    }

    public EmployeeDto updateEmployeeById(EmployeeDto employeeDto, Long id) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity savedemployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedemployeeEntity, EmployeeDto.class);
    }
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
