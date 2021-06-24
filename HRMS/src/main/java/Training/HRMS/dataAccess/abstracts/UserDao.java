package Training.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Training.HRMS.entities.concretes.Candidate;
import Training.HRMS.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	Candidate findByEmail(String email);
}
