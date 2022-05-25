package com.example.fruver.security;



import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.fruver.entities.Cliente;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  private UsuarioRepository usuarioRepository;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Cliente> usuarioOpt = usuarioRepository.findByCorreo(username);

    if (usuarioOpt.isPresent()) {
      Cliente cliente = usuarioOpt.get();

      var authorities = List.of(new SimpleGrantedAuthority("ROLE_"+cliente.getNombre().toUpperCase()));

      return new User(cliente.getCorreo(), cliente.getContrasena(), authorities);
    }

    throw new UsernameNotFoundException(username);
  }
}