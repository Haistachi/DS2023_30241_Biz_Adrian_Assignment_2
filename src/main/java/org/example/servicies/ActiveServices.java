package assignment1.EnergyConsum.servicies;

import assignment1.EnergyConsum.dtos.ActiveDTO;
import assignment1.EnergyConsum.dtos.ActiveDTOBuilder;
import assignment1.EnergyConsum.entities.Active;
import assignment1.EnergyConsum.entities.Device;
import assignment1.EnergyConsum.repositories.ActiveRepository;
import assignment1.EnergyConsum.repositories.DeviceRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ActiveServices {
    @Autowired
    private final ActiveRepository activeRepository;
    @Autowired
    private final DeviceRepository deviceRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ActiveServices.class);
    public List<ActiveDTO> findActive() {
        List<Active> activeList = activeRepository.findAll();
        return activeList.stream()
                .map(ActiveDTOBuilder::toActiveDTO)
                .collect(Collectors.toList());
    }

    public ActiveDTO findActiveById(UUID id) {
        Optional<Active> prosumerOptional = activeRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Active with id {} was not found in db", id);
        }
        return ActiveDTOBuilder.toActiveDTO(prosumerOptional.get());
    }

    public UUID insert(ActiveDTO activeDTO) {
        Active active = ActiveDTOBuilder.toEntity(activeDTO);

        Active lastActive= activeRepository.findActiveByTimestampAndDevice(active.getTimestamp(), active.getDevice()).get(0);
        if(active.getConsumption()-lastActive.getConsumption()>0)
        {
            String message=new String();
            Timestamp timestamp=active.getTimestamp();
            message=message.concat(active.getDevice().toString());
            message=message.concat(" has over expected consume at the ");
            message=message.concat(timestamp.toString());
            Device device= deviceRepository.getById(active.getDevice());
            String reciver= device.getPerson().toString();
            //Notification notification= new Notification(reciver, message);
        }

        active = activeRepository.save(active);
        LOGGER.debug("Active with id {} was inserted in db", active.getId());
        return active.getId();
    }

    public void deleteActive(UUID id) {
        Optional<Active> prosumerOptional = activeRepository.findById(id);
        if (prosumerOptional.isPresent()) {
            activeRepository.delete(prosumerOptional.get());
            LOGGER.debug("Active with id {} was deleted in db", id);
        }
    }

    public void updateActive(ActiveDTO activeDTO) {
        Active active = ActiveDTOBuilder.toEntityWithId(activeDTO);
        active = activeRepository.save(active);
        LOGGER.debug("Active with id {} was updated in db", active.getId());
    }

    public List<ActiveDTO> findActiveByDeviceAndDate(UUID idDevice, String date) {
        List<Active> activeList = activeRepository.findByDeviceAndTimestampBetween(idDevice,
                Timestamp.valueOf(date + " 00:00:00.0"),
                Timestamp.valueOf(date + " 23:59:59.0"));
        List<Active> activeListDif = activeList.stream().sorted(Comparator.comparing(Active::getTimestamp)).collect(Collectors.toList());
        for(int i=activeListDif.size()-1; i>0;i--)
        {
            activeListDif.get(i).setConsumption(activeListDif.get(i).getConsumption()-activeListDif.get(i-1).getConsumption());
        }
        return activeListDif.stream().map(ActiveDTOBuilder::toActiveDTO).collect(Collectors.toList());
    }
}
