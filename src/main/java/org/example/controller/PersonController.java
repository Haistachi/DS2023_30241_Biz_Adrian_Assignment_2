package assignment1.EnergyConsum.controller;

import assignment1.EnergyConsum.dtos.PersonDTO;
import assignment1.EnergyConsum.servicies.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/person")
public class PersonController {
    private final PersonServices personService;

    @GetMapping()
    public ResponseEntity<List<PersonDTO>> getPersons() {
        List<PersonDTO> dtos = personService.findUsers();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @Autowired
    public PersonController(PersonServices personServices) {
        this.personService = personServices;
    }

    @PostMapping()
    public ResponseEntity<UUID> insertPerson(@Valid @RequestBody PersonDTO personDTO) {
        UUID personID = personService.insert(personDTO);
        return new ResponseEntity<>(personID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable("id") UUID personId) {
        PersonDTO dto = personService.findUserById(personId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") UUID personId) {
        personService.deleteUser(personId);
        return new ResponseEntity<>("Success delete", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updatePerson(@Valid @RequestBody PersonDTO personDTO) {
        personService.update(personDTO);
        return new ResponseEntity<>("Success Update", HttpStatus.OK);
    }

}
