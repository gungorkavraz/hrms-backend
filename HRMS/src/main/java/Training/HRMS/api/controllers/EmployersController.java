package Training.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Training.HRMS.business.abstracts.EmployerService;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	private EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}

	@PostMapping("/add")
	private Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}

	@GetMapping("/list")
	private Result list() {
		return this.employerService.listAll();
	}

}
