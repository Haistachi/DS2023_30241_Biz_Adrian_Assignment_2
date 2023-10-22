package org.example.servicies;

import org.example.dtos.PersonDTO;
import org.example.entities.Person;
import org.example.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class LoginService {
    private final PersonRepository personRepository;
    public String log(PersonDTO person)
    {
        Optional<Person> prosumerOptional = personRepository.findByUsername(person.getUsername());
        return prosumerOptional.map(value -> value.getRole().toString()).orElse(null);
    }
}
