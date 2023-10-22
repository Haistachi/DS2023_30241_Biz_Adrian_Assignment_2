package assignment1.EnergyConsum.entities;

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
@Table(name = "\"active\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Active {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    private Timestamp timestamp;

    private UUID device;

    private double consumption;

    public Active(Timestamp timestamp, UUID device, double consumption)
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
