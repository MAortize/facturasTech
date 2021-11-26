package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.PersonTypeDTO;
import co.com.faturatech.mapper.PersonTypeMapper;
import co.com.faturatech.service.PersonTypeService;

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
@RequestMapping("/api/v1/personType")
@CrossOrigin(origins = "*")
@Slf4j
public class PersonTypeRestController {
    @Autowired
    private PersonTypeService personTypeService;
    @Autowired
    private PersonTypeMapper personTypeMapper;

    @GetMapping(value = "/{prstId}")
    public ResponseEntity<?> findById(@PathVariable("prstId")
    Integer prstId) throws Exception {
        log.debug("Request to findById() PersonType");

        PersonType personType = (personTypeService.findById(prstId).isPresent() == true)
            ? personTypeService.findById(prstId).get() : null;

        return ResponseEntity.ok()
                             .body(personTypeMapper.personTypeToPersonTypeDTO(
                personType));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() PersonType");

        return ResponseEntity.ok()
                             .body(personTypeMapper.listPersonTypeToListPersonTypeDTO(
                personTypeService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    PersonTypeDTO personTypeDTO) throws Exception {
        log.debug("Request to save PersonType: {}", personTypeDTO);

        PersonType personType = personTypeMapper.personTypeDTOToPersonType(personTypeDTO);
        personType = personTypeService.save(personType);

        return ResponseEntity.ok()
                             .body(personTypeMapper.personTypeToPersonTypeDTO(
                personType));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    PersonTypeDTO personTypeDTO) throws Exception {
        log.debug("Request to update PersonType: {}", personTypeDTO);

        PersonType personType = personTypeMapper.personTypeDTOToPersonType(personTypeDTO);
        personType = personTypeService.update(personType);

        return ResponseEntity.ok()
                             .body(personTypeMapper.personTypeToPersonTypeDTO(
                personType));
    }

    @DeleteMapping(value = "/{prstId}")
    public ResponseEntity<?> delete(@PathVariable("prstId")
    Integer prstId) throws Exception {
        log.debug("Request to delete PersonType");

        personTypeService.deleteById(prstId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(personTypeService.count());
    }
}
