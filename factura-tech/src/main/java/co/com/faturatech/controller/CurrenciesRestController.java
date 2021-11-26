package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.CurrenciesDTO;
import co.com.faturatech.mapper.CurrenciesMapper;
import co.com.faturatech.service.CurrenciesService;

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
@RequestMapping("/api/v1/currencies")
@CrossOrigin(origins = "*")
@Slf4j
public class CurrenciesRestController {
    @Autowired
    private CurrenciesService currenciesService;
    @Autowired
    private CurrenciesMapper currenciesMapper;

    @GetMapping(value = "/{crrcId}")
    public ResponseEntity<?> findById(@PathVariable("crrcId")
    Integer crrcId) throws Exception {
        log.debug("Request to findById() Currencies");

        Currencies currencies = (currenciesService.findById(crrcId).isPresent() == true)
            ? currenciesService.findById(crrcId).get() : null;

        return ResponseEntity.ok()
                             .body(currenciesMapper.currenciesToCurrenciesDTO(
                currencies));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Currencies");

        return ResponseEntity.ok()
                             .body(currenciesMapper.listCurrenciesToListCurrenciesDTO(
                currenciesService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    CurrenciesDTO currenciesDTO) throws Exception {
        log.debug("Request to save Currencies: {}", currenciesDTO);

        Currencies currencies = currenciesMapper.currenciesDTOToCurrencies(currenciesDTO);
        currencies = currenciesService.save(currencies);

        return ResponseEntity.ok()
                             .body(currenciesMapper.currenciesToCurrenciesDTO(
                currencies));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    CurrenciesDTO currenciesDTO) throws Exception {
        log.debug("Request to update Currencies: {}", currenciesDTO);

        Currencies currencies = currenciesMapper.currenciesDTOToCurrencies(currenciesDTO);
        currencies = currenciesService.update(currencies);

        return ResponseEntity.ok()
                             .body(currenciesMapper.currenciesToCurrenciesDTO(
                currencies));
    }

    @DeleteMapping(value = "/{crrcId}")
    public ResponseEntity<?> delete(@PathVariable("crrcId")
    Integer crrcId) throws Exception {
        log.debug("Request to delete Currencies");

        currenciesService.deleteById(crrcId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(currenciesService.count());
    }
}
