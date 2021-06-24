package Training.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Training.HRMS.business.abstracts.JobAdvertisementService;
import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.SuccessDataResult;
import Training.HRMS.core.utilities.results.SuccessResult;
import Training.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import Training.HRMS.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public SuccessResult add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Kaydınız başarıyla gerçekleşti.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
				"Veriler başarılı bir şekilde getirldi");
	}
}
