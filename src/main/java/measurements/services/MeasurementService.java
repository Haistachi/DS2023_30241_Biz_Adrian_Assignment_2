package measurements.services;

import measurements.entities.Measurement;
import measurements.repositories.IMeasurementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MeasurementService {

    @Autowired
    IMeasurementRepository iMeasurementRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementService.class);

    public Measurement saveMeasurement(Measurement measurement){
        return iMeasurementRepository.save(measurement);
    }

    public Integer insert(Measurement measurementDTO) {
        Measurement measurement = new Measurement
                (measurementDTO.getIdDevice(), measurementDTO.getTimest(), measurementDTO.getVal());
        measurement = iMeasurementRepository.save(measurement);
        LOGGER.debug("Measurement with id {} was inserted in db", measurement.getIdMeasurement());
        return measurement.getIdMeasurement();
    }

    public List<Measurement> getAll(){
        return iMeasurementRepository.findAll();
    }
    public List<Measurement> findMeasurementsByIdDevice(Integer id){
        return iMeasurementRepository.findByIdDevice(id);
    }

    public List<Measurement> findMeasurementsById(Integer id){
        return iMeasurementRepository.findByIdMeasurement(id);
    }

    public List<Measurement> findMeasurementsByIdDeviceAndTimest(Integer id, LocalDateTime time){
        return iMeasurementRepository.findMeasurementByIdDeviceAndTimest(id, time);
    }

    public void deleteMeasurement(Integer id) {
        Optional<Measurement> measurementOptional = iMeasurementRepository.findById(id);
        if (measurementOptional.isPresent()) {
            iMeasurementRepository.delete(measurementOptional.get());
            LOGGER.debug("Measurement with id {} was deleted in db", id);
        }
    }

}
