package measurements;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import measurements.entities.Treshhold;
import measurements.services.TreshholdService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import measurements.entities.Measurement;
import measurements.services.MeasurementService;
import measurements.websocket.WebSocketController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static double prevVal=0;
    public static LocalDateTime preTime = LocalDateTime.of(2023, 01,17, 0,0,0);;
    public static LocalDateTime postTime = LocalDateTime.of(2023, 01,18, 1,0,0);;
    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    WebSocketController webSocketTextController;

    @Autowired
    MeasurementService measurementService;
    @Autowired
    TreshholdService treshholdService;
    @RabbitListener(queues = "demoqueue")
    public void run(String msg1) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Measurement prototipe = objectMapper.readValue(msg1, Measurement.class);
        Measurement m = new Measurement();
        m.setIdDevice(prototipe.getIdDevice());
        m.setVal(prototipe.getVal());
        m.setTimest(prototipe.getTimest());
        System.out.println(m.toString());

        measurementService.insert(m);

        // ti o lista cu rezultatul de la getAllMeasurementsByDeviceId
        // filtrezi pe ultima ora
        //parcurgi lista faci suma
        Treshhold t= treshholdService.findThreshholdByIdDevice(m.getIdDevice());
        List<Measurement> lMeasurement=  measurementService.findMeasurementsByIdDevice(m.getIdDevice());
        List<Measurement> lTodayMeasurements = lMeasurement.stream()
                .filter( l -> l.getTimest().isAfter(preTime) && l.getTimest().isBefore(postTime))
                .collect(Collectors.toList());
        double sum= 0;
        for(int i=0; i<lTodayMeasurements.size();i++)
        {
            sum+=lTodayMeasurements.get(i).getVal()-prevVal;
            prevVal=lTodayMeasurements.get(i).getVal();
        }
        t.setCurrent(sum);
        treshholdService.update(t);
        if(sum>t.getTreshhold())
        {
            System.out.println("nasol bre");
            webSocketTextController.sendMessage("S-a depasit bugetu pentru device-ul cu id-ul "
                    + m.getIdDevice() + ". La ora: " + m.getTimest().toString());
        }
    }
}
