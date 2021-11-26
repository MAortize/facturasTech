package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.PaymentMethodsDTO;
import co.com.faturatech.mapper.PaymentMethodsMapper;
import co.com.faturatech.service.PaymentMethodsService;

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
@RequestMapping("/api/v1/paymentMethods")
@CrossOrigin(origins = "*")
@Slf4j
public class PaymentMethodsRestController {
    @Autowired
    private PaymentMethodsService paymentMethodsService;
    @Autowired
    private PaymentMethodsMapper paymentMethodsMapper;

    @GetMapping(value = "/{pymmtId}")
    public ResponseEntity<?> findById(@PathVariable("pymmtId")
    Integer pymmtId) throws Exception {
        log.debug("Request to findById() PaymentMethods");

        PaymentMethods paymentMethods = (paymentMethodsService.findById(pymmtId)
                                                              .isPresent() == true)
            ? paymentMethodsService.findById(pymmtId).get() : null;

        return ResponseEntity.ok()
                             .body(paymentMethodsMapper.paymentMethodsToPaymentMethodsDTO(
                paymentMethods));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() PaymentMethods");

        return ResponseEntity.ok()
                             .body(paymentMethodsMapper.listPaymentMethodsToListPaymentMethodsDTO(
                paymentMethodsService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    PaymentMethodsDTO paymentMethodsDTO) throws Exception {
        log.debug("Request to save PaymentMethods: {}", paymentMethodsDTO);

        PaymentMethods paymentMethods = paymentMethodsMapper.paymentMethodsDTOToPaymentMethods(paymentMethodsDTO);
        paymentMethods = paymentMethodsService.save(paymentMethods);

        return ResponseEntity.ok()
                             .body(paymentMethodsMapper.paymentMethodsToPaymentMethodsDTO(
                paymentMethods));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    PaymentMethodsDTO paymentMethodsDTO) throws Exception {
        log.debug("Request to update PaymentMethods: {}", paymentMethodsDTO);

        PaymentMethods paymentMethods = paymentMethodsMapper.paymentMethodsDTOToPaymentMethods(paymentMethodsDTO);
        paymentMethods = paymentMethodsService.update(paymentMethods);

        return ResponseEntity.ok()
                             .body(paymentMethodsMapper.paymentMethodsToPaymentMethodsDTO(
                paymentMethods));
    }

    @DeleteMapping(value = "/{pymmtId}")
    public ResponseEntity<?> delete(@PathVariable("pymmtId")
    Integer pymmtId) throws Exception {
        log.debug("Request to delete PaymentMethods");

        paymentMethodsService.deleteById(pymmtId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(paymentMethodsService.count());
    }
}
