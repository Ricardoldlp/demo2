package com.example.demo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo2.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	List<Usuario> findAll();
	
	Usuario findById(int id);
	
	Usuario deleteById(int id);
	
	@SuppressWarnings("unchecked")
	Usuario save(Usuario usuario);
}
