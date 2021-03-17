package br.com.fiap.arremate.mscomprador.dtos.request;

import br.com.fiap.arremate.mscomprador.entities.Contato;
import br.com.fiap.arremate.mscomprador.entities.Endereco;
import br.com.fiap.arremate.mscomprador.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompradorDTO {

    private Long id;

    private String cpf;

    private String nome;

    private String sobrenome;

    private Usuario usuario;

    private Endereco endereco;

    private Contato contato;
}
