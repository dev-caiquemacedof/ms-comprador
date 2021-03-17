package br.com.fiap.arremate.mscomprador.service.impl;

import br.com.fiap.arremate.mscomprador.dtos.request.CompradorDTO;
import br.com.fiap.arremate.mscomprador.entities.Comprador;
import br.com.fiap.arremate.mscomprador.repositories.CompradorRepository;
import br.com.fiap.arremate.mscomprador.service.CompradorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CompradorServiceImpl implements CompradorService {

    private final CompradorRepository compradorRepository;

    private final ModelMapper mapper;

    @Override
    public List<CompradorDTO> listar() {
        List<Comprador> compradores = (List<Comprador>) compradorRepository.findAll();

        return compradores.stream()
                .map(transaction -> this.mapper.map(transaction, CompradorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompradorDTO listarPorId(Long id) {
        Comprador comprador = getComprador(id);

        return mapper.map(comprador, CompradorDTO.class);
    }

    @Override
    public CompradorDTO cadastrar(CompradorDTO compradorDTO) {
        Comprador comprador = mapper.map(compradorDTO, Comprador.class);
        compradorRepository.save(comprador);

        return mapper.map(comprador, CompradorDTO.class);
    }

    @Override
    public void editar(Long id, CompradorDTO compradorDTO) {
        Comprador comprador = mapper.map(listarPorId(id), Comprador.class);
        comprador.setCpf(compradorDTO.getCpf());
        comprador.setNome(compradorDTO.getNome());
        comprador.setSobrenome(compradorDTO.getSobrenome());
        comprador.setUsuario(compradorDTO.getUsuario());
        comprador.setEndereco(compradorDTO.getEndereco());
        comprador.setContato(compradorDTO.getContato());

        compradorRepository.save(comprador);
    }

    @Override
    public void deletar(Long id) {
        compradorRepository.delete(mapper.map(listarPorId(id), Comprador.class));
    }

    private Comprador getComprador(Long id) {
        return compradorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
