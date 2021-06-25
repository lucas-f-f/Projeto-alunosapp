package com.lucas.alunosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.alunosapp.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
