package com.practica.usuarioservice.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practica.usuarioservice.modelos.Auto;
import com.practica.usuarioservice.modelos.Moto;
import com.practica.usuarioservice.repositorio.UsuarioRepositorio;
import com.practica.usuarioservice.usuario.Usuario;

@Service
public class UsuarioServicio {
	
	@Autowired
	UsuarioRepositorio usuariorepositorio;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Usuario> getAll(){
		return usuariorepositorio.findAll();
	}
	
	public Usuario getUsuarioById(int id) {
		return usuariorepositorio.findById(id).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		Usuario nuevousuario=usuariorepositorio.save(usuario);
		return nuevousuario;
	}

	public List<Auto> getauto (int usuarioId){
		List<Auto>autos=restTemplate.getForObject("http://localhost:8002/auto/byusuario/"+ usuarioId, List.class);
		return autos;
	}
	
	public List<Moto> getmoto (int usuarioId){
		List<Moto> motos=restTemplate.getForObject("http://localhost:8003/moto/byusuario/"+ usuarioId, List.class);
		return motos;
	}
}
