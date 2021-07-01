package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "USERS")
@Component
public class User {
	@Id
	@Column(name="user_Id")
	@NotNull(message = "Debes introducir id")
	private Long id;
	
	@Column(name = "user_Name")
	@NotBlank(message = "El campo usuario no puede estar vacio")
	private String usuario;
	
	@Column(name = "user_Password")
	@NotBlank(message = "El campo password no puede estar vacio")
	private String password;
	
	@Column(name = "user_Type")
	@NotBlank(message = "El campo tipo no puede estar vacio")
	private String tipo;
	
	@Autowired
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Employee employee;
//CONSTRUCTORES
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", usuario=" + usuario + ", password=" + password + ", tipo=" + tipo + ", employee="
				+ employee + "]";
	}
	
	

}
