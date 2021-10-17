package com.digitalInnovationOne.labpadroesprojetosspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotEmpty
    private String nome;

    @Valid
    @NotEmpty
    private EnderecoDTO enderecoDTO;

}
