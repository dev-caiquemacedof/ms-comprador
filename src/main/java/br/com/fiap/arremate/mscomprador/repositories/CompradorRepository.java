package br.com.fiap.arremate.mscomprador.repositories;

import br.com.fiap.arremate.mscomprador.entities.Comprador;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends PagingAndSortingRepository<Comprador, Long> {

}