package assignment1.EnergyConsum.dtos;

import assignment1.EnergyConsum.entities.Person;
import assignment1.EnergyConsum.entities.Role;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class PersonDTOBuilder {
    public static PersonDTO toPersonDTO(Person person) {
        return new PersonDTO(person.getId(), person.getUsername(), person.getUserPassword(), person.getRole().toString());
    }

    public static Person toEntityWithId(PersonDTO personDTO) {
        return new Person(personDTO.getId(), personDTO.getUsername(), personDTO.getUserPassword(), Role.valueOf( personDTO.getRol()));
    }
    public static Person toEntity(PersonDTO personDTO) {
        return new Person( personDTO.getUsername(), personDTO.getUserPassword(), Role.valueOf( personDTO.getRol()));
    }
}
