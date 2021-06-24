package Training.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Training.HRMS.business.abstracts.JobService;
import Training.HRMS.core.utilities.results.DataResult;
import Training.HRMS.core.utilities.results.Result;
import Training.HRMS.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobTitles")
public class JobsController {

	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping("/listalljobtitles")
	public DataResult<List<Job>> getAllJobTitles() {
		return this.jobService.getAllJobTitles();
	}

	@PostMapping("/addjobtitle")
	public Result addJobTitle(@RequestBody Job job) {
		return this.jobService.addJobTitle(job);
	}

}
