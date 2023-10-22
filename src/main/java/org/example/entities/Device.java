package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "\"device\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    private Integer id;

    private Integer person;

    private String description;

    private String address;

    private double consumption;

    public Device(Integer person, String description , String address, double consumption)
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
