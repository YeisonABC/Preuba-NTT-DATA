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

import com.proyecto.app.entity.Usuario;
import com.proyecto.app.service.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//crea el usuario
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Usuario usuario){	
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	//leer usuario
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value ="id") int usuarioId){
		Optional<Usuario> usuario = usuarioService.findById(usuarioId);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	//actualizar
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario detalleUsuario, @PathVariable(value ="id") int usuarioId){
		Optional<Usuario> usuario = usuarioService.findById(usuarioId);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(detalleUsuario, usuario.get()); se puede utilizar siempre y cuando no se utilize el id
		usuario.get().setNombreUsuario(detalleUsuario.getNombreUsuario());
		usuario.get().setApellido(detalleUsuario.getApellido());
		usuario.get().setFechaIngreso(detalleUsuario.getFechaIngreso());
		usuario.get().setDireccion(detalleUsuario.getDireccion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
	}
	
	//borrar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id")int usuarioId){
		if(!usuarioService.findById(usuarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.deletById(usuarioId);
		return ResponseEntity.ok().build();
	}
	
	//mostrar todos los usuarios
	@GetMapping
	public List<Usuario> readAll(){
		List<Usuario> usuario = StreamSupport.stream(usuarioService.findAll().spliterator(), false).collect(Collectors.toList());
		return usuario;		
	}
	

}
