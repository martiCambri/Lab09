package it.polito.tdp.borders.model;

public class Country {
	
	private int stateCode; //ccCode
	private String nomeBreve;
	private String nomeCompleto;
	
	
	public Country(int stateCode, String nomeBreve, String nomeCompleto) {
		
		this.stateCode = stateCode;
		this.nomeBreve = nomeBreve;
		this.nomeCompleto = nomeCompleto;
	}


	public int getStateCode() {
		return stateCode;
	}


	public String getNomeBreve() {
		return nomeBreve;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}


	public void setNomeBreve(String nomeBreve) {
		this.nomeBreve = nomeBreve;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeBreve == null) ? 0 : nomeBreve.hashCode());
		result = prime * result + ((nomeCompleto == null) ? 0 : nomeCompleto.hashCode());
		result = prime * result + stateCode;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (nomeBreve == null) {
			if (other.nomeBreve != null)
				return false;
		} else if (!nomeBreve.equals(other.nomeBreve))
			return false;
		if (nomeCompleto == null) {
			if (other.nomeCompleto != null)
				return false;
		} else if (!nomeCompleto.equals(other.nomeCompleto))
			return false;
		if (stateCode != other.stateCode)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Stato " + nomeBreve;
	}
	
	

}
