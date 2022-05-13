package com.proyecto.app.service;

import java.util.Optional;

import com.proyecto.app.entity.Tarea;

public interface TareaService {
	
	public Iterable<Tarea> findAll();
	
	public Optional<Tarea>findById(int id);
	
	public Tarea save(Tarea tarea);
	
	public void deletById(int id);
	
}
