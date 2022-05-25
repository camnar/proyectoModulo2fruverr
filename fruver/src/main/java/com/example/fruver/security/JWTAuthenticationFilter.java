package com.example.fruver.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.fruver.entities.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {
    try {
      Cliente credenciales = new ObjectMapper().readValue(request.getInputStream(), Cliente.class);

      return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
          credenciales.getCorreo(), credenciales.getContrasena(), new ArrayList<>()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication auth) throws IOException, ServletException {

    var rol = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

    final Map<String, Object> claims = new HashMap<>();
    claims.put("rol", rol);
    claims.put("valor1", "1");
    claims.put("otrovalor", 100L);

    String token = Jwts.builder().setIssuedAt(new Date()).setClaims(claims)
        .setSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal())
            .getUsername())
        .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 Hora
        .signWith(SignatureAlgorithm.HS512, "12345") // Algoritmo y clave secreta para firmar
        .compact();

    response.addHeader("Authorization", "Bearer " + token);
  }

}