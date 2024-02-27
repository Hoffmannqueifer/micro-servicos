package com.example.microservicos.domain;

import com.example.microservicos.domain.dto.ClienteDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;
	private Integer idade;
	
	public Cliente() {
		
	}
	
	public Cliente(Long id, String cpf, String nome, Integer idade) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}
	
	public Cliente(ClienteDto clienteDto) {
		this.id = clienteDto.getId();
        this.cpf = clienteDto.getCpf();
        this.nome = clienteDto.getNome();
        this.idade = clienteDto.getIdade();
    }
	
	public static Cliente fromClienteDto(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDto.getCpf());
        cliente.setNome(clienteDto.getNome());
        cliente.setIdade(clienteDto.getIdade());
        return cliente;
    }
	
	
}
