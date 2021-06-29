package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.List;

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
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpfinal.validators.Dominio;

@Entity
@Table (name = "EMPLOYEES")
@Component("employeeObj")
public class Employee {

	@Id
	//@NotNull(message="El campo employeeNumber no debe estar vacio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeNumber;
	
	@NotNull(message = "El campo lastName no puede estar vacio")
	@Size(max = 50, message = "El maximo es de 50 caracteres")
	@Column(name = "lastName")
	private String lastName;
	
	@NotNull(message = "El campo firstName no puede estar vacio")
	@Size(max = 50, message = "El maximo es de 50 caracteres")
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull(message = "El campo extension no puede estar vacio")
	@Size(max = 10, message = "El maximo es de 10 caracteres")
	@Column(name = "extension")
	private String extension;
	
	@Email(message = "El email no se corresponde con un formato correcto")
	@Dominio
	@NotNull(message = "El campo email no puede estar vacio")
	@Size(max = 100, message = "El maximo es de 100 caracteres")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "El campo jobTitle no puede estar vacio")
	@Size(max = 50, message = "El maximo es de 50 caracteres")
	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Valid
	@Autowired
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "officeCode")
    private Office office;
	
	@Autowired
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "reportsTo")
    private Employee employee;
		
	@OneToMany( mappedBy = "employee" )
	private List<Customer> customers = new ArrayList<Customer>();
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", jobTitle=" + jobTitle + ", office=" + office
				+ ", employee=" + employee + ", customers=" + customers + "]";
	}

	

}