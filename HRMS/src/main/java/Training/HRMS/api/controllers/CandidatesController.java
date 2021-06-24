package Training.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Training.HRMS.business.abstracts.CandidateService;
import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	private CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@PostMapping("/add")
	private Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}

	@GetMapping("/list")
	private DataResult<List<Candidate>> list() {
		return this.candidateService.listAll();
	}

}
