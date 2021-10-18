package com.digitalInnovationOne.labpadroesprojetosspring.service.impl;

import com.digitalInnovationOne.labpadroesprojetosspring.controller.exception.ClienteNotFoundException;
import com.digitalInnovationOne.labpadroesprojetosspring.mapper.ClienteMapper;
import com.digitalInnovationOne.labpadroesprojetosspring.model.dto.ClienteDTO;
import com.digitalInnovationOne.labpadroesprojetosspring.model.dto.response.MessageResponseDTO;
import com.digitalInnovationOne.labpadroesprojetosspring.model.entity.Cliente;
import com.digitalInnovationOne.labpadroesprojetosspring.model.entity.Endereco;
import com.digitalInnovationOne.labpadroesprojetosspring.repository.ClienteRepository;
import com.digitalInnovationOne.labpadroesprojetosspring.repository.EnderecoRepository;
import com.digitalInnovationOne.labpadroesprojetosspring.service.ClienteService;
import com.digitalInnovationOne.labpadroesprojetosspring.service.ViaCepService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;
    private ViaCepService viaCepService;
    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;


    @Override
    public List<ClienteDTO> buscarTodos() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream().map(clienteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO buscarPorId(Long id) throws ClienteNotFoundException {
        Cliente cliente = verificarSeExiste(id);
        return clienteMapper.toDTO(cliente);
    }

    @Override
    public MessageResponseDTO inserir(ClienteDTO clienteDTO) {
        Cliente clienteASalvar = clienteMapper.toModel(clienteDTO);
        Cliente clienteSalvo = salvarClienteCEP(clienteASalvar);
        return createMessageResponse(clienteSalvo.getId(), "Sucesso ao inserir o cliente de id: ");
    }

    @Override
    public MessageResponseDTO atualizar(Long id, ClienteDTO clienteDTO)  throws ClienteNotFoundException {
        verificarSeExiste(id);
        Cliente clienteAAtualizar = clienteMapper.toModel(clienteDTO);
        Cliente clienteAtualizado = salvarClienteCEP(clienteAAtualizar);
        return createMessageResponse(clienteAtualizado.getId(), "Sucesso ao atualizar o cliente de id: ");
    }

    @Override
    public void deletar(Long id)  throws ClienteNotFoundException {
        verificarSeExiste(id);
        clienteRepository.deleteById(id);
    }

    private Cliente verificarSeExiste(Long id) throws ClienteNotFoundException {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    public MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private Cliente salvarClienteCEP(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }
}
