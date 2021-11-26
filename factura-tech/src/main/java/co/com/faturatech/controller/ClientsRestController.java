package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.ClientsDTO;
import co.com.faturatech.mapper.ClientsMapper;
import co.com.faturatech.service.ClientsService;

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
@RequestMapping("/api/v1/clients")
@CrossOrigin(origins = "*")
@Slf4j
public class ClientsRestController {
    @Autowired
    private ClientsService clientsService;
    @Autowired
    private ClientsMapper clientsMapper;

    @GetMapping(value = "/{clnId}")
    public ResponseEntity<?> findById(@PathVariable("clnId")
    Integer clnId) throws Exception {
        log.debug("Request to findById() Clients");

        Clients clients = (clientsService.findById(clnId).isPresent() == true)
            ? clientsService.findById(clnId).get() : null;

        return ResponseEntity.ok()
                             .body(clientsMapper.clientsToClientsDTO(clients));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Clients");

        return ResponseEntity.ok()
                             .body(clientsMapper.listClientsToListClientsDTO(
                clientsService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    ClientsDTO clientsDTO) throws Exception {
        log.debug("Request to save Clients: {}", clientsDTO);

        Clients clients = clientsMapper.clientsDTOToClients(clientsDTO);
        clients = clientsService.save(clients);

        return ResponseEntity.ok()
                             .body(clientsMapper.clientsToClientsDTO(clients));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    ClientsDTO clientsDTO) throws Exception {
        log.debug("Request to update Clients: {}", clientsDTO);

        Clients clients = clientsMapper.clientsDTOToClients(clientsDTO);
        clients = clientsService.update(clients);

        return ResponseEntity.ok()
                             .body(clientsMapper.clientsToClientsDTO(clients));
    }

    @DeleteMapping(value = "/{clnId}")
    public ResponseEntity<?> delete(@PathVariable("clnId")
    Integer clnId) throws Exception {
        log.debug("Request to delete Clients");

        clientsService.deleteById(clnId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(clientsService.count());
    }
}
