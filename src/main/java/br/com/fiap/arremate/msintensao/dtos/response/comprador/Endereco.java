package br.com.fiap.arremate.msintensao.dtos.response.comprador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    private String id;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cep;

    private String cidade;

    private String estado;

}
