package it.david.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="dipartimento")
public class Dipartimento {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dipartimento")
	private Long id;
	
	private String nome;
	private String indirizzo;
	
	@OneToMany(mappedBy= "dipartimento", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Dipendente> dipendenti;
	
	
	
	public Dipartimento() {
    this.dipendenti = new HashSet<>();
    }
	public Dipartimento(String nome, String indirizzo) {
		
		this.nome = nome;
		this.indirizzo = indirizzo;
	    this.dipendenti = new HashSet<>();
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public Set<Dipendente> getDipendenti() {
		return dipendenti;
	}
	public void setDipendenti(Set<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	public Long getId() {
		return id;
	}
	
	
	
	@Override
	public String toString() {
		return " id: " + id + " nome: " + nome + " indirizzo: " + indirizzo;
	}
	
}
