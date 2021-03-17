package br.com.fiap.arremate.mscomprador.controllers;

import br.com.fiap.arremate.mscomprador.dtos.request.CompradorDTO;
import br.com.fiap.arremate.mscomprador.service.CompradorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comprador")
@AllArgsConstructor
public class CompradorController {
    private final CompradorService compradorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompradorDTO> listar(){
        return compradorService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompradorDTO listarPorId(@PathVariable Long id){
        return compradorService.listarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompradorDTO cadastrar(@RequestBody CompradorDTO intensaoDTO){
        return compradorService.cadastrar(intensaoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editar(@PathVariable Long id, @RequestBody CompradorDTO intensaoDTO){
        compradorService.editar(id, intensaoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        compradorService.deletar(id);
    }
}
