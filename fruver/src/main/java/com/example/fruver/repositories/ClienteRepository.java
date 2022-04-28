package com.example.fruver.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.fruver.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	Cliente getById(Long id);
	
	Optional<Cliente> getByCorreo(String correo);
}
