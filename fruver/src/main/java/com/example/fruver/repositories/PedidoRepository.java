package com.example.fruver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.fruver.entities.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	Pedido getById(Long id);
}
