package com.web.biblioteca.membros;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MembroRepository extends
        CrudRepository<MembroEntity,Long>{

     Optional<Object> findByEmail(String email);
}
