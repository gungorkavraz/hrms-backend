package Training.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.entities.concretes.Job;

@Service
public interface JobService {

	public DataResult<List<Job>> getAllJobTitles();

	public Result addJobTitle(Job job);
}
