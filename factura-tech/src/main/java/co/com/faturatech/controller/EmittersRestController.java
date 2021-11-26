package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.EmittersDTO;
import co.com.faturatech.mapper.EmittersMapper;
import co.com.faturatech.service.EmittersService;

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
@RequestMapping("/api/v1/emitters")
@CrossOrigin(origins = "*")
@Slf4j
public class EmittersRestController {
    @Autowired
    private EmittersService emittersService;
    @Autowired
    private EmittersMapper emittersMapper;

    @GetMapping(value = "/{emtId}")
    public ResponseEntity<?> findById(@PathVariable("emtId")
    Integer emtId) throws Exception {
        log.debug("Request to findById() Emitters");

        Emitters emitters = (emittersService.findById(emtId).isPresent() == true)
            ? emittersService.findById(emtId).get() : null;

        return ResponseEntity.ok()
                             .body(emittersMapper.emittersToEmittersDTO(
                emitters));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Emitters");

        return ResponseEntity.ok()
                             .body(emittersMapper.listEmittersToListEmittersDTO(
                emittersService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    EmittersDTO emittersDTO) throws Exception {
        log.debug("Request to save Emitters: {}", emittersDTO);

        Emitters emitters = emittersMapper.emittersDTOToEmitters(emittersDTO);
        emitters = emittersService.save(emitters);

        return ResponseEntity.ok()
                             .body(emittersMapper.emittersToEmittersDTO(
                emitters));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    EmittersDTO emittersDTO) throws Exception {
        log.debug("Request to update Emitters: {}", emittersDTO);

        Emitters emitters = emittersMapper.emittersDTOToEmitters(emittersDTO);
        emitters = emittersService.update(emitters);

        return ResponseEntity.ok()
                             .body(emittersMapper.emittersToEmittersDTO(
                emitters));
    }

    @DeleteMapping(value = "/{emtId}")
    public ResponseEntity<?> delete(@PathVariable("emtId")
    Integer emtId) throws Exception {
        log.debug("Request to delete Emitters");

        emittersService.deleteById(emtId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(emittersService.count());
    }
}
