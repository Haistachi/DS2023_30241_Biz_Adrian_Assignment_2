package org.example.dtos;

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
public class ActiveDTO{
    private Integer id;
    private String timestamp;// date+time
    private Integer device;
    private double consumption;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiveDTO activeDTO = (ActiveDTO) o;
        return Objects.equals(timestamp, activeDTO.timestamp) &&
                device==activeDTO.device &&
                consumption==activeDTO.consumption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, device, consumption);
    }
}
