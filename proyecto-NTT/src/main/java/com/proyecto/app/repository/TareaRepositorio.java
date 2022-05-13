package com.proyecto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.app.entity.Tarea;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Integer>{

}
