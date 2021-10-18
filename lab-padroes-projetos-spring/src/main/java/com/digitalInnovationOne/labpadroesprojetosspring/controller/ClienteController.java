package com.digitalInnovationOne.labpadroesprojetosspring.controller;

import com.digitalInnovationOne.labpadroesprojetosspring.controller.exception.ClienteNotFoundException;
import com.digitalInnovationOne.labpadroesprojetosspring.mapper.ClienteMapper;
import com.digitalInnovationOne.labpadroesprojetosspring.model.dto.ClienteDTO;
import com.digitalInnovationOne.labpadroesprojetosspring.model.entity.Cliente;
import com.digitalInnovationOne.labpadroesprojetosspring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) throws ClienteNotFoundException {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody @Valid ClienteDTO clienteDTO) {
        clienteService.inserir(clienteDTO);
        Cliente cliente = clienteMapper.toModel(clienteDTO);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) throws ClienteNotFoundException {
        clienteService.atualizar(id, clienteDTO);
        Cliente cliente = clienteMapper.toModel(clienteDTO);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) throws ClienteNotFoundException {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
