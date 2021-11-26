package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.CitiesDTO;
import co.com.faturatech.mapper.CitiesMapper;
import co.com.faturatech.service.CitiesService;

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
@RequestMapping("/api/v1/cities")
@CrossOrigin(origins = "*")
@Slf4j
public class CitiesRestController {
    @Autowired
    private CitiesService citiesService;
    @Autowired
    private CitiesMapper citiesMapper;

    @GetMapping(value = "/{ctsId}")
    public ResponseEntity<?> findById(@PathVariable("ctsId")
    Integer ctsId) throws Exception {
        log.debug("Request to findById() Cities");

        Cities cities = (citiesService.findById(ctsId).isPresent() == true)
            ? citiesService.findById(ctsId).get() : null;

        return ResponseEntity.ok().body(citiesMapper.citiesToCitiesDTO(cities));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Cities");

        return ResponseEntity.ok()
                             .body(citiesMapper.listCitiesToListCitiesDTO(
                citiesService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    CitiesDTO citiesDTO) throws Exception {
        log.debug("Request to save Cities: {}", citiesDTO);

        Cities cities = citiesMapper.citiesDTOToCities(citiesDTO);
        cities = citiesService.save(cities);

        return ResponseEntity.ok().body(citiesMapper.citiesToCitiesDTO(cities));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    CitiesDTO citiesDTO) throws Exception {
        log.debug("Request to update Cities: {}", citiesDTO);

        Cities cities = citiesMapper.citiesDTOToCities(citiesDTO);
        cities = citiesService.update(cities);

        return ResponseEntity.ok().body(citiesMapper.citiesToCitiesDTO(cities));
    }

    @DeleteMapping(value = "/{ctsId}")
    public ResponseEntity<?> delete(@PathVariable("ctsId")
    Integer ctsId) throws Exception {
        log.debug("Request to delete Cities");

        citiesService.deleteById(ctsId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(citiesService.count());
    }
}
