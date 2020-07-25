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

import com.hospital.saocamilo.cadastroHospital.model.Medicos;
import com.hospital.saocamilo.cadastroHospital.respository.MedicoRepository;

@RestController
@RequestMapping("/api")
public class MedicosController {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@GetMapping("/buscarmedicos")
	public List<Medicos> listarMedicos(){
		return medicoRepository.findAll();
	}
	
	@PostMapping("/adionarmedicos")
	@ResponseStatus(HttpStatus.CREATED)
	public Medicos adicionarMedicos(@RequestBody Medicos medicos) {
		return medicoRepository.save(medicos);
	}
	
	@PutMapping("/atualizarmedicos/{medicosId}")
	public ResponseEntity<Medicos> atualizar(@PathVariable long medicosId,
			@RequestBody Medicos medicos){
		if(!medicoRepository.existsById(medicosId)) {
			return ResponseEntity.notFound().build();
		}
		medicos.setId(medicosId);
		medicos = medicoRepository.save(medicos);
		return ResponseEntity.ok(medicos);
	}
	
	@DeleteMapping("/deletarmedico/{medicosId}")
	public ResponseEntity<Void> remover(@PathVariable long medicosId){
		if(!medicoRepository.existsById(medicosId)) {
			return ResponseEntity.notFound().build();
		}
		medicoRepository.deleteById(medicosId);
		return ResponseEntity.noContent().build();
		
	}
	
	
}
