package br.com.fiap.arremate.msintensao.service.impl;

import br.com.fiap.arremate.msintensao.dtos.request.IntensaoDTO;
import br.com.fiap.arremate.msintensao.dtos.response.IntensaoResponseDTO;
import br.com.fiap.arremate.msintensao.dtos.response.comprador.Comprador;
import br.com.fiap.arremate.msintensao.dtos.response.produto.Categoria;
import br.com.fiap.arremate.msintensao.dtos.response.produto.Marca;
import br.com.fiap.arremate.msintensao.dtos.response.produto.Modelo;
import br.com.fiap.arremate.msintensao.dtos.response.produto.Produto;
import br.com.fiap.arremate.msintensao.entities.Intensao;
import br.com.fiap.arremate.msintensao.exceptions.ExceptionErros;
import br.com.fiap.arremate.msintensao.repositories.IntensaoRepository;
import br.com.fiap.arremate.msintensao.service.CompradorFeign;
import br.com.fiap.arremate.msintensao.service.IntensaoService;
import br.com.fiap.arremate.msintensao.service.ProdutoFeign;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class IntensaoServiceImpl implements IntensaoService {

    private final IntensaoRepository intensaoRepository;
    private final RabbitTemplate rabbitTemplate;
    private final ModelMapper mapper;
    private final ProdutoFeign produtoFeign;
    private final CompradorFeign compradorFeign;

    @Override
    public List<IntensaoDTO> listar() {
        List<Intensao> intensoes = intensaoRepository.findAll();
        return mapListaIntensao(intensoes);
    }

    @Override
    public IntensaoDTO listarPorId(Long id) {
        Intensao intensao = intensaoRepository.findByIdIntensao(id);
        if(null==intensao){
            throw new ExceptionErros("Intensão não encontrada.");
        }

        return mapper.map(intensao, IntensaoDTO.class);
    }

    @Override
    public IntensaoDTO cadastrar(IntensaoDTO intensaoDTO) throws JsonProcessingException {
        Intensao intensao = mapper.map(intensaoDTO, Intensao.class);
        intensao.setData(LocalDate.now());
        intensaoRepository.save(intensao);
        enviarIntensaoFila(intensao);
        return mapper.map(intensao, IntensaoDTO.class);
    }

    @Override
    public void editar(Long id, IntensaoDTO intensaoDTO) {
        Intensao intensao = mapper.map(listarPorId(id), Intensao.class);
        intensao.setDescricao(intensaoDTO.getDescricao());
        intensao.setIdComprador(intensaoDTO.getIdComprador());
        intensao.setIdProduto(intensaoDTO.getIdProduto());
        intensao.setValorEstimado(intensaoDTO.getValorEstimado());

        intensaoRepository.save(intensao);
    }

    @Override
    public void deletar(Long id) {
        intensaoRepository.delete(mapper.map(listarPorId(id), Intensao.class));
    }

    private List<IntensaoDTO> mapListaIntensao(List<Intensao> intensoes) {
        return intensoes.stream()
                .map(transaction -> this.mapper.map(transaction, IntensaoDTO.class))
                .collect(Collectors.toList());
    }

    private void enviarIntensaoFila(Intensao intensao) throws JsonProcessingException {
        IntensaoResponseDTO intensaoResponseDTO = new IntensaoResponseDTO();
        Produto produto = produtoFeign.buscaProduto(intensao.getIdProduto());
        System.out.println(">>>>>>>>>>>> " + produto.getModelo());
        Comprador comprador = compradorFeign.buscaComprador(intensao.getIdComprador());
        System.out.println(">>>>>>>>>>>>" + comprador.getNome());
        intensaoResponseDTO.setProduto(produto);
        intensaoResponseDTO.setComprador(comprador);
        intensaoResponseDTO.setDescricao(intensao.getDescricao());
        intensaoResponseDTO.setValorEstimado(intensao.getValorEstimado());
        rabbitTemplate.convertAndSend("arremate.exchange", "arremate.routingkey", new ObjectMapper().writeValueAsString(intensaoResponseDTO));
    }

}
