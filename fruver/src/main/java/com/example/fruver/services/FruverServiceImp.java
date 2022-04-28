package com.example.fruver.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fruver.dtos.CarritoDto;
import com.example.fruver.dtos.ClienteDto;
import com.example.fruver.entities.Carrito;
import com.example.fruver.entities.Cliente;
import com.example.fruver.repositories.CarritoRepository;
import com.example.fruver.repositories.ClienteRepository;

@Service
public class FruverServiceImp {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CarritoRepository carritoRepository;

	public Cliente getCliente(Long Id) {
		return clienteRepository.getById(Id);
	}

	public Carrito getCarrito(Long Id) {
		return carritoRepository.getById(Id);
	}

	
	public void deleteCarrito(CarritoDto dto) {
		carritoRepository.deleteById(dto.getId());
	}

	
	public Cliente crearCliente(ClienteDto dto) {
		ModelMapper mapper = new ModelMapper();

		Optional<Cliente> cliente = clienteRepository.getByCorreo(dto.getCorreo());

		if (cliente.isEmpty()) {
			return clienteRepository.save(mapper.map(dto,Cliente.class));
		} else {
			return null;
		}

	}
}
