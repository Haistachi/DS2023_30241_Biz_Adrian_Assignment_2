package org.example.controller;

import org.example.dtos.PersonDTO;
import org.example.servicies.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private final LoginService loginService;
    @PostMapping()
    public ResponseEntity<String> singIn(@Valid @RequestBody PersonDTO personDTO) {
        String rol= loginService.log(personDTO);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }
}
