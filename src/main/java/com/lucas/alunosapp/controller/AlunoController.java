package com.lucas.alunosapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.alunosapp.entity.Aluno;
import com.lucas.alunosapp.service.AlunoService;

@RestController
@RequestMapping(value = "/alunosapp")
public class AlunoController {

	@Autowired
	private AlunoService service;

	@GetMapping
	public ResponseEntity<List<Aluno>> listAll() {
		List<Aluno> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping(value = "/{id}")// localhost:8080/alunosapp/<id>
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		Aluno obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// @PostMapping utilizado para inserir informacoes
	@PostMapping
	public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
		aluno = service.create(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(aluno);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Aluno> update (@PathVariable Integer id, @RequestBody Aluno aluno){
		Aluno newObj = service.update(id, aluno);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestBody Aluno aluno){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
