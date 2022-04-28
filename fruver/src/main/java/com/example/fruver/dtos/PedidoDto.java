package com.example.fruver.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.fruver.entities.Cliente;
import com.example.fruver.entities.Producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
	Long id;
	ClienteDto cliente;
	List<ProductoDto> producto = new ArrayList<>();
	LocalDateTime fecha;
}
