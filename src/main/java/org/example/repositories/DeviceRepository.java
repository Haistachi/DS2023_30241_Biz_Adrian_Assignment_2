package org.example.repositories;


import org.example.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    List<Device> findByDescription(String name);
    List<Device> findByAddress(String address);
    List<Device> findByPerson(Integer person);
    List<Device> findByConsumption(int consumption);


}
