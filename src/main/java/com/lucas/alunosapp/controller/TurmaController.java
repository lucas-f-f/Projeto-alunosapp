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

import com.lucas.alunosapp.entity.Turma;
import com.lucas.alunosapp.service.TurmaService;

@RestController
@RequestMapping(value = "/alunosapp/turmas")
public class TurmaController {

	@Autowired
	private TurmaService service;

	@GetMapping
	public ResponseEntity<List<Turma>> listAll() {
		List<Turma> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping(value = "/{id}")// localhost:8080/alunosapp/<id>
	public ResponseEntity<Turma> findById(@PathVariable Integer id) {
		Turma obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// @PostMapping utilizado para inserir informacoes
	@PostMapping
	public ResponseEntity<Turma> create(@RequestBody Turma obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/turmas/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Turma> update (@PathVariable Integer id, @RequestBody Turma obj){
		Turma newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestBody Turma obj){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
