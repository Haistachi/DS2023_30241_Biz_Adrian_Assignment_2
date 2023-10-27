package org.example.servicies;

import org.example.dtos.PersonDTO;
import org.example.dtos.PersonDTOBuilder;
import org.example.entities.Person;
import org.example.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class LoginService {
    private final PersonRepository personRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
    public String log(PersonDTO person)
    {
        Optional<Person> prosumerOptional = personRepository.findByUsername(person.getUsername());
        LOGGER.debug("Person with name {} has loggedIn", person.getUsername());
        return prosumerOptional.map(value -> value.getRole().toString()).orElse(null);
    }
}
