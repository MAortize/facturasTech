package co.com.faturatech.controller;

import co.com.faturatech.domain.*;
import co.com.faturatech.dto.UsersDTO;
import co.com.faturatech.mapper.UsersMapper;
import co.com.faturatech.service.UsersService;

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
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
@Slf4j
public class UsersRestController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private UsersMapper usersMapper;

    @GetMapping(value = "/{usrId}")
    public ResponseEntity<?> findById(@PathVariable("usrId")
    Integer usrId) throws Exception {
        log.debug("Request to findById() Users");

        Users users = (usersService.findById(usrId).isPresent() == true)
            ? usersService.findById(usrId).get() : null;

        return ResponseEntity.ok().body(usersMapper.usersToUsersDTO(users));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Users");

        return ResponseEntity.ok()
                             .body(usersMapper.listUsersToListUsersDTO(
                usersService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    UsersDTO usersDTO) throws Exception {
        log.debug("Request to save Users: {}", usersDTO);

        Users users = usersMapper.usersDTOToUsers(usersDTO);
        users = usersService.save(users);

        return ResponseEntity.ok().body(usersMapper.usersToUsersDTO(users));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    UsersDTO usersDTO) throws Exception {
        log.debug("Request to update Users: {}", usersDTO);

        Users users = usersMapper.usersDTOToUsers(usersDTO);
        users = usersService.update(users);

        return ResponseEntity.ok().body(usersMapper.usersToUsersDTO(users));
    }

    @DeleteMapping(value = "/{usrId}")
    public ResponseEntity<?> delete(@PathVariable("usrId")
    Integer usrId) throws Exception {
        log.debug("Request to delete Users");

        usersService.deleteById(usrId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(usersService.count());
    }
}
