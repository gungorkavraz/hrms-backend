package Training.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Training.HRMS.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate findByNationalId(String nationalId);
}
