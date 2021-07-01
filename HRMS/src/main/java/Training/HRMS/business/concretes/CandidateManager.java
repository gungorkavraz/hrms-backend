package Training.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Training.HRMS.business.abstracts.CandidateService;
import Training.HRMS.business.abstracts.ValidationService;
import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.ErrorResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.core.utilities.results.SuccessDataResult;
import Training.HRMS.core.utilities.results.SuccessResult;
import Training.HRMS.dataAccess.abstracts.CandidateDao;
import Training.HRMS.entities.concretes.Candidate;
import Training.HRMS.entities.concretes.Cv;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private ValidationService validationService;

	public CandidateManager(CandidateDao candidateDao, ValidationService validationService) {
		this.candidateDao = candidateDao;
		this.validationService = validationService;
	}

	@Override
	public Result add(Candidate candidate) {
		if (!this.validationService.candidateValidation(candidate)) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		}
		if (!this.validationService.checkIfEmailCorrect(candidate.getEmail())) {
			return new ErrorResult("Lütfen mailinizi kontrol ediniz.");
		}
		if (this.validationService.checkIfEmailExist(candidate.getEmail())) {
			return new ErrorResult("Email adresi zaten kayıtlı");
		}
		if (this.validationService.checkIfNationalIdExist(candidate)) {
			return new ErrorResult("TcNo zaten kayıtlı");
		}
		if (this.validationService.checkIfPasswordsEqual(candidate.getPassword(),
				candidate.getPasswordVerification())) {
			return new ErrorResult("Şifreler aynı değil.");
		}
		if (!this.validationService.sendEmail(candidate.getEmail())) {
			return new ErrorResult("Doğrulama kodu gönderilemedi");
		}
		if (!this.validationService.sendEmail(candidate.getEmail())) {
			return new ErrorResult("Doğrulama kodu gönderilemedi");
		}
		this.candidateDao.save(candidate);		
		return new SuccessResult("Kaydınız başarıyla gerçekleşti");
	}

	@Override
	public DataResult<List<Candidate>> listAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Başarıyla Listelendi");
	}

	@Override
	public DataResult<Candidate> listById(int id) {
		return new SuccessDataResult(this.candidateDao.findById(id), "Veriler geldi");
	}

}
