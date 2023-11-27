package measurements.controllers;

import measurements.entities.Measurement;
import measurements.entities.Treshhold;
import measurements.services.TreshholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/treshhold")
public class TreshholdController {

    @Autowired
    TreshholdService treshholdService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody
    public List<Treshhold> getAll() {
        return treshholdService.getAll();
    }


    @GetMapping(value = "/{device}")
    public ResponseEntity<Treshhold> getTreshholdByDevice(@PathVariable("device") Integer device) {
        //System.out.println(device);
        Treshhold dtos = treshholdService.findThreshholdByIdDevice(device);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTreshhold(@PathVariable("id") Integer idTreshhold) {
        treshholdService.deleteTreshhold(idTreshhold);
        return new ResponseEntity<>("Success delete", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateTreshhold(@Valid @RequestBody Treshhold treshholdDTO) {
        treshholdService.update(treshholdDTO);
        return new ResponseEntity<>("Success Update", HttpStatus.OK);
    }
}
