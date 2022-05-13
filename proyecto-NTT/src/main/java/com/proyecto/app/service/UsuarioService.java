package com.proyecto.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.app.entity.Usuario;

public interface UsuarioService {

	public Iterable<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Optional<Usuario>findById(int id);
	
	public Usuario save(Usuario usuario);
	
	public void deletById(int id);
}
