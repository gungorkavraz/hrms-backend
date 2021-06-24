package Training.HRMS.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Training.HRMS.business.abstracts.ValidationService;
import Training.HRMS.dataAccess.abstracts.CandidateDao;
import Training.HRMS.dataAccess.abstracts.EmployerDao;
import Training.HRMS.dataAccess.abstracts.JobDao;
import Training.HRMS.dataAccess.abstracts.UserDao;
import Training.HRMS.entities.concretes.Candidate;
import Training.HRMS.entities.concretes.Employer;

@Service
public class ValidationManager implements ValidationService {

	EmployerDao employerDao;
	CandidateDao candidateDao;
	JobDao jobDao;
	UserDao userDao;

	@Autowired
	public ValidationManager(EmployerDao employerDao, CandidateDao candidateDao, JobDao jobDao, UserDao userDao) {
		this.employerDao = employerDao;
		this.candidateDao = candidateDao;
		this.jobDao = jobDao;
		this.userDao = userDao;
	}

	@Override
	public boolean candidateValidation(Candidate candidate) {
		if (candidate.getFirstName() == "" || candidate.getLastName() == "" || candidate.getNationalId() == ""
				|| candidate.getDateOfBirth() == "" || candidate.getEmail() == "" || candidate.getPassword() == "") {
			return false;
		}
		return true;
	}

	@Override
	public boolean employerValidation(Employer employer) {
		if (employer.getCompanyName() == "" || employer.getCompanyDomain() == "" || employer.getCompanyWebSite() == ""
				|| employer.getEmail() == "" || employer.getPassword() == "") {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkIfDomainEqual(Employer employer) {
		if (employer.getCompanyWebSite().contains(employer.getCompanyDomain())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkIfEmailExist(String email) {
		if (this.userDao.findByEmail(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkIfEmailCorrect(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);

		if (matcher.matches())
			return true;

		return false;
	}

	@Override
	public boolean checkIfPasswordsEqual(String password, String passwordVerification) {
		if (password.equals(passwordVerification))
			return true;
		return false;
	}

	@Override
	public boolean checkIfNationalIdExist(Candidate candidate) {
		if (this.candidateDao.findByNationalId(candidate.getNationalId()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkIfJobTitleExist(String jobTitle) {
		if (this.jobDao.findByJobTitle(jobTitle) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean sendEmail(String email) {
		System.out.println(email + " adrsine doğrulama kodu gönderildi");
		return true;
	}

}
