package br.com.fiap.arremate.msintensao.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalhesErro implements Serializable {

	@JsonInclude(Include.NON_NULL)
	private String titulo;

	@JsonInclude(Include.NON_NULL)
	private Long status;
}
