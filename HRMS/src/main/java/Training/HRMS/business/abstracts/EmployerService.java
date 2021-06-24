package Training.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.entities.concretes.Employer;

@Service
public interface EmployerService {

	public Result add(Employer candidate);

	public DataResult<List<Employer>> listAll();
}
