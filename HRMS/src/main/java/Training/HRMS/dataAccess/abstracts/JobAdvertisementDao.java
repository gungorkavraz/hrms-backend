package Training.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Training.HRMS.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

}
