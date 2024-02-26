package com.example.microservicos.domain;

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
	
	
	public Cliente(String cpf, String nome, Integer idade) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}
	
	
}
