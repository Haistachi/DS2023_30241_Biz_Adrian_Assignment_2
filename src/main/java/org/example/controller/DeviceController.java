package assignment1.EnergyConsum.controller;

import assignment1.EnergyConsum.dtos.DeviceDTO;
import assignment1.EnergyConsum.servicies.DeviceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/device")
public class DeviceController {
    private final DeviceServices deviceServices;

    @GetMapping()
    public ResponseEntity<List<DeviceDTO>> getDevices() {
        List<DeviceDTO> dtos = deviceServices.findDevices();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @Autowired
    public DeviceController(DeviceServices deviceServices) {
        this.deviceServices = deviceServices;
    }

    @PostMapping()
    public ResponseEntity<UUID> insertDevice(@Valid @RequestBody DeviceDTO deviceDTO) {
        UUID deviceId = deviceServices.insert(deviceDTO);
        return new ResponseEntity<>(deviceId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DeviceDTO> getDevice(@PathVariable("id") UUID deviceId) {
        DeviceDTO dto = deviceServices.findDeviceById(deviceId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") UUID deviceId) {
        deviceServices.deleteDevice(deviceId);
        return new ResponseEntity<>("Success delete", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updatePerson(@Valid @RequestBody DeviceDTO device) {
        deviceServices.update(device);
        return new ResponseEntity<>("Success Update", HttpStatus.OK);
    }

    @GetMapping(value = "/{person}")
    public ResponseEntity<List<DeviceDTO>> getDeviceByOwner(@PathVariable("person") String name) {
        List<DeviceDTO> dtos = deviceServices.findDeviceByOwner(name);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}