package assignment1.EnergyConsum.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO{
    private UUID id;
    private String username;

    private String userPassword;

    private String rol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(username, personDTO.username) && Objects.equals(userPassword, personDTO.userPassword) && Objects.equals(rol, personDTO.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, userPassword, rol);
    }
}
