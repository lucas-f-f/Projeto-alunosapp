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

import com.lucas.alunosapp.entity.Disciplina;
import com.lucas.alunosapp.service.DisciplinaService;

@RestController
@RequestMapping(value = "/alunosapp/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaService service;

	@GetMapping
	public ResponseEntity<List<Disciplina>> listAll() {
		List<Disciplina> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping(value = "/{id}")// localhost:8080/alunosapp/<id>
	public ResponseEntity<Disciplina> findById(@PathVariable Integer id) {
		Disciplina obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// @PostMapping utilizado para inserir informacoes
	@PostMapping
	public ResponseEntity<Disciplina> create(@RequestBody Disciplina obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/disciplinas/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Disciplina> update (@PathVariable Integer id, @RequestBody Disciplina disciplina){
		Disciplina newObj = service.update(id, disciplina);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestBody Disciplina disciplina){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
