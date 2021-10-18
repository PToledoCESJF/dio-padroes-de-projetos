package com.digitalInnovationOne.labpadroesprojetosspring.service;

import com.digitalInnovationOne.labpadroesprojetosspring.controller.exception.ClienteNotFoundException;
import com.digitalInnovationOne.labpadroesprojetosspring.model.dto.ClienteDTO;
import com.digitalInnovationOne.labpadroesprojetosspring.model.dto.response.MessageResponseDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> buscarTodos();

    ClienteDTO buscarPorId(Long id) throws ClienteNotFoundException;

    MessageResponseDTO inserir(ClienteDTO clienteDTO);

    MessageResponseDTO atualizar(Long id, ClienteDTO clienteDTO)  throws ClienteNotFoundException;

    void deletar(Long id)  throws ClienteNotFoundException;
}
