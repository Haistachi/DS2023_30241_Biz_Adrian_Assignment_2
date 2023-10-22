package assignment1.EnergyConsum.servicies;

import assignment1.EnergyConsum.EnergyConsumApplication;
import assignment1.EnergyConsum.dtos.ActiveDTO;
import assignment1.EnergyConsum.entities.Consum;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@AllArgsConstructor
@Service
public class ReciveService {

    private final ActiveServices activeServices;
    @RabbitListener(queues = EnergyConsumApplication.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final Consum customMessage) {
        System.out.println("Received message and deserialized to 'CustomMessage': " + customMessage.toString());
        ActiveDTO activeDTO= new ActiveDTO();

        Date date = new Date(Long.parseLong(customMessage.getTime()));
        ZoneOffset zo= ZoneOffset.ofHours(0);
        LocalDateTime localDateTime= LocalDateTime.ofEpochSecond(Long.parseLong(customMessage.getTime()), 0, zo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);
        activeDTO.setTimestamp(formattedDate);
        activeDTO.setDevice(customMessage.getId());
        activeDTO.setConsumption(customMessage.getValue());

        System.out.println("Insert Active:");
        System.out.println(Timestamp.valueOf(activeDTO.getTimestamp()).toString());
        System.out.println("Timestamp: " + activeDTO.getTimestamp().toString());
        System.out.println("Device: " + activeDTO.getDevice().toString());
        System.out.println("Consumption: " + String.valueOf(activeDTO.getConsumption()));

        activeServices.insert(activeDTO);
    }
}
