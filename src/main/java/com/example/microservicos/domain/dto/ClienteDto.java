package com.example.microservicos.domain.dto;

import com.example.microservicos.domain.Cliente;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClienteDto {

	private Long id;
	private String cpf;
	private String nome;
	private Integer idade;
	
	public ClienteDto() {
		
	}
	
	public Cliente toModel() {
		return new Cliente(id, cpf, nome, idade);
	}

	public ClienteDto(Long id, String cpf, String nome, Integer idade) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}
	
}
