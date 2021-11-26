package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.DepartmentsDTO;
import co.com.faturatech.mapper.DepartmentsMapper;
import co.com.faturatech.service.DepartmentsService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@RestController
@RequestMapping("/api/v1/departments")
@CrossOrigin(origins = "*")
@Slf4j
public class DepartmentsRestController {
    @Autowired
    private DepartmentsService departmentsService;
    @Autowired
    private DepartmentsMapper departmentsMapper;

    @GetMapping(value = "/{dptId}")
    public ResponseEntity<?> findById(@PathVariable("dptId")
    Integer dptId) throws Exception {
        log.debug("Request to findById() Departments");

        Departments departments = (departmentsService.findById(dptId).isPresent() == true)
            ? departmentsService.findById(dptId).get() : null;

        return ResponseEntity.ok()
                             .body(departmentsMapper.departmentsToDepartmentsDTO(
                departments));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Departments");

        return ResponseEntity.ok()
                             .body(departmentsMapper.listDepartmentsToListDepartmentsDTO(
                departmentsService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    DepartmentsDTO departmentsDTO) throws Exception {
        log.debug("Request to save Departments: {}", departmentsDTO);

        Departments departments = departmentsMapper.departmentsDTOToDepartments(departmentsDTO);
        departments = departmentsService.save(departments);

        return ResponseEntity.ok()
                             .body(departmentsMapper.departmentsToDepartmentsDTO(
                departments));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    DepartmentsDTO departmentsDTO) throws Exception {
        log.debug("Request to update Departments: {}", departmentsDTO);

        Departments departments = departmentsMapper.departmentsDTOToDepartments(departmentsDTO);
        departments = departmentsService.update(departments);

        return ResponseEntity.ok()
                             .body(departmentsMapper.departmentsToDepartmentsDTO(
                departments));
    }

    @DeleteMapping(value = "/{dptId}")
    public ResponseEntity<?> delete(@PathVariable("dptId")
    Integer dptId) throws Exception {
        log.debug("Request to delete Departments");

        departmentsService.deleteById(dptId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(departmentsService.count());
    }
}
