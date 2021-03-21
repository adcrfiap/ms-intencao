package br.com.fiap.arremate.msintensao.dtos.response;

import br.com.fiap.arremate.msintensao.dtos.response.comprador.Comprador;
import br.com.fiap.arremate.msintensao.dtos.response.produto.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IntensaoResponseDTO {


    private Produto produto;

    private String descricao;

    private BigDecimal valorEstimado;

    private Comprador comprador;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;
}
