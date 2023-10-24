package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Active {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Timestamp timestamp;
    @Column(nullable = false)
    private Integer device;
    @Column(nullable = false)
    private double consumption;

    public Active(Timestamp timestamp, Integer device, double consumption)
    {
        this.consumption=consumption;
        this.timestamp=timestamp;
        this.device=device;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, device, consumption);
    }
}
