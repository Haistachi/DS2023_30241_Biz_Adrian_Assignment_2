package org.example.repositories;


import org.example.entities.Active;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public interface ActiveRepository extends JpaRepository<Active, Integer> {
    List<Active> findByDeviceAndTimestampBetween(Integer idDevice, Timestamp timestampStart, Timestamp timestampFinish);
    List<Active> findByConsumption(int consumption);
    List<Active> findByDevice(Integer id);

    List<Active> findActiveByTimestampAndDevice(Timestamp timestamp, Integer idDevice);
}
