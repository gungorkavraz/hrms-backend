package Training.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "level")
	private int level;

	/// Web üzerinden listeleme yapılırken loopa düşmesin diye 
	/// skill(Kullanılan class hangisi olduğu farketmez) listesi içindeki cv kısmını @JsonIgnore() ile ignoreluyoruz
	/// Eğer bunu yapmazsak cv listelerken cv üzerinden skill(Kullanılan class hangi class olduğu farketmez) classını çağırıyor
	/// Skill class ı tekrar buraya geldiğinde cv yi çağırıyor ve böyle bir	 kısır-döngü oluyor.
	@JsonIgnore()
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

}
