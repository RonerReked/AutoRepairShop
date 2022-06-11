package entities;

// Generated Mar 7, 2015 6:22:56 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "customers", catalog = "autorepairshops")
public class Customers implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String name;
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String address;
	@NotNull
	@NotEmpty
	@Size(min = 5)
	private String contactdetails;
	@NotNull
	@NotEmpty
	@Size(max = 20)
	private String gender;
	@NotNull
	@Min(20)
	@Max(100)
	private int age;
	private Set<Services> serviceses = new HashSet<Services>(0);
	private Set<Vehicles> vehicleses = new HashSet<Vehicles>(0);

	public Customers() {
	}

	public Customers(String name, String address, String contactdetails,
			String gender, int age) {
		this.name = name;
		this.address = address;
		this.contactdetails = contactdetails;
		this.gender = gender;
		this.age = age;
	}

	public Customers(String name, String address, String contactdetails,
			String gender, int age, Set<Services> serviceses,
			Set<Vehicles> vehicleses) {
		this.name = name;
		this.address = address;
		this.contactdetails = contactdetails;
		this.gender = gender;
		this.age = age;
		this.serviceses = serviceses;
		this.vehicleses = vehicleses;
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

	@Column(name = "address", nullable = false, length = 250)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "contactdetails", nullable = false, length = 65535)
	public String getContactdetails() {
		return this.contactdetails;
	}

	public void setContactdetails(String contactdetails) {
		this.contactdetails = contactdetails;
	}

	@Column(name = "gender", nullable = false, length = 20)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
	public Set<Services> getServiceses() {
		return this.serviceses;
	}

	public void setServiceses(Set<Services> serviceses) {
		this.serviceses = serviceses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "vehicles_customer", catalog = "autorepairshops", joinColumns = { @JoinColumn(name = "customersid", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "vehiclesid", nullable = false, updatable = false) })
	public Set<Vehicles> getVehicleses() {
		return this.vehicleses;
	}

	public void setVehicleses(Set<Vehicles> vehicleses) {
		this.vehicleses = vehicleses;
	}

}
