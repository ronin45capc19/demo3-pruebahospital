package pe.edu.upn.demo3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.demo3.model.entity.Especialidad;
import pe.edu.upn.demo3.model.entity.Medico;
import pe.edu.upn.demo3.service.ConsultorioService;
import pe.edu.upn.demo3.service.EspecialidadService;
import pe.edu.upn.demo3.service.MedicoService;
import pe.edu.upn.demo3.service.PacienteService;

@Controller
@RequestMapping("/medico")
@SessionAttributes("Medico")
public class MedicoController {
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private EspecialidadService especialidadService;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private ConsultorioService consultorioService;
	
	@GetMapping
	private String inicio(Model model) {
		try {
			List<Medico> medicos=medicoService.findAll();
			model.addAttribute("Medicos",medicos);
		} catch (Exception e) {
			System.out.println("*****************");
		}
		return "/medico/inicio";
		
	}
	
	@GetMapping("/edit/{id_medico}")
	public String editar(@PathVariable("id_medico")int id, Model model) {
		try {
			Optional<Medico> optional = medicoService.findById(id);
			if (optional.isPresent()) {
				
				List<Especialidad> especialidades 
					= especialidadService.findAll(); 
				
				model.addAttribute("medico", optional.get());
				model.addAttribute("especialidades", especialidades);
			} else {
				return "redirect:/medico";
			}
		} catch (Exception e) {
			System.out.println("***********************");
		}
		
		return "/medico/edit";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("medico")Medico medico,
				Model model, SessionStatus status) {
		try {
			medicoService.save(medico);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/medico";
	}
	

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Medico medico=new Medico();
		model.addAttribute("medico",medico);
		try {
			List<Especialidad>especialidades=especialidadService.findAll();
			model.addAttribute("especialidades",especialidades);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/medico/nuevo";
	}
	
	
		
	@GetMapping("/del/{id_medico}")
	public String eliminar(@PathVariable("id_medico")int id,Model model) {
		
		try {
			Optional<Medico> medico = medicoService.findById(id);
			if(medico.isPresent()) {
				medicoService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Medico> medicos = medicoService.findAll();
				model.addAttribute("Medicos", medicos);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/medico/inicio";
		}
		
		return "redirect:/medico";
	}
	
	

	@GetMapping("/info/{id_medico}")
	public String info(@PathVariable("id_medico")int id,Model model) {
		try {
		Optional<Medico> medico=medicoService.findById(id);
		if (medico.isPresent()) {
			model.addAttribute("medico", medico.get());}
		else {return "redirect:/medico";}}catch (Exception e) {}
				
		return "/medico/info";
	}
}
