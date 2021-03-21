package br.com.fiap.arremate.msintensao.dtos.response.comprador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contato {

    private String id;

    private String telefone;

    private String celular;

    private String email;
}
