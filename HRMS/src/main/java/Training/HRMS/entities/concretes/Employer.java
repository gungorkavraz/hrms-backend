package Training.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
@Table(name = "employers")
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_web_site")
	private String companyWebSite;

	@Column(name = "company_domain")
	private String companyDomain;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
	// @OneToMany(targetEntity = JobAdvertisement.class, cascade = CascadeType.ALL)
	// @JoinColumn(name = "employer_id", referencedColumnName = "user_id")
	private List<JobAdvertisement> jobAdvertisements;

	@Transient
	private String passwordVerification;

}
