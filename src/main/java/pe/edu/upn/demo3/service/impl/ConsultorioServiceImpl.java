package pe.edu.upn.demo3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.demo3.model.entity.Consultorio;
import pe.edu.upn.demo3.model.repository.ConsultorioRepository;
import pe.edu.upn.demo3.service.ConsultorioService;

@Service
public class ConsultorioServiceImpl implements ConsultorioService {
	
	@Autowired
	private ConsultorioRepository consultorioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Consultorio> findAll() throws Exception {
		// TODO Auto-generated method stub
		return consultorioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Consultorio> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return consultorioRepository.findById(id);
	}

	@Transactional
	@Override
	public Consultorio save(Consultorio entity) throws Exception {
		// TODO Auto-generated method stub
		return consultorioRepository.save(entity);
	}

	@Transactional
	@Override
	public Consultorio update(Consultorio entity) throws Exception {
		// TODO Auto-generated method stub
		return consultorioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		consultorioRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		consultorioRepository.deleteAll();
	}

}
