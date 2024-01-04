package org.example.servicies;

import org.example.dtos.PersonDTO;
import org.example.dtos.PersonDTOBuilder;
import org.example.entities.Person;
import org.example.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LoginService implements UserDetailsService {
    private final PersonRepository personRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
    public String log(PersonDTO person) throws UsernameNotFoundException
    {
        Optional<Person> prosumerOptional = personRepository.findByUsername(person.getUsername());
        if(person.getUserPassword().equals(prosumerOptional.get().getUserPassword())) {
            LOGGER.debug("Person with name {} has loggedIn", person.getUsername());
            return prosumerOptional.map(value -> value.getRole().toString()).orElse(null);
        }
        else
        {
            LOGGER.debug("Incorect Password {} for {}", person.getUserPassword(), person.getUsername());
            throw new UsernameNotFoundException("User not found with username: " + person.getUsername());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> prosumerOptional = personRepository.findByUsername(username);
        if (prosumerOptional.isPresent()) {
            return new User(prosumerOptional.get().getUsername(), prosumerOptional.get().getUserPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
