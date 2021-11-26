package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.LogsDTO;
import co.com.faturatech.mapper.LogsMapper;
import co.com.faturatech.service.LogsService;

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
@RequestMapping("/api/v1/logs")
@CrossOrigin(origins = "*")
@Slf4j
public class LogsRestController {
    @Autowired
    private LogsService logsService;
    @Autowired
    private LogsMapper logsMapper;

    @GetMapping(value = "/{lgsId}")
    public ResponseEntity<?> findById(@PathVariable("lgsId")
    Integer lgsId) throws Exception {
        log.debug("Request to findById() Logs");

        Logs logs = (logsService.findById(lgsId).isPresent() == true)
            ? logsService.findById(lgsId).get() : null;

        return ResponseEntity.ok().body(logsMapper.logsToLogsDTO(logs));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Logs");

        return ResponseEntity.ok()
                             .body(logsMapper.listLogsToListLogsDTO(
                logsService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    LogsDTO logsDTO) throws Exception {
        log.debug("Request to save Logs: {}", logsDTO);

        Logs logs = logsMapper.logsDTOToLogs(logsDTO);
        logs = logsService.save(logs);

        return ResponseEntity.ok().body(logsMapper.logsToLogsDTO(logs));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    LogsDTO logsDTO) throws Exception {
        log.debug("Request to update Logs: {}", logsDTO);

        Logs logs = logsMapper.logsDTOToLogs(logsDTO);
        logs = logsService.update(logs);

        return ResponseEntity.ok().body(logsMapper.logsToLogsDTO(logs));
    }

    @DeleteMapping(value = "/{lgsId}")
    public ResponseEntity<?> delete(@PathVariable("lgsId")
    Integer lgsId) throws Exception {
        log.debug("Request to delete Logs");

        logsService.deleteById(lgsId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(logsService.count());
    }
}
