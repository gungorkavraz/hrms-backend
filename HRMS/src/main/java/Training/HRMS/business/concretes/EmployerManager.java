package Training.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Training.HRMS.business.abstracts.EmployerService;
import Training.HRMS.business.abstracts.ValidationService;
import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.ErrorResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.core.utilities.results.SuccessDataResult;
import Training.HRMS.core.utilities.results.SuccessResult;
import Training.HRMS.dataAccess.abstracts.EmployerDao;
import Training.HRMS.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	EmployerDao employerDao;
	ValidationService validationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ValidationService validationService) {
		this.employerDao = employerDao;
		this.validationService = validationService;
	}

	@Override
	public Result add(Employer employer) {
		if (!this.validationService.employerValidation(employer)) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		}
		if (!this.validationService.checkIfDomainEqual(employer)) {
			return new ErrorResult("Web sitesi şirket domaini ile aynı domaine sahip olmalıdır.");
		}
		if (!this.validationService.checkIfEmailCorrect(employer.getEmail())) {
			return new ErrorResult("Lütfen mailinizi kontrol ediniz.");
		}
		if (this.validationService.checkIfEmailExist(employer.getEmail())) {
			return new ErrorResult("Email adresi zaten kayıtlı");
		}
		if (!this.validationService.checkIfPasswordsEqual(employer.getPassword(),
				employer.getPasswordVerification())) {
			return new ErrorResult("Şifreler aynı değil.");
		}
		if (!this.validationService.sendEmail(employer.getEmail())) {
			return new ErrorResult("Doğrulama kodu gönderilemedi");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Kaydınız başarıyla gerçekleşti.");
	}

	@Override
	public DataResult<List<Employer>> listAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Başarıyla Listelendi");
	}

}
