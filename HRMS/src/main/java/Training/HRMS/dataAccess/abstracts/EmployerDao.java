package Training.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Training.HRMS.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
