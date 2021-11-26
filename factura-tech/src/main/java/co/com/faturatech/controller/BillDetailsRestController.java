package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.BillDetailsDTO;
import co.com.faturatech.mapper.BillDetailsMapper;
import co.com.faturatech.service.BillDetailsService;

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
@RequestMapping("/api/v1/billDetails")
@CrossOrigin(origins = "*")
@Slf4j
public class BillDetailsRestController {
    @Autowired
    private BillDetailsService billDetailsService;
    @Autowired
    private BillDetailsMapper billDetailsMapper;

    @GetMapping(value = "/{blldId}")
    public ResponseEntity<?> findById(@PathVariable("blldId")
    Integer blldId) throws Exception {
        log.debug("Request to findById() BillDetails");

        BillDetails billDetails = (billDetailsService.findById(blldId)
                                                     .isPresent() == true)
            ? billDetailsService.findById(blldId).get() : null;

        return ResponseEntity.ok()
                             .body(billDetailsMapper.billDetailsToBillDetailsDTO(
                billDetails));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() BillDetails");

        return ResponseEntity.ok()
                             .body(billDetailsMapper.listBillDetailsToListBillDetailsDTO(
                billDetailsService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    BillDetailsDTO billDetailsDTO) throws Exception {
        log.debug("Request to save BillDetails: {}", billDetailsDTO);

        BillDetails billDetails = billDetailsMapper.billDetailsDTOToBillDetails(billDetailsDTO);
        billDetails = billDetailsService.save(billDetails);

        return ResponseEntity.ok()
                             .body(billDetailsMapper.billDetailsToBillDetailsDTO(
                billDetails));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    BillDetailsDTO billDetailsDTO) throws Exception {
        log.debug("Request to update BillDetails: {}", billDetailsDTO);

        BillDetails billDetails = billDetailsMapper.billDetailsDTOToBillDetails(billDetailsDTO);
        billDetails = billDetailsService.update(billDetails);

        return ResponseEntity.ok()
                             .body(billDetailsMapper.billDetailsToBillDetailsDTO(
                billDetails));
    }

    @DeleteMapping(value = "/{blldId}")
    public ResponseEntity<?> delete(@PathVariable("blldId")
    Integer blldId) throws Exception {
        log.debug("Request to delete BillDetails");

        billDetailsService.deleteById(blldId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(billDetailsService.count());
    }
}
