package assignment1.EnergyConsum.repositories;

import assignment1.EnergyConsum.entities.Active;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public interface ActiveRepository extends JpaRepository<Active, UUID> {
    List<Active> findByDeviceAndTimestampBetween(UUID idDevice, Timestamp timestampStart, Timestamp timestampFinish);
    List<Active> findByConsumption(int consumption);
    List<Active> findByDevice(UUID id);

    List<Active> findActiveByTimestampAndDevice(Timestamp timestamp, UUID idDevice);
}
