package it.david.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.david.model.Dipartimento;


@Repository
public interface DipartimentoRepository extends JpaRepository<Dipartimento,Long> {

}
