package Training.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvWithSkillsAndLanguagesDto {

	private int id;
	private String school;
	private String name;
	private int level;
}
