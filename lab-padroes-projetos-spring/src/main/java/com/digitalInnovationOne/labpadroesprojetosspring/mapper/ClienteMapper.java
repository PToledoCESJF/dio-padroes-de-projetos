package com.digitalInnovationOne.labpadroesprojetosspring.mapper;

import com.digitalInnovationOne.labpadroesprojetosspring.model.dto.ClienteDTO;
import com.digitalInnovationOne.labpadroesprojetosspring.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente toModel(ClienteDTO clienteDTO);

    ClienteDTO toDTO(Cliente cliente);
}
