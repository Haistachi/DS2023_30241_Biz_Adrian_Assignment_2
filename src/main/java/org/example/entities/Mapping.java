package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mapping {

    @Id
    @GeneratedValue(generator = "int")
    @GenericGenerator(name = "int", strategy = "int")
    @Type(type = "int")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person person;

}
