package Training.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.SuccessResult;
import Training.HRMS.entities.concretes.JobAdvertisement;

@Service
public interface JobAdvertisementService {
	public SuccessResult add(JobAdvertisement jobAdvertisement);

	public DataResult<List<JobAdvertisement>> getAll();
}
