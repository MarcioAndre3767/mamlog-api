package com.devmam.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devmam.domain.exception.NegocioException;
import com.devmam.domain.model.Cliente;
import com.devmam.domain.model.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		//lógica para proibir email duplicado
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));	
				
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
		}		
		
		return clienteRepository.save(cliente);		
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}

 






