package com.example.microservicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.microservicos.domain.Cliente;
import com.example.microservicos.domain.dto.ClienteDto;
import com.example.microservicos.infra.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository repository;
	
	
	public Cliente save(ClienteDto clienteDto) {
	    Cliente cliente = Cliente.fromClienteDto(clienteDto);
	    return repository.save(cliente);
	}
	
	public Optional<Cliente> getById(Long id){
		return repository.findById(id);
	}
	
	public List<Cliente> getClientesAll(){
		return repository.findAll();
	}
}
