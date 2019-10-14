package pe.edu.upn.demo3.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.demo3.model.entity.Medico;

@Repository
public interface MedicoRepository 
	extends JpaRepository<Medico, Integer>{
	List<Medico> findByNombremedico(String nombremedico);
	//List<Medico> findByNombre_medico(String nombre_medico);
}
