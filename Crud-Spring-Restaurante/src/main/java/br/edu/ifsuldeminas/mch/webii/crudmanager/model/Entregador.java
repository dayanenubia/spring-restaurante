package br.edu.ifsuldeminas.mch.webii.crudmanager.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="entregadores")
public class Entregador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Nome não pode ser vazio" )
	private String nome;
	
	@NotBlank(message = "Genero não pode ser vazio" )
	private String genero;
	
	@NotBlank(message = "tipoVeiculo não pode ser vazio" )
	private String tipoVeiculo;
	
	
	private String telefone;

	public Entregador() {};
	
	public Entregador(Integer id)
	{
		this.id = id;
		setNome("");
		setGenero("");
		setTipoVeiculo("");
		setTelefone("");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}