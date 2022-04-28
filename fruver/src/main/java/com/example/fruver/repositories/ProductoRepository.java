package com.example.fruver.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.fruver.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	Optional<Producto> getById(Long id);
}
