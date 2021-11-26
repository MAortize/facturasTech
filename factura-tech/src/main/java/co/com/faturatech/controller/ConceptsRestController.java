package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.ConceptsDTO;
import co.com.faturatech.mapper.ConceptsMapper;
import co.com.faturatech.service.ConceptsService;

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
@RequestMapping("/api/v1/concepts")
@CrossOrigin(origins = "*")
@Slf4j
public class ConceptsRestController {
    @Autowired
    private ConceptsService conceptsService;
    @Autowired
    private ConceptsMapper conceptsMapper;

    @GetMapping(value = "/{cncId}")
    public ResponseEntity<?> findById(@PathVariable("cncId")
    Integer cncId) throws Exception {
        log.debug("Request to findById() Concepts");

        Concepts concepts = (conceptsService.findById(cncId).isPresent() == true)
            ? conceptsService.findById(cncId).get() : null;

        return ResponseEntity.ok()
                             .body(conceptsMapper.conceptsToConceptsDTO(
                concepts));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Concepts");

        return ResponseEntity.ok()
                             .body(conceptsMapper.listConceptsToListConceptsDTO(
                conceptsService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    ConceptsDTO conceptsDTO) throws Exception {
        log.debug("Request to save Concepts: {}", conceptsDTO);

        Concepts concepts = conceptsMapper.conceptsDTOToConcepts(conceptsDTO);
        concepts = conceptsService.save(concepts);

        return ResponseEntity.ok()
                             .body(conceptsMapper.conceptsToConceptsDTO(
                concepts));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    ConceptsDTO conceptsDTO) throws Exception {
        log.debug("Request to update Concepts: {}", conceptsDTO);

        Concepts concepts = conceptsMapper.conceptsDTOToConcepts(conceptsDTO);
        concepts = conceptsService.update(concepts);

        return ResponseEntity.ok()
                             .body(conceptsMapper.conceptsToConceptsDTO(
                concepts));
    }

    @DeleteMapping(value = "/{cncId}")
    public ResponseEntity<?> delete(@PathVariable("cncId")
    Integer cncId) throws Exception {
        log.debug("Request to delete Concepts");

        conceptsService.deleteById(cncId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(conceptsService.count());
    }
}
