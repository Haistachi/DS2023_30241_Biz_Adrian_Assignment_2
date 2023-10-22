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
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(generator = "integer")
    @GenericGenerator(name = "integer", strategy = "integer")
    @Type(type = "integer")
    private Integer id;

    private String username;

    private String userPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public Person(String username) {
        this.username = username;
    }
    public Person(String username, String userPassword) {
        this.username = username;
        this.userPassword = userPassword;
    }

    public Person(String username, String userPassword, Role role) {
        this.username = username;
        this.userPassword = userPassword;
        this.role = role;
    }
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
