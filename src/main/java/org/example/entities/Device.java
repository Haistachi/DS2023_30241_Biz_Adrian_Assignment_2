package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "\"device\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue(generator = "Integer")
    @GenericGenerator(name = "Integer", strategy = "Integer")
    @Type(type = "Integer")
    private Integer id;

    private Integer person;

    private String description;

    private String address;

    private int consumption;

    public Device(Integer person, String description , String address, int consumption)
    {
        this.person=person;
        this.description=description;
        this.address=address;
        this.consumption=consumption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, description, address, consumption);
    }
}
