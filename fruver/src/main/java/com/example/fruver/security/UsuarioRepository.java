package com.example.fruver.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.fruver.entities.Cliente;

@Repository
public interface UsuarioRepository extends CrudRepository<Cliente, Long>{
	Optional<Cliente> findByCorreo(String value);
}
