package assignment1.EnergyConsum.dtos;

import assignment1.EnergyConsum.entities.Active;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@AllArgsConstructor
public class ActiveDTOBuilder {

    public static ActiveDTO toActiveDTO(Active active) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new ActiveDTO(active.getId(), sdf.format(active.getTimestamp()), active.getDevice(), active.getConsumption());
    }

    public static Active toEntity(ActiveDTO activeDTO) {
        return new Active(Timestamp.valueOf(activeDTO.getTimestamp()) , activeDTO.getDevice(), activeDTO.getConsumption());
    }
    public static Active toEntityWithId(ActiveDTO activeDTO) {
        return new Active(activeDTO.getId(), Timestamp.valueOf(activeDTO.getTimestamp()), activeDTO.getDevice(), activeDTO.getConsumption());
    }
}
