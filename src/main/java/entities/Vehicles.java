package entities;

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

@Entity
@Table(name = "vehicles", catalog = "autorepairshops")
public class Vehicles implements java.io.Serializable {

	private Integer id;
	@NotEmpty
	@NotNull
	@Size(min = 3, max = 50)
	private String registrationnumber;
	@NotEmpty
	@NotNull
	@Size(min = 3, max = 50)
	private String make;
	@NotEmpty
	@NotNull
	@Size(min = 3, max = 50)
	private String model;
	@NotNull
	@Min(1)
	@Max(2016)
	private int modelyear;
	@NotNull
	@Min(1)	
	private long funds;
	@NotNull
	@Min(1)	
	private double miles;
	private Set<Services> serviceses = new HashSet<Services>(0);
	private Set<Customers> customerses = new HashSet<Customers>(0);

	public Vehicles() {
	}

	public Vehicles(String registrationnumber, String make, String model,
			int modelyear, long funds, double miles) {
		this.registrationnumber = registrationnumber;
		this.make = make;
		this.model = model;
		this.modelyear = modelyear;
		this.funds = funds;
		this.miles = miles;
	}

	public Vehicles(String registrationnumber, String make, String model,
			int modelyear, long funds, double miles, Set<Services> serviceses,
			Set<Customers> customerses) {
		this.registrationnumber = registrationnumber;
		this.make = make;
		this.model = model;
		this.modelyear = modelyear;
		this.funds = funds;
		this.miles = miles;
		this.serviceses = serviceses;
		this.customerses = customerses;
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

	@Column(name = "registrationnumber", nullable = false, length = 250)
	public String getRegistrationnumber() {
		return this.registrationnumber;
	}

	public void setRegistrationnumber(String registrationnumber) {
		this.registrationnumber = registrationnumber;
	}

	@Column(name = "make", nullable = false, length = 250)
	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "model", nullable = false, length = 250)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "modelyear", nullable = false)
	public int getModelyear() {
		return this.modelyear;
	}

	public void setModelyear(int modelyear) {
		this.modelyear = modelyear;
	}

	@Column(name = "funds", nullable = false, precision = 10, scale = 0)
	public long getFunds() {
		return this.funds;
	}

	public void setFunds(long funds) {
		this.funds = funds;
	}

	@Column(name = "miles", nullable = false, precision = 22, scale = 0)
	public double getMiles() {
		return this.miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicles")
	public Set<Services> getServiceses() {
		return this.serviceses;
	}

	public void setServiceses(Set<Services> serviceses) {
		this.serviceses = serviceses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "vehicles_customer", catalog = "autorepairshops", joinColumns = { @JoinColumn(name = "vehiclesid", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "customersid", nullable = false, updatable = false) })
	public Set<Customers> getCustomerses() {
		return this.customerses;
	}

	public void setCustomerses(Set<Customers> customerses) {
		this.customerses = customerses;
	}

}
