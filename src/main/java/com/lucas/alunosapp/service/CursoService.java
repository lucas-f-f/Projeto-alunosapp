package com.lucas.alunosapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.alunosapp.entity.Curso;
import com.lucas.alunosapp.repository.CursoRepository;

@Service
public class CursoService {

	// Instanciar repository
	@Autowired
	private CursoRepository repository;

	// Metodo encontre todas disciplinas
	public List<Curso> findAll() {
		List<Curso> lista = repository.findAll();
		return lista;

	}

	// procurar disciplinas pelo id
	public Curso findById(Integer id) {
		Optional<Curso> obj = repository.findById(id);
		return obj.orElse(null);
	}

	// criar curso
	public Curso create(Curso obj) {
		obj.setId(null); // Isso porque na classe de entidade já existe o configurador de id
		return repository.save(obj); // persistindo objeto na base de dados
	}

	// atualizar disciplinas
	public Curso update(Integer id, Curso obj) {
		// Caso o objeto ja exista faca
		Curso newObj = findById(id);
		newObj.setNome(obj.getNome());
		return repository.save(newObj);

	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
