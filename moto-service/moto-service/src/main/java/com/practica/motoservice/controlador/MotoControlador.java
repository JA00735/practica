package com.practica.motoservice.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.motoservice.moto.Moto;
import com.practica.motoservice.servicio.MotoServicio;


@RestController
@RequestMapping("/moto")
public class MotoControlador {
	
	@Autowired
	MotoServicio motoservicio;
	
	@GetMapping
	public ResponseEntity<List<Moto>> getAll(){
		List<Moto> moto=motoservicio.getAll();
		if(moto.isEmpty()) {
		  return ResponseEntity.noContent().build();	
			
		}
		return ResponseEntity.ok(moto);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> getAutoById(@PathVariable ("id")int id){
	     Moto moto=motoservicio.getMotoById(id);
		if(moto==null) {
		  return ResponseEntity.notFound().build();	
			
		}
		return ResponseEntity.ok(moto);
	
	}
	
	@PostMapping
	public ResponseEntity<Moto> save (@RequestBody Moto moto){
	     Moto nuevamoto=motoservicio.save(moto);
		if(moto==null) {
		  return ResponseEntity.notFound().build();	
			
		}
		return ResponseEntity.ok(nuevamoto);
	
	}
	
	@GetMapping("/byusuario/{usuarioId}")
	public ResponseEntity<List<Moto>> findByUsuarioId(@PathVariable ("usuarioId") int usuarioId){
		List<Moto> moto=motoservicio.findByUsuarioId(usuarioId);
		if(moto.isEmpty()) {
		  return ResponseEntity.noContent().build();	
			
		}
		return ResponseEntity.ok(moto);
	}
}
