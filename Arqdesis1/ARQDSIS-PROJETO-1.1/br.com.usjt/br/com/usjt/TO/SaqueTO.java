package br.com.usjt.TO;

public class SaqueTO {
	
	private int conta, agencia;
	private Double saque;

	public int getConta() {
		return conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public Double getSaque() {
		return saque;
	}

	public void setSaque(Double saque) {
		this.saque = saque;
	}
}