package measurements.controllers;

import measurements.entities.Treshhold;
import measurements.services.TreshholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
