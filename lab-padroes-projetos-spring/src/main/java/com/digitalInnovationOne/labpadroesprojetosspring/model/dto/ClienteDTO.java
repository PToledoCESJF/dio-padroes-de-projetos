package com.digitalInnovationOne.labpadroesprojetosspring.model.dto;

import com.digitalInnovationOne.labpadroesprojetosspring.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String nome;

    @Valid
    @NotEmpty
    private Endereco endereco;

}
