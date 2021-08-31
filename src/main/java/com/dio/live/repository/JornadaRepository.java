package com.dio.live.repository;

import com.dio.live.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //  Anota classes na camada de persistência, que atuará como um repositório de banco de dados;
public interface JornadaRepository extends JpaRepository<JornadaTrabalho, Long> {
/*
O @Repository tem como objetivo criar beans (objetos que serão gerenciados pelo Spring) para a parte de persistência,
além de capturar exceções específicas de persistência e repeti-las novamente como uma das exceções não verificadas e
unificadas do Spring.
*/
}
