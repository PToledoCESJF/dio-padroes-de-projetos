package com.digitalInnovationOne.labpadroesprojetosspring.repository;

import com.digitalInnovationOne.labpadroesprojetosspring.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
