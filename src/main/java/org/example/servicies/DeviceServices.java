package assignment1.EnergyConsum.servicies;

import assignment1.EnergyConsum.dtos.DeviceDTO;
import assignment1.EnergyConsum.dtos.DeviceDTOBuilder;
import assignment1.EnergyConsum.entities.Device;
import assignment1.EnergyConsum.repositories.DeviceRepository;
import assignment1.EnergyConsum.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DeviceServices {
    @Autowired
    private final DeviceRepository deviceRepository;
    @Autowired
    private final PersonRepository personRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceServices.class);
    public List<DeviceDTO> findDevices() {
        List<Device> deviceList = deviceRepository.findAll();
        return deviceList.stream()
                .map(DeviceDTOBuilder::toDeviceDTO)
                .collect(Collectors.toList());
    }

    public DeviceDTO findDeviceById(UUID id) {
        Optional<Device> prosumerOptional = deviceRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Device with id {} was not found in db", id);
        }
        return DeviceDTOBuilder.toDeviceDTO(prosumerOptional.get());
    }

    public List<DeviceDTO> findDeviceByOwner(String person) {
        UUID id = personRepository.findByUsername(person).get().getId();
        List<Device> deviceList = deviceRepository.findByPerson(id);
        return deviceList.stream()
                .map(DeviceDTOBuilder::toDeviceDTO)
                .collect(Collectors.toList());
    }

    public UUID insert(DeviceDTO deviceDTO) {
        Device device = DeviceDTOBuilder.toEntity(deviceDTO);
        device = deviceRepository.save(device);
        LOGGER.debug("Device with id {} was inserted in db", device.getId());
        return device.getId();
    }

    public void deleteDevice(UUID id) {
        Optional<Device> prosumerOptional = deviceRepository.findById(id);
        if (prosumerOptional.isPresent()) {
            deviceRepository.delete(prosumerOptional.get());
            LOGGER.debug("Device with id {} was deleted in db", id);
        }
    }

    public void update(DeviceDTO deviceDTO) {
        Device device = DeviceDTOBuilder.toEntityWithId(deviceDTO);
        device = deviceRepository.save(device);
        LOGGER.debug("Device with id {} was updated in db", device.getId());
    }
}
