package Training.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Training.HRMS.business.abstracts.JobService;
import Training.HRMS.business.abstracts.ValidationService;
import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.core.utilities.results.SuccessDataResult;
import Training.HRMS.core.utilities.results.SuccessResult;
import Training.HRMS.dataAccess.abstracts.JobDao;
import Training.HRMS.entities.concretes.Job;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	ValidationService validationService;

	@Autowired
	public JobManager(JobDao jobDao, ValidationService validationService) {
		super();
		this.jobDao = jobDao;
		this.validationService = validationService;
	}

	@Override
	public DataResult<List<Job>> getAllJobTitles() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Listelendi");

	}

	@Override
	public Result addJobTitle(@RequestBody Job job) {
		if (this.validationService.checkIfJobTitleExist(job.getJobTitle()))
			return new Result("İş pozisyonu zaten var.");
		this.jobDao.save(job);
		return new SuccessResult("Kayıt eklendi");
	}

}
