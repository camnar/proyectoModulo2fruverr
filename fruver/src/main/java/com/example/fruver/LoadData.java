package com.example.fruver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
			PedidoRepository pedidosRepository, ProductoRepository productosRepository, BCryptPasswordEncoder bCryptPasswordEncoder ) {
		return args -> {
			System.out.println("Poblando Base de datos");
			Cliente camilo = new Cliente();
			camilo.setNombre("Camilo Narvaez");
			camilo.setContrasena(bCryptPasswordEncoder.encode("12345"));
			Pedido pedido1 = new Pedido();
			camilo.getPedido().add(pedido1);
			clientesRepository.save(camilo);
			
			Cliente sofia = new Cliente();
			sofia.setNombre("Sofia Coral");
			sofia.setContrasena(bCryptPasswordEncoder.encode("12345"));
			Pedido pedido2 = new Pedido();
			sofia.getPedido().add(pedido2);
			clientesRepository.save(sofia);

		};
	}

}