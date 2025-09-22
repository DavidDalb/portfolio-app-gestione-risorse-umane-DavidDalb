package it.david.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.david.model.Dipendente;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente,Long> {

}
