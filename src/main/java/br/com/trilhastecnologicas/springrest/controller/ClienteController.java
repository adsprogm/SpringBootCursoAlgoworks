package br.com.trilhastecnologicas.springrest.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.trilhastecnologicas.springrest.domain.model.Cliente;
import br.com.trilhastecnologicas.springrest.domain.repository.ClienteRepository;
import br.com.trilhastecnologicas.springrest.service.ClienteService;

@RestController
@RequestMapping("/cliente") /* colocado aqui para não precisar colocar 
em cada end point como na primeira versão */
public class ClienteController {

	
	//private ClienteRepository clienteRepository;
	@Autowired
	ClienteService clienteService;

	/*@GetMapping
	public List<Cliente> listar() {

		return clienteRepository.findAll(); 
	}

	@GetMapping("/{id}")
	ResponseEntity<Cliente> findByID(@PathVariable("id") Long id) {
		Optional<Cliente> cli = clienteRepository.findById(id);
		//forma como Ensinou o Vimersom da Hitec
		//return new ResponseEntity(cli, HttpStatus.OK);
		//outra forma pela algoworks
		if(cli.isPresent()) {
			return ResponseEntity.ok(cli.get());
		}
		return ResponseEntity.notFound().build();		

	}*/
	
	@GetMapping("/search")
	public Page<Cliente>search(
			@RequestParam("nome")String nome,
			@RequestParam(
					value = "page",
					required = false,
					defaultValue = "0")int page,
			@RequestParam(
					value = "zize",
					required = false,
					defaultValue = "3") int size){
		return clienteService.search(nome, page, size);
	}
	@GetMapping
    public Page<Cliente> getAll() {
        return clienteService.findAll();
    }

}
