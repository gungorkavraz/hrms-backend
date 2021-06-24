package Training.HRMS.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.entities.concretes.Cv;
import Training.HRMS.entities.dtos.CvWithSkillsAndLanguagesDto;

@Service
public interface CvService {

	public Result add(Cv cv);

	public DataResult<Cv> list(int id);

	public List<CvWithSkillsAndLanguagesDto> getCv();

}
