package com.lucas.alunosapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.alunosapp.entity.Aluno;
import com.lucas.alunosapp.repository.AlunoRepository;

@Service
public class AlunoService {

	// Instanciar repository
	@Autowired
	private AlunoRepository repository;

	// Metodo encontre todos alunos
	public List<Aluno> findAll() {
		List<Aluno> lista = repository.findAll();
		return lista;

	}
	
	public Aluno findById(Integer id) {
		Optional<Aluno> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public Aluno create(Aluno obj) {
		obj.setId(null); // Isso porque  na classe de entidade já existe o configurador de id
		return repository.save(obj); //persistindo objeto na base de dados
	}
	
	public Aluno update(Integer id, Aluno aluno) {
		//Caso o objeto ja exista faca
		Aluno newObj = findById(id);
		newObj.setNome(aluno.getNome());
		newObj.setMatricula(aluno.getMatricula());
		return repository.save(newObj);
	
	}
	
	public void delete (Integer id) {
		repository.deleteById(id);
	}

}
