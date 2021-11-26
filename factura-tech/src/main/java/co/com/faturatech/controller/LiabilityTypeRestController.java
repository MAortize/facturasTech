package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.LiabilityTypeDTO;
import co.com.faturatech.mapper.LiabilityTypeMapper;
import co.com.faturatech.service.LiabilityTypeService;

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
@RequestMapping("/api/v1/liabilityType")
@CrossOrigin(origins = "*")
@Slf4j
public class LiabilityTypeRestController {
    @Autowired
    private LiabilityTypeService liabilityTypeService;
    @Autowired
    private LiabilityTypeMapper liabilityTypeMapper;

    @GetMapping(value = "/{lbltId}")
    public ResponseEntity<?> findById(@PathVariable("lbltId")
    Integer lbltId) throws Exception {
        log.debug("Request to findById() LiabilityType");

        LiabilityType liabilityType = (liabilityTypeService.findById(lbltId)
                                                           .isPresent() == true)
            ? liabilityTypeService.findById(lbltId).get() : null;

        return ResponseEntity.ok()
                             .body(liabilityTypeMapper.liabilityTypeToLiabilityTypeDTO(
                liabilityType));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() LiabilityType");

        return ResponseEntity.ok()
                             .body(liabilityTypeMapper.listLiabilityTypeToListLiabilityTypeDTO(
                liabilityTypeService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    LiabilityTypeDTO liabilityTypeDTO) throws Exception {
        log.debug("Request to save LiabilityType: {}", liabilityTypeDTO);

        LiabilityType liabilityType = liabilityTypeMapper.liabilityTypeDTOToLiabilityType(liabilityTypeDTO);
        liabilityType = liabilityTypeService.save(liabilityType);

        return ResponseEntity.ok()
                             .body(liabilityTypeMapper.liabilityTypeToLiabilityTypeDTO(
                liabilityType));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    LiabilityTypeDTO liabilityTypeDTO) throws Exception {
        log.debug("Request to update LiabilityType: {}", liabilityTypeDTO);

        LiabilityType liabilityType = liabilityTypeMapper.liabilityTypeDTOToLiabilityType(liabilityTypeDTO);
        liabilityType = liabilityTypeService.update(liabilityType);

        return ResponseEntity.ok()
                             .body(liabilityTypeMapper.liabilityTypeToLiabilityTypeDTO(
                liabilityType));
    }

    @DeleteMapping(value = "/{lbltId}")
    public ResponseEntity<?> delete(@PathVariable("lbltId")
    Integer lbltId) throws Exception {
        log.debug("Request to delete LiabilityType");

        liabilityTypeService.deleteById(lbltId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(liabilityTypeService.count());
    }
}
