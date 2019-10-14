package pe.edu.upn.demo3.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pe.edu.upn.demo3.model.entity.Medico;

@Entity
@Table(name="Especial")
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_especial")
	private Integer id_especialidad;
	
	@Column(name="nom_especial",length = 50,nullable = false)
	private String nombre_especialidad;
	
	//************************RELACIONES
	@OneToMany(mappedBy = "especialidad",fetch = FetchType.LAZY)
	private List<Medico> medicos;

	public Especialidad() {
		medicos=new ArrayList<>();
	}
	//------------------
		public void addMedico(Medico medico) {
			medico.setEspecialidad(this);
			this.medicos.add(medico);
		}
		//------------------
	
	//***********GETTERS AND SETTERS
	public Integer getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(Integer id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	public String getNombre_especialidad() {
		return nombre_especialidad;
	}

	public void setNombre_especialidad(String nombre_especialidad) {
		this.nombre_especialidad = nombre_especialidad;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	
	//***********GETTERS AND SETTERS
	
	
}
