package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.PaymentTermsDTO;
import co.com.faturatech.mapper.PaymentTermsMapper;
import co.com.faturatech.service.PaymentTermsService;

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
@RequestMapping("/api/v1/paymentTerms")
@CrossOrigin(origins = "*")
@Slf4j
public class PaymentTermsRestController {
    @Autowired
    private PaymentTermsService paymentTermsService;
    @Autowired
    private PaymentTermsMapper paymentTermsMapper;

    @GetMapping(value = "/{pymtId}")
    public ResponseEntity<?> findById(@PathVariable("pymtId")
    Integer pymtId) throws Exception {
        log.debug("Request to findById() PaymentTerms");

        PaymentTerms paymentTerms = (paymentTermsService.findById(pymtId)
                                                        .isPresent() == true)
            ? paymentTermsService.findById(pymtId).get() : null;

        return ResponseEntity.ok()
                             .body(paymentTermsMapper.paymentTermsToPaymentTermsDTO(
                paymentTerms));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() PaymentTerms");

        return ResponseEntity.ok()
                             .body(paymentTermsMapper.listPaymentTermsToListPaymentTermsDTO(
                paymentTermsService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    PaymentTermsDTO paymentTermsDTO) throws Exception {
        log.debug("Request to save PaymentTerms: {}", paymentTermsDTO);

        PaymentTerms paymentTerms = paymentTermsMapper.paymentTermsDTOToPaymentTerms(paymentTermsDTO);
        paymentTerms = paymentTermsService.save(paymentTerms);

        return ResponseEntity.ok()
                             .body(paymentTermsMapper.paymentTermsToPaymentTermsDTO(
                paymentTerms));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    PaymentTermsDTO paymentTermsDTO) throws Exception {
        log.debug("Request to update PaymentTerms: {}", paymentTermsDTO);

        PaymentTerms paymentTerms = paymentTermsMapper.paymentTermsDTOToPaymentTerms(paymentTermsDTO);
        paymentTerms = paymentTermsService.update(paymentTerms);

        return ResponseEntity.ok()
                             .body(paymentTermsMapper.paymentTermsToPaymentTermsDTO(
                paymentTerms));
    }

    @DeleteMapping(value = "/{pymtId}")
    public ResponseEntity<?> delete(@PathVariable("pymtId")
    Integer pymtId) throws Exception {
        log.debug("Request to delete PaymentTerms");

        paymentTermsService.deleteById(pymtId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(paymentTermsService.count());
    }
}
