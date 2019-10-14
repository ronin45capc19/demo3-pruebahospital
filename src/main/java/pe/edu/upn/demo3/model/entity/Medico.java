package pe.edu.upn.demo3.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pe.edu.upn.demo3.model.entity.Consultorio;
import pe.edu.upn.demo3.model.entity.Paciente;

@Entity
@Table(name="Medicos")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_medico")
	private Integer id_medico;
	
	@Column(name="nom_medico", length=60)
	private String nombremedico;
	
	@Column(name="direc_medico",length=50)
	private String direccion_medico;
	
	@Column(name="tel_medico")
	private Integer telefono_medico;
	
	//************************RELACIONES
	@OneToMany(mappedBy = "medico",fetch = FetchType.LAZY)
	private List<Paciente> pacientes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_especial")
	private Especialidad especialidad;
	
	@ManyToMany
	@JoinTable(name="medico_consultorio",
			joinColumns = @JoinColumn(columnDefinition = "id_medico"),
			inverseJoinColumns = @JoinColumn(columnDefinition = "id_consultorio"))
	private List<Consultorio> consultorios;
	
	public Medico() {
		pacientes=new ArrayList<>();
		consultorios= new ArrayList<>();
	}
	//-----------------
		public void addPaciente(Paciente paciente) {
			paciente.setMedico(this);
			this.pacientes.add(paciente);
		}
		public void addConsultorio(Consultorio consultorio) {
			consultorios.add(consultorio);
		}
		//-----------------
	
	//***********GETTERS AND SETTERS
	public Integer getId_medico() {
		return id_medico;
	}

	public void setId_medico(Integer id_medico) {
		this.id_medico = id_medico;
	}

	public String getNombremedico() {
		return nombremedico;
	}

	public void setNombremedico(String nombremedico) {
		this.nombremedico = nombremedico;
	}

	public String getDireccion_medico() {
		return direccion_medico;
	}

	public void setDireccion_medico(String direccion_medico) {
		this.direccion_medico = direccion_medico;
	}

	public Integer getTelefono_medico() {
		return telefono_medico;
	}

	public void setTelefono_medico(Integer telefono_medico) {
		this.telefono_medico = telefono_medico;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public List<Consultorio> getConsultorios() {
		return consultorios;
	}

	public void setConsultorios(List<Consultorio> consultorios) {
		this.consultorios = consultorios;
	}
	
	//***********GETTERS AND SETTERS
	
	
	
}
