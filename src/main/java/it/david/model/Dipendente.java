package it.david.model;

import it.david.utility.JobIdEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="dipendente")
public class Dipendente {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome,cognome,email,telefono;
	
	@Column(name="data_assunzione")
	private String dataAssunzione;
	
	@Enumerated(EnumType.STRING)
	private JobIdEnum lavoroId;
	
	private double salario;
	
	@ManyToOne
	@JoinColumn(name="id_dipartimento", referencedColumnName = "id_dipartimento")
	private Dipartimento dipartimento;
	
	
	
	public Dipendente() {}
	
	public Dipendente(String nome, String cognome, String email, String telefono, String dataAssunzione,
			JobIdEnum lavoroId, double salario) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.dataAssunzione = dataAssunzione;
		this.lavoroId = lavoroId;
		this.salario = salario;
	}

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(String dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public JobIdEnum getLavoroId() {
		return lavoroId;
	}

	public void setLavoroId(JobIdEnum lavoroId) {
		this.lavoroId = lavoroId;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public Long getId() {
		return id;
	}

	
	
	@Override
	public String toString() {
		return " id: " + id + " nome: " + nome + " cognome: " + cognome + " email: " + email + " telefono: " + telefono
				+ " dataAssunzione: " + dataAssunzione + " lavoroId: " + lavoroId + " salario: " + salario;
	}
}


