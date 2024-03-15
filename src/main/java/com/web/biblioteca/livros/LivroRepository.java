package com.web.biblioteca.livros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends
        JpaRepository<LivroEntity,Long> {

//    public interface LivroRepository extends
//            CrudRepository<LivroEntity,Integer>{
    Optional<Object> deleteByIsbn(String isbn);

    Optional<Object> findByIsbn(String isbn);
}
