package Training.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Training.HRMS.entities.concretes.Cv;
import Training.HRMS.entities.dtos.CvWithSkillsAndLanguagesDto;

public interface CvDao extends JpaRepository<Cv, Integer> {

	// @Query("Select new
	// Training.HRMS.entities.dtos.CvWithSkillsAndLanguagesDto(c.id,c.school,s.name,
	// s.level) From Cv c Inner Join c.skills s")
	@Query("Select new Training.HRMS.entities.dtos.CvWithSkillsAndLanguagesDto(ca.id,ca.firstName,ca.lastName,c.school,s.name,s.level)\r\n"
			+ "From Candidate ca Inner Join ca.cvs c \r\n" + "Inner Join c.skills s")
	List<CvWithSkillsAndLanguagesDto> getCv();
}
