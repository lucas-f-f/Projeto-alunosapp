package com.lucas.alunosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.alunosapp.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

}
