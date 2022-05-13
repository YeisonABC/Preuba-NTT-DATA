package com.proyecto.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.app.entity.Usuario;
import com.proyecto.app.repository.UsuarioRepositorio;

@Service
public class ImplementacionUsuario implements UsuarioService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		return usuarioRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(int id) {
		return usuarioRepositorio.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

	@Override
	@Transactional
	public void deletById(int id) {
		usuarioRepositorio.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		return usuarioRepositorio.findAll(pageable);
	}


	
}
