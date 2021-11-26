package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.UnitsMeasurementDTO;
import co.com.faturatech.mapper.UnitsMeasurementMapper;
import co.com.faturatech.service.UnitsMeasurementService;

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
@RequestMapping("/api/v1/unitsMeasurement")
@CrossOrigin(origins = "*")
@Slf4j
public class UnitsMeasurementRestController {
    @Autowired
    private UnitsMeasurementService unitsMeasurementService;
    @Autowired
    private UnitsMeasurementMapper unitsMeasurementMapper;

    @GetMapping(value = "/{untmId}")
    public ResponseEntity<?> findById(@PathVariable("untmId")
    Integer untmId) throws Exception {
        log.debug("Request to findById() UnitsMeasurement");

        UnitsMeasurement unitsMeasurement = (unitsMeasurementService.findById(untmId)
                                                                    .isPresent() == true)
            ? unitsMeasurementService.findById(untmId).get() : null;

        return ResponseEntity.ok()
                             .body(unitsMeasurementMapper.unitsMeasurementToUnitsMeasurementDTO(
                unitsMeasurement));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() UnitsMeasurement");

        return ResponseEntity.ok()
                             .body(unitsMeasurementMapper.listUnitsMeasurementToListUnitsMeasurementDTO(
                unitsMeasurementService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    UnitsMeasurementDTO unitsMeasurementDTO) throws Exception {
        log.debug("Request to save UnitsMeasurement: {}", unitsMeasurementDTO);

        UnitsMeasurement unitsMeasurement = unitsMeasurementMapper.unitsMeasurementDTOToUnitsMeasurement(unitsMeasurementDTO);
        unitsMeasurement = unitsMeasurementService.save(unitsMeasurement);

        return ResponseEntity.ok()
                             .body(unitsMeasurementMapper.unitsMeasurementToUnitsMeasurementDTO(
                unitsMeasurement));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    UnitsMeasurementDTO unitsMeasurementDTO) throws Exception {
        log.debug("Request to update UnitsMeasurement: {}", unitsMeasurementDTO);

        UnitsMeasurement unitsMeasurement = unitsMeasurementMapper.unitsMeasurementDTOToUnitsMeasurement(unitsMeasurementDTO);
        unitsMeasurement = unitsMeasurementService.update(unitsMeasurement);

        return ResponseEntity.ok()
                             .body(unitsMeasurementMapper.unitsMeasurementToUnitsMeasurementDTO(
                unitsMeasurement));
    }

    @DeleteMapping(value = "/{untmId}")
    public ResponseEntity<?> delete(@PathVariable("untmId")
    Integer untmId) throws Exception {
        log.debug("Request to delete UnitsMeasurement");

        unitsMeasurementService.deleteById(untmId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(unitsMeasurementService.count());
    }
}
