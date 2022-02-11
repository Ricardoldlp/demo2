package com.example.demo2.controller;


import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.model.Usuario;
import com.example.demo2.services.ServicioHello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value="Controller")
@RestController
public class RESTController {
	
	@Autowired
	private ServicioHello servicio;
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	@ResponseBody
    public String holaMundo(){
    	return servicio.respuesta();
    }
	@ApiResponses({
	        @ApiResponse(code = 200, message = "ok"),
	        @ApiResponse(code = 404, message = "Not found"),
	        @ApiResponse(code = 500, message = "Internal server error")})
	@RequestMapping(method = RequestMethod.GET, value= "/users")
	@ResponseBody
	public List<Usuario> getUsuarios() {
		return servicio.getUsers();
	}
	@RequestMapping(method = RequestMethod.GET, value= "/user/{id}")
	@ResponseBody
	public Usuario getUsuario(@PathVariable int id) {
		return servicio.getUsuario(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	@ResponseBody
	public Usuario deleteUsuario(@PathVariable int id) {
		return servicio.deleteUsuario(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/saveuser")
	@ResponseBody
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return servicio.save(usuario);
	}
	
	
	@ExceptionHandler(IllegalStateException.class)
	public String exceptionHandler() {
		return "error";
	}
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
	return new ResponseEntity<>("Ha ocurrido un error de validación: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
