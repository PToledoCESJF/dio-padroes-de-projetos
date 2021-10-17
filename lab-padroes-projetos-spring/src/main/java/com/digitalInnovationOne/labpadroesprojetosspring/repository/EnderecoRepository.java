package com.digitalInnovationOne.labpadroesprojetosspring.repository;

import com.digitalInnovationOne.labpadroesprojetosspring.model.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
