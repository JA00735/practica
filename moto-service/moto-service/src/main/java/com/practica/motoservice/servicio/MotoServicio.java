package com.practica.motoservice.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.motoservice.moto.Moto;
import com.practica.motoservice.repositorio.MotoRepositorio;


@Service
public class MotoServicio {
	
	@Autowired
	MotoRepositorio motorepositorio;
	
	public List<Moto> getAll(){
		return motorepositorio.findAll();
	}
	
	public Moto getMotoById (int id) {
		return motorepositorio.findById(id).orElse(null);
	}
	
	public Moto save (Moto moto){
		Moto nuevamoto=motorepositorio.save(moto);
		return nuevamoto;
	}
	
	public List<Moto> findByUsuarioId(int usuarioId){
	return motorepositorio.findByUsuarioId(usuarioId);
	}
}
