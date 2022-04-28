package com.example.fruver.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fruver.dtos.CarritoDto;
import com.example.fruver.dtos.ClienteDto;
import com.example.fruver.entities.Carrito;
import com.example.fruver.entities.Cliente;

@RestController
@RequestMapping("api")

public class FruverController {
@Autowired
FruverServiceImp service;
@Autowired
private ModelMapper mapper;
@GetMapping("getCliente")
	public ClienteDto getCliente(@RequestParam(name="Id")Long Id) {
	var cliente= service.getCliente(Id);
	return mapper.map(cliente,ClienteDto.class);
}
@GetMapping("getCarrito")
public Carrito getCarrito(@RequestParam(name="Id")Long Id) {
return service.getCarrito(Id);
}
@DeleteMapping("deleteCarrito")
public void deleteCarrito(@RequestBody CarritoDto dto) {
	service.deleteCarrito(dto);
}
@PutMapping("crearCliente")
public Cliente crearCliente(@RequestBody ClienteDto dto) {
	return service.crearCliente(dto);
	
}


}
