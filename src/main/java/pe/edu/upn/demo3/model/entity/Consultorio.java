package pe.edu.upn.demo3.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import pe.edu.upn.demo3.model.entity.Medico;

@Entity
@Table(name="Consultorios")
public class Consultorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_consultorio")
	private Integer id_consultorio;
	
	@Column(name="nom_consultorio",length = 50,nullable = false)
	private String nombre_consultorio;
	
	//************************RELACIONES
	@ManyToMany(mappedBy = "consultorios")
	private List<Medico> medicos;

	public Consultorio() {
		medicos=new ArrayList<>();
	}
	//-----------------
		public void addMedico(Medico medico) {
			medico.addConsultorio(this);
			medicos.add(medico);
		}
		//-----------------
	//***********GETTERS AND SETTERS
	public Integer getId_consultorio() {
		return id_consultorio;
	}

	public void setId_consultorio(Integer id_consultorio) {
		this.id_consultorio = id_consultorio;
	}

	public String getNombre_consultorio() {
		return nombre_consultorio;
	}

	public void setNombre_consultorio(String nombre_consultorio) {
		this.nombre_consultorio = nombre_consultorio;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	
	//***********GETTERS AND SETTERS
}
