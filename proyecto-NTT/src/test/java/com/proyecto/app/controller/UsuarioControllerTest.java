package com.proyecto.app.controller;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.proyecto.app.service.UsuarioService;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

	
	@MockBean
	private UsuarioService usuarioService;
	
	@Test
	void testReadUsuario() {
		
		
	}
	


}
