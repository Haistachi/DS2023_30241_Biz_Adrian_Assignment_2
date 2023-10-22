package assignment1.EnergyConsum.repositories;

import assignment1.EnergyConsum.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {
    List<Device> findByDescription(String name);
    List<Device> findByAddress(String address);
    List<Device> findByPerson(UUID person);
    List<Device> findByConsumption(int consumption);


}
