package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.BillsDTO;
import co.com.faturatech.mapper.BillsMapper;
import co.com.faturatech.service.BillsService;

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
@RequestMapping("/api/v1/bills")
@CrossOrigin(origins = "*")
@Slf4j
public class BillsRestController {
    @Autowired
    private BillsService billsService;
    @Autowired
    private BillsMapper billsMapper;

    @GetMapping(value = "/{bllId}")
    public ResponseEntity<?> findById(@PathVariable("bllId")
    Integer bllId) throws Exception {
        log.debug("Request to findById() Bills");

        Bills bills = (billsService.findById(bllId).isPresent() == true)
            ? billsService.findById(bllId).get() : null;

        return ResponseEntity.ok().body(billsMapper.billsToBillsDTO(bills));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Bills");

        return ResponseEntity.ok()
                             .body(billsMapper.listBillsToListBillsDTO(
                billsService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    BillsDTO billsDTO) throws Exception {
        log.debug("Request to save Bills: {}", billsDTO);

        Bills bills = billsMapper.billsDTOToBills(billsDTO);
        bills = billsService.save(bills);

        return ResponseEntity.ok().body(billsMapper.billsToBillsDTO(bills));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    BillsDTO billsDTO) throws Exception {
        log.debug("Request to update Bills: {}", billsDTO);

        Bills bills = billsMapper.billsDTOToBills(billsDTO);
        bills = billsService.update(bills);

        return ResponseEntity.ok().body(billsMapper.billsToBillsDTO(bills));
    }

    @DeleteMapping(value = "/{bllId}")
    public ResponseEntity<?> delete(@PathVariable("bllId")
    Integer bllId) throws Exception {
        log.debug("Request to delete Bills");

        billsService.deleteById(bllId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(billsService.count());
    }
}
