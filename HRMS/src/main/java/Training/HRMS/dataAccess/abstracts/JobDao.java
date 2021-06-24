package Training.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Training.HRMS.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer> {
	Job findByJobTitle(String jobTitle);

}
