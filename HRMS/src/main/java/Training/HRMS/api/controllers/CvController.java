package Training.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Training.HRMS.business.concretes.CvManager;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.entities.concretes.Cv;
import Training.HRMS.entities.dtos.CvWithSkillsAndLanguagesDto;

@RestController
@RequestMapping("/api/cv")
public class CvController {

	CvManager cvManager;

	@Autowired
	public CvController(CvManager cvManager) {
		super();
		this.cvManager = cvManager;
	}

	@PostMapping("/add")
	private Result add(@RequestBody Cv cv) {
		return this.cvManager.add(cv);
	}

	@GetMapping("/list")
	private Result list(int id) {
		return this.cvManager.list(id);
	}

	@GetMapping("/listCv")
	private List<CvWithSkillsAndLanguagesDto> list() {
		return this.cvManager.getCv();
	}

}
