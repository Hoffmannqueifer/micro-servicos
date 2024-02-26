package com.example.microservicos.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicos.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
