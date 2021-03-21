package br.com.fiap.arremate.msintensao.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Intensao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntensao;

    private Long idProduto;

    private String descricao;

    private BigDecimal valorEstimado;

    private Long idComprador;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

}
