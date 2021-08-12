package com.encontro42.cidade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encontro42.cidade.entity.Cidade;
import com.encontro42.cidade.repository.CidadeRepository;

@RestController
@RequestMapping("cidade")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8090", "http://localhost:9876"} )
public class CidadeController {
	
	@Autowired
	private CidadeRepository repositorio;
	
	@GetMapping("listar")
	public List<Cidade> listarCidade(){
		return repositorio.findAll();
	}
	
	@PostMapping("incluir")
	public void incluir(@RequestBody Cidade novaCidade) {
		repositorio.save(novaCidade);
		repositorio.flush();
	}

}
