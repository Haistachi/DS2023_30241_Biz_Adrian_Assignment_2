package measurements.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import measurements.entities.Measurement;
import measurements.services.MeasurementService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody
    public List<Measurement> getAll() {
        return measurementService.getAll();
    }

    @GetMapping(value = "/{device}/{date}")
    public ResponseEntity<List<Measurement>> getMeasurementByDeviceAndDate(@PathVariable("device") Integer device,
                                                            @PathVariable("date") LocalDateTime date) {
        System.out.println(device);
        System.out.println(date.toString());
        List<Measurement> dtos = measurementService.findMeasurementsByIdDeviceAndTimest(device, date);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{device}")
    public ResponseEntity<List<Measurement>> getMeasurementByDevice(@PathVariable("device") Integer device) {
        //System.out.println(device);
        List<Measurement> dtos = measurementService.findMeasurementsByIdDevice(device);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteMeasurement(@PathVariable("id") Integer idMeasurement) {
        measurementService.deleteMeasurement(idMeasurement);
        return new ResponseEntity<>("Success delete", HttpStatus.OK);
    }
}
