package br.com.fiap.arremate.msintensao.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IntensaoDTO {

    private Long idIntensao;

    private Long idProduto;

    private String descricao;

    private BigDecimal valorEstimado;

    private Long idComprador;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;
}
