package br.com.usjt.TO;

import java.util.Date;

public class MovimentoTO {
	private int codigoMovimento;
	private Date dataDoMovimento;
	private double valorDaOperacao;


	public int getCodigoMovimento() {
		return codigoMovimento;
	}

	public void setCodigoMovimento(int codigoMovimento) {
		this.codigoMovimento = codigoMovimento;
	}

	public Date getDataDoMovimento() {
		return dataDoMovimento;
	}

	public void setDataDoMovimento(Date dataDoMovimento) {
		this.dataDoMovimento = dataDoMovimento;
	}

	public double getValorDaOperacao() {
		return valorDaOperacao;
	}

	public void setValorDaOperacao(double valorDaOperacao) {
		this.valorDaOperacao = valorDaOperacao;
	}
}