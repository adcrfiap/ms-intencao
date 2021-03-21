package br.com.fiap.arremate.msintensao.dtos.response.comprador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Comprador {

    private String id;

    private String cpf;

    private String nome;

    private String sobreNome;

    private Usuario usuario;

    private Endereco endereco;

    private Contato contato;

}
