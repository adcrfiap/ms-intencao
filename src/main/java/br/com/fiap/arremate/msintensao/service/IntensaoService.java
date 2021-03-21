package br.com.fiap.arremate.msintensao.service;

import br.com.fiap.arremate.msintensao.dtos.request.IntensaoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IntensaoService {

    List<IntensaoDTO> listar();

    IntensaoDTO listarPorId(Long id);

    IntensaoDTO cadastrar(IntensaoDTO intensaoDTO) throws JsonProcessingException;

    void editar(Long id, IntensaoDTO intensaoDTO);

    void deletar(Long id);
}
