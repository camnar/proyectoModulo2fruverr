package com.example.fruver;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.fruver.entities.Cliente;
import com.example.fruver.entities.Pedido;
import com.example.fruver.repositories.CarritoRepository;
import com.example.fruver.repositories.ClienteRepository;
import com.example.fruver.repositories.PedidoRepository;
import com.example.fruver.repositories.ProductoRepository;

@Configuration
class LoadData {

	@Bean
	CommandLineRunner poblarBD(CarritoRepository carritoRepository, ClienteRepository clientesRepository,
			PedidoRepository pedidosRepository, ProductoRepository productosRepository) {
		return args -> {
			System.out.println("Poblando Base de datos");
			Cliente camilo = new Cliente();
			camilo.setNombre("Camilo Narvaez");
			Pedido pedido1 = new Pedido();
			// camilo.setPedidos(new ArrayList<>());
			camilo.getPedido().add(pedido1);
			clientesRepository.save(camilo);

		};
	}

}