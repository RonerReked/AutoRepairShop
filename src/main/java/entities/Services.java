package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "services", catalog = "autorepairshops")
public class Services implements java.io.Serializable {
	
	private Integer id;
	private Customers customers;
	private Mechanic mechanic;
	private Vehicles vehicles;
	@NotNull
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdate;
	@NotNull
	@NotEmpty
	@Size(min=5)
	private String details;

	public Services() {
	}

	public Services(Customers customers, Mechanic mechanic, Vehicles vehicles,
			Date createdate, String details) {
		this.customers = customers;
		this.mechanic = mechanic;
		this.vehicles = vehicles;
		this.createdate = createdate;
		this.details = details;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customersid", nullable = false)
	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mechanicid", nullable = false)
	public Mechanic getMechanic() {
		return this.mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehiclesid", nullable = false)
	public Vehicles getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(Vehicles vehicles) {
		this.vehicles = vehicles;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdate", nullable = false, length = 10)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "details", nullable = false, length = 65535)
	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
