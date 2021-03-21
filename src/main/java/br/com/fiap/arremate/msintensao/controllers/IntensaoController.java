package br.com.fiap.arremate.msintensao.controllers;

import br.com.fiap.arremate.msintensao.dtos.request.IntensaoDTO;
import br.com.fiap.arremate.msintensao.service.IntensaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("intensao")
@AllArgsConstructor
public class IntensaoController {

    private final IntensaoService intensaoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IntensaoDTO> listar(){
        return intensaoService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IntensaoDTO listarPorId(@PathVariable Long id){
        return intensaoService.listarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IntensaoDTO cadastrar(@RequestBody IntensaoDTO intensaoDTO) throws JsonProcessingException {
        return intensaoService.cadastrar(intensaoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editar(@PathVariable Long id, @RequestBody IntensaoDTO intensaoDTO){
        intensaoService.editar(id, intensaoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        intensaoService.deletar(id);
    }
}
