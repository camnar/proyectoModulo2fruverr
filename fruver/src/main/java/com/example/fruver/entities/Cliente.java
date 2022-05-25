package com.example.fruver.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nombre;
	@Column(unique = true)
	String correo;
	Long celular;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	List<Pedido> pedido = new ArrayList<>();

	String contrasena;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Role role;

}
