package br.com.trilhastecnologicas.springrest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.trilhastecnologicas.springrest.domain.model.Cliente;


@RestController
public class ClienteController {

	  
	 @PersistenceContext  //para injetar a dependenia do EntityManager
	 
	private EntityManager entityManager;//foi suado para saber o que o JPA faz por debaixo dos panos
		@GetMapping("/cliente")
	public List<Cliente> listar() {		

		 /*Usamos a linguagem JPQL entityManager.createQuery("from Cliente", Cliente.class)
		  o Cliente.class na instrução é para tipar a conasulta*/
		
		return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
	}
	 
    

}
