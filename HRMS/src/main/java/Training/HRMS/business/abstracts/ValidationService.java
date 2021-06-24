package Training.HRMS.business.abstracts;

import org.springframework.stereotype.Service;

import Training.HRMS.entities.concretes.Candidate;
import Training.HRMS.entities.concretes.Employer;

@Service
public interface ValidationService {
	public boolean candidateValidation(Candidate candidate);

	public boolean checkIfNationalIdExist(Candidate candidate);

	public boolean employerValidation(Employer employer);

	public boolean checkIfDomainEqual(Employer employer);

	public boolean checkIfEmailCorrect(String email);

	public boolean checkIfEmailExist(String email);

	public boolean checkIfPasswordsEqual(String password, String passwordVerification);

	public boolean checkIfJobTitleExist(String jobTitle);

	public boolean sendEmail(String email);

}
