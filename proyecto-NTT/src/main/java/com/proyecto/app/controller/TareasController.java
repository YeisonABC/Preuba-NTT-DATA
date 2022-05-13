package com.proyecto.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.app.entity.Tarea;
import com.proyecto.app.service.TareaService;

@RestController
@RequestMapping("/tarea")
public class TareasController {

	@Autowired
	private TareaService tareaService;
	
	//crea tarea
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Tarea tarea){	
		return ResponseEntity.status(HttpStatus.CREATED).body(tareaService.save(tarea));
	}
	
	//leer usuario
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value ="id") int tareaId){
		Optional<Tarea> tarea = tareaService.findById(tareaId);
		if(!tarea.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(tarea);
	}
	
	//actualizar
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Tarea detalleTarea, @PathVariable(value ="id") int tareaId){
		Optional<Tarea> tarea = tareaService.findById(tareaId);
		if(!tarea.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(detalleUsuario, usuario.get()); se puede utilizar siempre y cuando no se utilize el id
		tarea.get().setNombre(detalleTarea.getNombre());
		tarea.get().setEstado(detalleTarea.isEstado());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tareaService.save(tarea.get()));
	}
	
	//borrar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id")int tareaId){
		if(!tareaService.findById(tareaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		tareaService.deletById(tareaId);
		return ResponseEntity.ok().build();
	}
	
	//mostrar todas las tareas
	@GetMapping
	public List<Tarea> readAll(){
		List<Tarea> tarea = StreamSupport.stream(tareaService.findAll().spliterator(), false).collect(Collectors.toList());
		return tarea;		
	}
	
}
