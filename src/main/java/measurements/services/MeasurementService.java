package measurements.services;

import measurements.entities.Measurement;
import measurements.repositories.IMeasurementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementService {

    @Autowired
    IMeasurementRepository iMeasurementRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementService.class);

    public Measurement saveMeasurement(Measurement measurement){
        return iMeasurementRepository.save(measurement);
    }

    public List<Measurement> getAll(){
        return iMeasurementRepository.findAll();
    }
    public List<Measurement> findMeasurementsForDevice(Integer id){
        return iMeasurementRepository.findByIdDevice(id);
    }

    public List<Measurement> findMeasurementsById(Integer id){
        return iMeasurementRepository.findByIdMeasurement(id);
    }

    public List<Measurement> findMeasurementsByIdDeviceAndTimest(Integer id, LocalDateTime time){
        return iMeasurementRepository.findMeasurementByIdDeviceAndTimest(id, time);
    }


}
