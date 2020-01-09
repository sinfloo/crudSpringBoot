package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.modelo.Persona;
import com.crud.demo.modeloDAO.IPersona;
import com.crud.demo.serviceInterface.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersona dao;
	
	@Override
	public List<Persona> listar() {		
		return (List<Persona>) dao.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {		
		return dao.findById(id);
	}

	@Override
	public int save(Persona p) {
		int res=0;
		Persona per=dao.save(p);
		if(!per.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		dao.deleteById(id);
		
	}

}
