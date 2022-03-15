package com.devmam.domain.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmam.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	//métodos de consulta	
	List<Cliente>findByNome(String nome);
	
	//Nome não exato
	List<Cliente> findByNomeContaining(String nome);
	
	//Busca por email
	java.util.Optional<Cliente> findByEmail(String email);
	

}
