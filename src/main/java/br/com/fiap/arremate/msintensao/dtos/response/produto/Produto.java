package br.com.fiap.arremate.msintensao.dtos.response.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Produto {

    private Long id;

    private String nome;

    private Categoria categoria;

    private Marca marca;

    private Modelo modelo;

}
