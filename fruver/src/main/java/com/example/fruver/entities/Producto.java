package com.example.fruver.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	double precio;
	String descripcion;
	int inventario;

}
