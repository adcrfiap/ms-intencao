package br.com.fiap.arremate.msintensao.service;

import br.com.fiap.arremate.msintensao.dtos.response.comprador.Comprador;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://mscomprador:8080/comprador/", name = "comprador")
public interface CompradorFeign {

    @GetMapping("{idComprador}")
    Comprador buscaComprador(@PathVariable("idComprador") Long idComprador);
}
