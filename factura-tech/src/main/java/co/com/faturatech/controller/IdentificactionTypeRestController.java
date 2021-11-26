package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.IdentificactionTypeDTO;
import co.com.faturatech.mapper.IdentificactionTypeMapper;
import co.com.faturatech.service.IdentificactionTypeService;

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
@RequestMapping("/api/v1/identificactionType")
@CrossOrigin(origins = "*")
@Slf4j
public class IdentificactionTypeRestController {
    @Autowired
    private IdentificactionTypeService identificactionTypeService;
    @Autowired
    private IdentificactionTypeMapper identificactionTypeMapper;

    @GetMapping(value = "/{idtId}")
    public ResponseEntity<?> findById(@PathVariable("idtId")
    Integer idtId) throws Exception {
        log.debug("Request to findById() IdentificactionType");

        IdentificactionType identificactionType = (identificactionTypeService.findById(idtId)
                                                                             .isPresent() == true)
            ? identificactionTypeService.findById(idtId).get() : null;

        return ResponseEntity.ok()
                             .body(identificactionTypeMapper.identificactionTypeToIdentificactionTypeDTO(
                identificactionType));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() IdentificactionType");

        return ResponseEntity.ok()
                             .body(identificactionTypeMapper.listIdentificactionTypeToListIdentificactionTypeDTO(
                identificactionTypeService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    IdentificactionTypeDTO identificactionTypeDTO) throws Exception {
        log.debug("Request to save IdentificactionType: {}",
            identificactionTypeDTO);

        IdentificactionType identificactionType = identificactionTypeMapper.identificactionTypeDTOToIdentificactionType(identificactionTypeDTO);
        identificactionType = identificactionTypeService.save(identificactionType);

        return ResponseEntity.ok()
                             .body(identificactionTypeMapper.identificactionTypeToIdentificactionTypeDTO(
                identificactionType));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    IdentificactionTypeDTO identificactionTypeDTO) throws Exception {
        log.debug("Request to update IdentificactionType: {}",
            identificactionTypeDTO);

        IdentificactionType identificactionType = identificactionTypeMapper.identificactionTypeDTOToIdentificactionType(identificactionTypeDTO);
        identificactionType = identificactionTypeService.update(identificactionType);

        return ResponseEntity.ok()
                             .body(identificactionTypeMapper.identificactionTypeToIdentificactionTypeDTO(
                identificactionType));
    }

    @DeleteMapping(value = "/{idtId}")
    public ResponseEntity<?> delete(@PathVariable("idtId")
    Integer idtId) throws Exception {
        log.debug("Request to delete IdentificactionType");

        identificactionTypeService.deleteById(idtId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(identificactionTypeService.count());
    }
}
