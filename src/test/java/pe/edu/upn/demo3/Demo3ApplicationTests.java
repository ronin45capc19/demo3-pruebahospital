package pe.edu.upn.demo3;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.demo3.model.entity.Consultorio;
import pe.edu.upn.demo3.model.entity.Especialidad;
import pe.edu.upn.demo3.model.entity.Medico;
import pe.edu.upn.demo3.model.entity.Paciente;
import pe.edu.upn.demo3.model.repository.ConsultorioRepository;
import pe.edu.upn.demo3.model.repository.EspecialidadRepository;
import pe.edu.upn.demo3.model.repository.MedicoRepository;
import pe.edu.upn.demo3.model.repository.PacienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo3ApplicationTests {
	
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private ConsultorioRepository consultorioRepository;
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Test
	public void contextLoads() {
		try {
			//********************PACIENTE
			Paciente paciente1= new Paciente();
			paciente1.setNombre_paciente("paciente1");
			paciente1.setDireccion_paciente("huancayo3774");
			paciente1.setTelefono_paciente(980706258);
			paciente1.setFechaNacimiento_paciente(new Date(2019,9,9));
			paciente1= pacienteRepository.save(paciente1);
			
			//********************MEDICOS
			Medico medico1=new Medico();
			medico1.setNombremedico("CARLOS");
			medico1.setDireccion_medico("jiron mao maito");
			medico1.setTelefono_medico(992753336);
			medico1 = medicoRepository.save(medico1);
			
			//*********************ESPECIALIDAD
			Especialidad cirujano=new Especialidad();
			cirujano.setNombre_especialidad("cirujano");
			cirujano = especialidadRepository.save(cirujano);
			
			//**********************CONSULTORIOS
			Consultorio consultorio1= new Consultorio();
			consultorio1.setNombre_consultorio("GALLETA");
			consultorio1 = consultorioRepository.save(consultorio1);
			
//	       ---relacion PACIENTE MEDICO
				paciente1.setMedico(medico1);
			//RELACION MEDICO PACIENTE
				medico1.addPaciente(paciente1);
			
				//RELACION MEDICO ESPECIALIDAD
				medico1.setEspecialidad(cirujano);
			//RELACION ESPECIALIDAD MEDICO
				cirujano.addMedico(medico1);
				
				//RELACION MEDICO CONSULTORIO
				medico1.addConsultorio(consultorio1);
				//RELACION CONSULTORIO MEDICO
				consultorio1.addMedico(medico1);
				
				//GRABADO
				medicoRepository.save(medico1);
				especialidadRepository.save(cirujano);
				consultorioRepository.save(consultorio1);
				pacienteRepository.save(paciente1);
				
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
