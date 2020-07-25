package com.hospital.saocamilo.cadastroHospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.saocamilo.cadastroHospital.model.Pacientes;
import com.hospital.saocamilo.cadastroHospital.respository.PacientesRepository;

@RestController
@RequestMapping("/api")
public class PacientesController {

	@Autowired
	private PacientesRepository pacientesRepository;
	
	@GetMapping("/buscar")
	public List<Pacientes> listarPacientes(){
		return pacientesRepository.findAll();
	}
	
	@PostMapping("/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public Pacientes adicionarPacientes(@RequestBody Pacientes pacientes){
		return pacientesRepository.save(pacientes);
		
	}
	
	@PutMapping("/atualizar/{pacientesId}")
	public ResponseEntity<Pacientes> atualizar(@PathVariable long pacientesId,
			@RequestBody Pacientes pacientes){
		if(!pacientesRepository.existsById(pacientesId)) {
			return ResponseEntity.notFound().build();
		}
		pacientes.setId(pacientesId);
		pacientes = pacientesRepository.save(pacientes);
			return ResponseEntity.ok(pacientes);
	}
	
	@DeleteMapping("/deletar/{pacientesId}")
	public ResponseEntity<Void> remover(@PathVariable long pacientesId){
		if(!pacientesRepository.existsById(pacientesId)) {
			return ResponseEntity.notFound().build();
		} 
		pacientesRepository.deleteById(pacientesId);
			return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
