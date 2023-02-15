package br.com.requeijo.desafio.programas.repository;

import br.com.requeijo.desafio.programas.entity.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {
}
