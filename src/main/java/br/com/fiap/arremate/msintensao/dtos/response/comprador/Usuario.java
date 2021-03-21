package br.com.fiap.arremate.msintensao.dtos.response.comprador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    private String id;

    private String usuario;

    private String email;

    private String senha;
}
