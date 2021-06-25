package Training.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.entities.concretes.Candidate;
import Training.HRMS.entities.concretes.Cv;

@Service
public interface CandidateService {

	public Result add(Candidate candidate);

	public DataResult<List<Candidate>> listAll();

	public DataResult<Candidate> listById(int id);

}
