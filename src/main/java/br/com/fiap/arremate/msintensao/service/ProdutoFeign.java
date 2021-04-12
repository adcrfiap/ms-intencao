package br.com.fiap.arremate.msintensao.service;

import br.com.fiap.arremate.msintensao.dtos.response.produto.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://msproduto:8081/produtos/", name = "produto")
public interface ProdutoFeign {

    @GetMapping("{idProduto}")
    Produto buscaProduto(@PathVariable("idProduto") Long idProduto);
}
