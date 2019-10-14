package pe.edu.upn.demo3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.demo3.model.entity.Especialidad;

@Repository
public interface EspecialidadRepository 
	extends JpaRepository<Especialidad, Integer>{

}
