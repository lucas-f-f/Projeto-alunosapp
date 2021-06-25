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

import com.lucas.alunosapp.entity.Curso;
import com.lucas.alunosapp.service.CursoService;

@RestController
@RequestMapping(value = "/alunosapp/turmas")
public class CursoController {

	@Autowired
	private CursoService service;

	@GetMapping
	public ResponseEntity<List<Curso>> listAll() {
		List<Curso> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping(value = "/{id}")// localhost:8080/alunosapp/<id>
	public ResponseEntity<Curso> findById(@PathVariable Integer id) {
		Curso obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// @PostMapping utilizado para inserir informacoes
	@PostMapping
	public ResponseEntity<Curso> create(@RequestBody Curso obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/cursos/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Curso> update (@PathVariable Integer id, @RequestBody Curso obj){
		Curso newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestBody Curso obj){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
