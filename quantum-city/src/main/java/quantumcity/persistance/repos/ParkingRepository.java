package quantumcity.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quantumcity.persistance.entities.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking,Long>{

}
