package com.lucas.alunosapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.alunosapp.entity.Turma;
import com.lucas.alunosapp.repository.TurmaRepository;

@Service
public class TurmaService {

	// Instanciar repository
	@Autowired
	private TurmaRepository repository;

	// Metodo encontre todas disciplinas
	public List<Turma> findAll() {
		List<Turma> lista = repository.findAll();
		return lista;

	}

	// procurar disciplinas pelo id
	public Turma findById(Integer id) {
		Optional<Turma> obj = repository.findById(id);
		return obj.orElse(null);
	}

	// criar disciplinas
	public Turma create(Turma obj) {
		obj.setId(null); // Isso porque na classe de entidade já existe o configurador de id
		return repository.save(obj); // persistindo objeto na base de dados
	}

	// atualizar disciplinas
	public Turma update(Integer id, Turma obj) {
		// Caso o objeto ja exista faca
		Turma newObj = findById(id);
		newObj.setPeriodo(obj.getPeriodo());
		return repository.save(newObj);

	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
