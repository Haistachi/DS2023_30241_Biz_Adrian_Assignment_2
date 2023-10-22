package org.example.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Consum implements Serializable {
    @JsonProperty("timestamp") String time;
    @JsonProperty("device_id") Integer id;
    @JsonProperty("measurement_value") double value;

    @Override
    public String toString() {
        return "Consum{" +
                "time='" + time + '\'' +
                ", id=" + id.toString() +
                ", value=" + value +
                '}';
    }
}
