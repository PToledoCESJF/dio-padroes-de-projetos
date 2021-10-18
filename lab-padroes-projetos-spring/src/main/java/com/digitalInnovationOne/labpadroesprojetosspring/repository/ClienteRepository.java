package com.digitalInnovationOne.labpadroesprojetosspring.repository;

import com.digitalInnovationOne.labpadroesprojetosspring.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
