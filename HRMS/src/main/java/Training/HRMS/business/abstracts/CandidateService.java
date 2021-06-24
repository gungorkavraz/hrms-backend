package Training.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.entities.concretes.Candidate;

@Service
public interface CandidateService {

	public Result add(Candidate candidate);

	public DataResult<List<Candidate>> listAll();

}
