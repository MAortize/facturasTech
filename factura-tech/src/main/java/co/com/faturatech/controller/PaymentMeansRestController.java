package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.PaymentMeansDTO;
import co.com.faturatech.mapper.PaymentMeansMapper;
import co.com.faturatech.service.PaymentMeansService;

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
@RequestMapping("/api/v1/paymentMeans")
@CrossOrigin(origins = "*")
@Slf4j
public class PaymentMeansRestController {
    @Autowired
    private PaymentMeansService paymentMeansService;
    @Autowired
    private PaymentMeansMapper paymentMeansMapper;

    @GetMapping(value = "/{pymmId}")
    public ResponseEntity<?> findById(@PathVariable("pymmId")
    Integer pymmId) throws Exception {
        log.debug("Request to findById() PaymentMeans");

        PaymentMeans paymentMeans = (paymentMeansService.findById(pymmId)
                                                        .isPresent() == true)
            ? paymentMeansService.findById(pymmId).get() : null;

        return ResponseEntity.ok()
                             .body(paymentMeansMapper.paymentMeansToPaymentMeansDTO(
                paymentMeans));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() PaymentMeans");

        return ResponseEntity.ok()
                             .body(paymentMeansMapper.listPaymentMeansToListPaymentMeansDTO(
                paymentMeansService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(
        @Valid
    @RequestBody
    PaymentMeansDTO paymentMeansDTO) throws Exception {
        log.debug("Request to save PaymentMeans: {}", paymentMeansDTO);

        PaymentMeans paymentMeans = paymentMeansMapper.paymentMeansDTOToPaymentMeans(paymentMeansDTO);
        paymentMeans = paymentMeansService.save(paymentMeans);

        return ResponseEntity.ok()
                             .body(paymentMeansMapper.paymentMeansToPaymentMeansDTO(
                paymentMeans));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    PaymentMeansDTO paymentMeansDTO) throws Exception {
        log.debug("Request to update PaymentMeans: {}", paymentMeansDTO);

        PaymentMeans paymentMeans = paymentMeansMapper.paymentMeansDTOToPaymentMeans(paymentMeansDTO);
        paymentMeans = paymentMeansService.update(paymentMeans);

        return ResponseEntity.ok()
                             .body(paymentMeansMapper.paymentMeansToPaymentMeansDTO(
                paymentMeans));
    }

    @DeleteMapping(value = "/{pymmId}")
    public ResponseEntity<?> delete(@PathVariable("pymmId")
    Integer pymmId) throws Exception {
        log.debug("Request to delete PaymentMeans");

        paymentMeansService.deleteById(pymmId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(paymentMeansService.count());
    }
}
