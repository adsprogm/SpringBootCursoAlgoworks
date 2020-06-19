package br.com.trilhastecnologicas.springrest.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.trilhastecnologicas.springrest.domain.model.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long >{
	
	/*Paginação :Em resumo, é a implementação capaz de fazer 
	 * sua API trabalhar de forma mais eficiente com os dados
	 * na  comunicação entre client e server, trafegando apenas o necessário!
	Cursor
	A paginação baseada em cursor funciona por uma chave única e sequencial que indica a partir de que registro os dados serão retornados.
	Em outras palavras, imaginem que você quer os registros a partir do vinho de ID 156 até o ID 200. Então, você faria a seguinte requisição:
	HTTP GET
	https://api.minhagastronomia/vinhos?since_id=156&max_id=200
	
	*link completo para explorar o assunto:
	*https://thiagolima.blog.br/parte-5-pagina%C3%A7%C3%A3o-ordena%C3%A7%C3%A3o-e-filtros-em-apis-restful-3045d88b4114/	
	*
	*/
	
	
	@Query("From Cliente cli" +
	       " Where " +
			"cli.nome like %:nome% ")
      Page<Cliente> search(
    		  @Param("nome")String nome,
            Pageable pageable);

	
	
}
