package br.com.fiap.arremate.mscomprador.repositories;

import br.com.fiap.arremate.mscomprador.entities.Comprador;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @RepositoryRestResource.
 *
 * Spring magicamente cria nossa camada de Repository e saberá receber nosso modelo.
 * Além disso, essa interface possibilita as tarefas de CRUD no Banco de Dados.
 * Finalmente, com essa Annotation também é criada uma camada de Controller internamente.
 * Esse Controller expõe o CRUD através de uma API REST.
 * Portanto, usando esse Annotation, não é necessário criar manualmente Controllers e Services.
 */

@RepositoryRestResource( path = "comprador", collectionResourceRel = "comprador")
public interface CompradorRepository extends PagingAndSortingRepository<Comprador, Long> {

}