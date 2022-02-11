package com.example.demo2.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.xml.validation.Validator;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo2.model.Usuario;
import com.example.demo2.repository.UsuarioRepository;

@Service
public class ServicioHello {
	@Autowired
	private UsuarioRepository userRepo;
	@Value("${course.message}")
	private String mensaje= "Hola mundo";
	
	
	public String respuesta() {
		return mensaje;
	}
	public List<Usuario> getUsers() {
		return userRepo.findAll();
	}
	public Usuario getUsuario(Integer id) {
		return userRepo.findById((int)id);
	}
	public Usuario deleteUsuario(int id) {
		return userRepo.deleteById(id);
	}

	public Usuario save(Usuario usuario) {
		return userRepo.save(usuario);	
    }
}
