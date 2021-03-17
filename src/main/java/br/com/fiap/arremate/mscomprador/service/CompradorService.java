package br.com.fiap.arremate.mscomprador.service;

import br.com.fiap.arremate.mscomprador.dtos.request.CompradorDTO;

import java.util.List;

public interface CompradorService {

    List<CompradorDTO> listar();

    CompradorDTO listarPorId(Long id);

    CompradorDTO cadastrar(CompradorDTO compradorDTO);

    void editar(Long id, CompradorDTO compradorDTO);

    void deletar(Long id);
}
