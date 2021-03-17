package br.com.fiap.arremate.mscomprador.service.impl;

import br.com.fiap.arremate.mscomprador.dtos.request.CompradorDTO;
import br.com.fiap.arremate.mscomprador.entities.Comprador;
import br.com.fiap.arremate.mscomprador.repositories.CompradorRepository;
import br.com.fiap.arremate.mscomprador.service.CompradorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

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
        Optional<Comprador> comprador = compradorRepository.findById(id);

        return mapper.map(comprador, CompradorDTO.class);
    }

    @Override
    public CompradorDTO cadastrar(CompradorDTO compradorDTO) {
        Comprador intensao = mapper.map(compradorDTO, Comprador.class);
        compradorRepository.save(intensao);

        return mapper.map(intensao, CompradorDTO.class);
    }

    @Override
    public void editar(Long id, CompradorDTO compradorDTO) {
        Comprador intensao = mapper.map(listarPorId(id), Comprador.class);
        intensao.setCpf(compradorDTO.getCpf());
        intensao.setNome(compradorDTO.getNome());
        intensao.setSobrenome(compradorDTO.getSobrenome());
        intensao.setUsuario(compradorDTO.getUsuario());
        intensao.setEndereco(compradorDTO.getEndereco());
        intensao.setContato(compradorDTO.getContato());

        compradorRepository.save(intensao);
    }

    @Override
    public void deletar(Long id) {
        compradorRepository.delete(mapper.map(listarPorId(id), Comprador.class));
    }
}
