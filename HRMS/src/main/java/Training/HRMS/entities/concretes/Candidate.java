package Training.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "national_id")
	private String nationalId;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@OneToMany(targetEntity = Cv.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
	private List<Skill> skills;

	@Transient
	private String passwordVerification;
}
