package org.example.security;

import java.util.ArrayList;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.example.entities.Person;
import org.example.repositories.PersonRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;
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