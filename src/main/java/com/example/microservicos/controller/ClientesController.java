package com.example.microservicos.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.microservicos.domain.Cliente;
import com.example.microservicos.domain.dto.ClienteDto;
import com.example.microservicos.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesController {
	
	@Autowired
	private final ClienteService service;

	@GetMapping("/status")
	public String status() {
		return "Status Ok!";
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto objDto){
		Cliente cliente = service.save(objDto);
		URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(headerLocation).build();
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> clientesAll(){
	    List<Cliente> list = service.getClientesAll();
	    List<ClienteDto> listDTO = list.stream()
	                                   .map(cliente -> {
	                                       ClienteDto clienteDto = new ClienteDto();
	                                       clienteDto.setId(cliente.getId());
	                                       clienteDto.setNome(cliente.getNome());
	                                       clienteDto.setCpf(cliente.getCpf());
	                                       clienteDto.setIdade(cliente.getIdade());
	                                       return clienteDto;
	                                   })
	                                   .collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDTO);
	}
	
	public ResponseEntity clienteById(@RequestParam("id") Long id){
		var cliente = service.getById(id);
		if(cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
		
	}
}
