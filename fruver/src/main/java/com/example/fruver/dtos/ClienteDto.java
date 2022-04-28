package com.example.fruver.dtos;

import java.util.ArrayList;
import java.util.List;

import com.example.fruver.entities.Pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

	Long id;
	String nombre;
	String correo;
	Long celular;
	String contrasena;

}
