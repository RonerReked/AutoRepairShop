package entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mechanic", catalog = "autorepairshops")
public class Mechanic implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set<Services> serviceses = new HashSet<Services>(0);

	public Mechanic() {
	}

	public Mechanic(String name) {
		this.name = name;
	}

	public Mechanic(String name, Set<Services> serviceses) {
		this.name = name;
		this.serviceses = serviceses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mechanic")
	public Set<Services> getServiceses() {
		return this.serviceses;
	}

	public void setServiceses(Set<Services> serviceses) {
		this.serviceses = serviceses;
	}

}
