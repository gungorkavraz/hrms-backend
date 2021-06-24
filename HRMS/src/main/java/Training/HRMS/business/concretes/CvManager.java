package Training.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Training.HRMS.business.abstracts.CvService;
import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.core.utilities.results.SuccessDataResult;
import Training.HRMS.core.utilities.results.SuccessResult;
import Training.HRMS.dataAccess.abstracts.CvDao;
import Training.HRMS.entities.concretes.Cv;
import Training.HRMS.entities.dtos.CvWithSkillsAndLanguagesDto;

@Service
public class CvManager implements CvService {

	CvDao cvDao;

	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Kayıt gerçekleşti");
	}

	@Override
	public DataResult<Cv> list(int id) {
		return new SuccessDataResult(this.cvDao.findById(id), "Veriler geldi");
	}

	@Override
	public List<CvWithSkillsAndLanguagesDto> getCv() {
		return this.cvDao.getCv();
	}

}
