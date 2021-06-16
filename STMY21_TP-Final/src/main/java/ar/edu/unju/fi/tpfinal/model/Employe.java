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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpfinal.validators.Dominio;

@Entity
@Table (name = "EMPLOYEES")
@Component("employeObj")
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeNumber;
	
	@NotNull(message = "Este campo lastName no puede estar vacio")
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "lastName")
	private String lastName;
	
	@NotNull(message = "Este campo firstName no puede estar vacio")
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "firstName")
	private String firstName;
	
	@NotNull(message = "Este campo extension no puede estar vacio")
	@Size(max = 10, message = "Como maximo debe tener 10 caracteres")
	@Column (name = "extension")
	private String extension;
	
	@Email(message = "El email no se corresponde con un formato correcto")
	@Dominio
	@Size(max = 100, message = "Como maximo debe tener 100 caracteres")
	@NotNull(message = "Este campo email no puede estar vacio")
	@Column (name = "email")
	private String email;
	
	@OneToOne
    @JoinColumn(name = "officeCode")
    private Office office;
	
	@OneToMany(mappedBy = "reportsTo")
    private List<Employe> employees = new ArrayList<Employe>();
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "reportsTo")
    private Employe employe;
	
	@NotNull(message = "Este campo jobTitle no puede estar null")
	@Size(min = 3, message = "El jobTitle no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "jobTitle")
	private String jobTitle;
	
	@OneToMany(mappedBy = "employe")
    private List<Customer> customers;
	
	public Employe() {
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

	public List<Employe> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employe> employees) {
		this.employees = employees;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
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
		return "Employe [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", employees=" + employees + ", employe=" + employe
				+ ", jobTitle=" + jobTitle + ", customers=" + customers + "]";
	}
	
}



