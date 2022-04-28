package com.example.fruver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.fruver.entities.Carrito;

public interface CarritoRepository extends CrudRepository<Carrito, Long> {
	Carrito getById(Long id);
}
