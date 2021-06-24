package Training.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cvs")
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "school")
	private String school;

	@Column(name = "entry_date")
	private String entryDate;

	@Column(name = "graduation_date")
	private String graduationDate;

	@Column(name = "github_account")
	private String githubAccount;

	@Column(name = "linkedin_account")
	private String linkedinAccount;

	@Column(name = "cover_letter")
	private String coverLetter;

	@JsonIgnore()
	// @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
	@OneToMany(targetEntity = Skill.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id", referencedColumnName = "id")
	private List<Skill> skills;

	@JsonIgnore()
	// @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
	@OneToMany(targetEntity = Language.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id", referencedColumnName = "id")
	private List<Language> langugages;

}
