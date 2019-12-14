package quantumcity.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quantumcity.persistance.entities.Pollution;

@Repository
public interface PollutionRepository extends JpaRepository<Pollution, Long> {

}
