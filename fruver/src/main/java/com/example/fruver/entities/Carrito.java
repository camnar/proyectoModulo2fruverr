package com.example.fruver.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@ManyToMany(fetch = FetchType.LAZY)

	List<Producto> producto = new ArrayList<>();
	@OneToOne
	Cliente cliente;

}
