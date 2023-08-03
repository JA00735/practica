package com.practica.usuarioservice.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.usuarioservice.modelos.Auto;
import com.practica.usuarioservice.modelos.Moto;
import com.practica.usuarioservice.servicio.UsuarioServicio;
import com.practica.usuarioservice.usuario.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
	
	@Autowired
	UsuarioServicio usuarioservicio;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> usuario=usuarioservicio.getAll();
		if(usuario.isEmpty()) {
		  return ResponseEntity.noContent().build();	
			
		}
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable ("id") int id){
		Usuario usuario=usuarioservicio.getUsuarioById(id);
		if(usuario==null) {
		  return ResponseEntity.notFound().build();	
			
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> save (@RequestBody Usuario usuario){
		Usuario nuevousuario=usuarioservicio.save(usuario);
		if(usuario==null) {
		  return ResponseEntity.notFound().build();	
			
		}
		return ResponseEntity.ok(nuevousuario);
	}
	
	@GetMapping("/autos/{usuarioId}")
	public ResponseEntity<List<Auto>> getauto(@PathVariable ("usuarioId")int usuarioId){
		Usuario usuario =usuarioservicio.getUsuarioById(usuarioId);
		if(usuario==null) {
			return ResponseEntity.notFound().build();
			}
		List<Auto> autos=usuarioservicio.getauto(usuarioId);
		return ResponseEntity.ok(autos);
	}
	
	@GetMapping("/motos/{usuarioId}")
	public ResponseEntity<List<Moto>> getmoto(@PathVariable ("usuarioId")int usuarioId){
		Usuario usuario =usuarioservicio.getUsuarioById(usuarioId);
		if(usuario==null) {
			return ResponseEntity.notFound().build();
			}
		List<Moto> motos=usuarioservicio.getmoto(usuarioId);
		return ResponseEntity.ok(motos);
	}

}
