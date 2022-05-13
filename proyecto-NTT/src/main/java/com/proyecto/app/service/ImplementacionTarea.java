package com.proyecto.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.app.entity.Tarea;
import com.proyecto.app.repository.TareaRepositorio;

@Service
public class ImplementacionTarea implements TareaService{

	@Autowired
	private TareaRepositorio tareaRepositorio;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Tarea> findAll() {
		return tareaRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tarea> findById(int id) {
		return tareaRepositorio.findById(id);
	}

	@Override
	@Transactional
	public Tarea save(Tarea tarea) {
		return tareaRepositorio.save(tarea);
	}

	@Override
	@Transactional
	public void deletById(int id) {
		tareaRepositorio.deleteById(id);
		
	}


	
	
	
}
