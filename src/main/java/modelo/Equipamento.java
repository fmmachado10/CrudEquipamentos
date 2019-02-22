package modelo;

import java.io.Serializable;

public class Equipamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6445394253836413751L;

	private long id;
	
	private String descricao;
	
	private String numeroPatrimonio;
	
	private String local;
	
	public Equipamento() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumeroPatrimonio() {
		return numeroPatrimonio;
	}

	public void setNumeroPatrimonio(String numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	
}
