package br.com.usjt.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;

import br.com.usjt.model.Conta;
import br.com.usjt.view.TelaSaldo;
import br.com.usjt.view.TelaSelecionarOpcoes;

public class SaldoDeContaCTRL extends TelaSaldo{

	public SaldoDeContaCTRL(Conta conta){
		super(conta);
		addbtnVoltarListener(new btnVoltarListener());
		addbtnImpressaoListener(new addbtnImpressaoListener());	
	}

	public void update(Observable arg0, Object arg1){

	}

	class btnVoltarListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			TelaSelecionarOpcoes selecionar = new TelaSelecionarOpcoes();
			selecionar.internacionalizar(getIdioma());
			selecionar.setTitle(getNomeCliente());
			selecionar.setNomeCliente(getNomeCliente());
			selecionar.setNumConta(getNumConta());
			selecionar.setAgencia(getAgencia());
			selecionar.setSize(500,300);
			selecionar.setVisible(true);
			dispose();
		}
	}

	class addbtnImpressaoListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			getConta().setAgencia(getAgencia());
			getConta().setNumConta(getNumConta());
			try {
				getConta().imprimir();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}