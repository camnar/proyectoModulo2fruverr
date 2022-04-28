package com.example.fruver.dtos;
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
public class CarritoDto {

	Long id;
	List<ProductoDto> producto = new ArrayList<>();
	ClienteDto cliente;

}
