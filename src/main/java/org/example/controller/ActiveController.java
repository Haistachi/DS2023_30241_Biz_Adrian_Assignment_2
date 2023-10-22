package assignment1.EnergyConsum.controller;

import assignment1.EnergyConsum.dtos.ActiveDTO;
import assignment1.EnergyConsum.servicies.ActiveServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/active")
public class ActiveController {
    private final ActiveServices activeServices;

    @Autowired
    public ActiveController(ActiveServices activeServices) {
        this.activeServices = activeServices;
    }

    @PostMapping()
    public ResponseEntity<UUID> insertActive(@Valid @RequestBody ActiveDTO activeDTO) {
        UUID personID = activeServices.insert(activeDTO);
        return new ResponseEntity<>(personID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ActiveDTO> getActive(@PathVariable("id") UUID activeId) {
        ActiveDTO dto = activeServices.findActiveById(activeId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ActiveDTO>> getActives() {
        List<ActiveDTO> dtos = activeServices.findActive();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteActive(@PathVariable("id") UUID activeId) {
        activeServices.deleteActive(activeId);
        return new ResponseEntity<>("Success delete", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateActive(@Valid @RequestBody ActiveDTO activeDTO) {
        activeServices.updateActive(activeDTO);
        return new ResponseEntity<>("Success Update", HttpStatus.OK);
    }

    @GetMapping(value = "/{device}/{date}")
    public ResponseEntity<List<ActiveDTO>> getDeviceByOwner(@PathVariable("device") UUID device,
                                                            @PathVariable("date") String date) {
        System.out.println(device);
        System.out.println(date);
        List<ActiveDTO> dtos = activeServices.findActiveByDeviceAndDate(device, date);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}