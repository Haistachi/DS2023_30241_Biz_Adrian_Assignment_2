package assignment1.EnergyConsum.servicies;

import assignment1.EnergyConsum.dtos.PersonDTO;
import assignment1.EnergyConsum.entities.Person;
import assignment1.EnergyConsum.repositories.PersonRepository;
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
