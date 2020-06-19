package br.com.trilhastecnologicas.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.trilhastecnologicas.springrest.domain.model.Cliente;
import br.com.trilhastecnologicas.springrest.domain.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Page<Cliente>search(
			String nome,
			int page,
			int size){
		PageRequest pageRequest = PageRequest.of(
				page,
                size,
                Sort.Direction.ASC,"nome");
		return clienteRepository.search(nome, pageRequest);
				
		
	}
	public Page<Cliente> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "nome");
        return new PageImpl<>(
        		clienteRepository.findAll(), 
                pageRequest, size);
    }
}
