package com.example.microservicos.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.microservicos.domain.Cliente;
import com.example.microservicos.domain.dto.ClienteDto;
import com.example.microservicos.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClientesController {
	
	@Autowired
	private final ClienteService service;

	@GetMapping
	public String status() {
		return "Status Ok!";
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody ClienteDto request){
		Cliente cliente = request.toModel();
		service.save(cliente);
		URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(cliente.getCpf()).toUri();
		return ResponseEntity.created(headerLocation).build();
	}
}
