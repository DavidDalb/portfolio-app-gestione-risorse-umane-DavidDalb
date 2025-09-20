package it.david.model;

import java.util.HashSet;
import java.util.Set;

public class Dipartimento {
	
	
	
	private Long id;

	private String nome;
	private String indirizzo;
	
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
