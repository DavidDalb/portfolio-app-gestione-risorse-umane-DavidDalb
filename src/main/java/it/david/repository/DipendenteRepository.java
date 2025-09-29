package it.david.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.david.model.Dipendente;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente,Long> {

	List<Dipendente> findByEmail(String email);
	
	List<Dipendente> findBySalaryGreaterThan(double salario);
	
	List<Dipendente> findAllByOrderByDataAssunzioneAsc();
	
	List<Dipendente> findByNomeAndCognome(String nome,String cognome);
}
