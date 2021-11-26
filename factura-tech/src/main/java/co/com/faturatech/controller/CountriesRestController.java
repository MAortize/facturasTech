package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.CountriesDTO;
import co.com.faturatech.mapper.CountriesMapper;
import co.com.faturatech.service.CountriesService;

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
@RequestMapping("/api/v1/countries")
@CrossOrigin(origins = "*")
@Slf4j
public class CountriesRestController {
    @Autowired
    private CountriesService countriesService;
    @Autowired
    private CountriesMapper countriesMapper;

    @GetMapping(value = "/{cntId}")
    public ResponseEntity<?> findById(@PathVariable("cntId")
    Integer cntId) throws Exception {
        log.debug("Request to findById() Countries");

        Countries countries = (countriesService.findById(cntId).isPresent() == true)
            ? countriesService.findById(cntId).get() : null;

        return ResponseEntity.ok()
                             .body(countriesMapper.countriesToCountriesDTO(
                countries));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Countries");

        return ResponseEntity.ok()
                             .body(countriesMapper.listCountriesToListCountriesDTO(
                countriesService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    CountriesDTO countriesDTO) throws Exception {
        log.debug("Request to save Countries: {}", countriesDTO);

        Countries countries = countriesMapper.countriesDTOToCountries(countriesDTO);
        countries = countriesService.save(countries);

        return ResponseEntity.ok()
                             .body(countriesMapper.countriesToCountriesDTO(
                countries));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    CountriesDTO countriesDTO) throws Exception {
        log.debug("Request to update Countries: {}", countriesDTO);

        Countries countries = countriesMapper.countriesDTOToCountries(countriesDTO);
        countries = countriesService.update(countries);

        return ResponseEntity.ok()
                             .body(countriesMapper.countriesToCountriesDTO(
                countries));
    }

    @DeleteMapping(value = "/{cntId}")
    public ResponseEntity<?> delete(@PathVariable("cntId")
    Integer cntId) throws Exception {
        log.debug("Request to delete Countries");

        countriesService.deleteById(cntId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(countriesService.count());
    }
}
