package com.lucas.alunosapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.alunosapp.entity.Disciplina;
import com.lucas.alunosapp.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	// Instanciar repository
	@Autowired
	private DisciplinaRepository repository;

	// Metodo encontre todas disciplinas
	public List<Disciplina> findAll() {
		List<Disciplina> lista = repository.findAll();
		return lista;

	}

	// procurar disciplinas pelo id
	public Disciplina findById(Integer id) {
		Optional<Disciplina> obj = repository.findById(id);
		return obj.orElse(null);
	}

	// criar disciplinas
	public Disciplina create(Disciplina obj) {
		obj.setId(null); // Isso porque na classe de entidade já existe o configurador de id
		return repository.save(obj); // persistindo objeto na base de dados
	}

	// atualizar disciplinas
	public Disciplina update(Integer id, Disciplina disciplina) {
		// Caso o objeto ja exista faca
		Disciplina newObj = findById(id);
		newObj.setNome(disciplina.getNome());
		return repository.save(newObj);

	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
