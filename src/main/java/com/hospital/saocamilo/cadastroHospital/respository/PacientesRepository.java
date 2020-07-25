package com.hospital.saocamilo.cadastroHospital.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.saocamilo.cadastroHospital.model.Pacientes;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Long>{

	
	
}
