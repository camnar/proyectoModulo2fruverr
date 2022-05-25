package com.example.fruver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fruver.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
