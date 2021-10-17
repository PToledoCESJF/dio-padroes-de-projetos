package com.digitalInnovationOne.labpadroesprojetosspring.service;

import com.digitalInnovationOne.labpadroesprojetosspring.model.dto.ClienteDTO;
import com.digitalInnovationOne.labpadroesprojetosspring.model.entity.Cliente;

public interface ClienteService {

    Iterable<ClienteDTO> buscarTodos();

    ClienteDTO buscarPorId(Long id);

    void inserir(ClienteDTO clienteDTO);

    void atualizar(Long id, ClienteDTO clienteDTO);

    void deletar(Long id);
}
