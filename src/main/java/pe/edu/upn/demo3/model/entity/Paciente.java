package pe.edu.upn.demo3.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Pacientes")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_paciente")
	private Integer id_paciente;
	
	@Column(name="nom_paciente",length = 50,nullable = false)
	private String nombre_paciente;
	
	@Column(name="fec_nac_paciente")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento_paciente;
	
	@Column(name="dir_paciente",length = 50,nullable = false)
	private String direccion_paciente;
	
	@Column(name="fono_paciente")
	private Integer telefono_paciente;
	
	//************************RELACIONES
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_medico")
	private Medico medico;
	
	//***********GETTERS AND SETTERS
	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getNombre_paciente() {
		return nombre_paciente;
	}

	public void setNombre_paciente(String nombre_paciente) {
		this.nombre_paciente = nombre_paciente;
	}

	public Date getFechaNacimiento_paciente() {
		return fechaNacimiento_paciente;
	}

	public void setFechaNacimiento_paciente(Date fechaNacimiento_paciente) {
		this.fechaNacimiento_paciente = fechaNacimiento_paciente;
	}

	public String getDireccion_paciente() {
		return direccion_paciente;
	}

	public void setDireccion_paciente(String direccion_paciente) {
		this.direccion_paciente = direccion_paciente;
	}

	public Integer getTelefono_paciente() {
		return telefono_paciente;
	}

	public void setTelefono_paciente(Integer telefono_paciente) {
		this.telefono_paciente = telefono_paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	//***********GETTERS AND SETTERS
}
