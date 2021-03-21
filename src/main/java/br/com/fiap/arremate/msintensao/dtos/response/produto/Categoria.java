package br.com.fiap.arremate.msintensao.dtos.response.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categoria {

    private Long id;

    private String nome;
}
