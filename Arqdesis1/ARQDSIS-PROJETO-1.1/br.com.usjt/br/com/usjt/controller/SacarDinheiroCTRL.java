package br.com.usjt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import br.com.usjt.model.Saque;
import br.com.usjt.view.TelaOutroValor;
import br.com.usjt.view.TelaSaque;
import br.com.usjt.view.TelaSelecionarOpcoes;

public class SacarDinheiroCTRL extends TelaSaque{

	public SacarDinheiroCTRL(Saque Saque){
		super(Saque);
		addBtn10(new btn10Listener());
		addBtn20(new btn20Listener());
		addBtn50(new btn50Listener());
		addBtn100(new btn100Listener());
		addBtn200(new btn200Listener());
		addBtn500(new btn500Listener());
		addBtnVoltar(new btnVoltarListener());
		addbtnOutrosValores(new btnOutrosValoresListener());	
	}
	
	public void update(Observable arg0, Object arg1){
		
	}

	class btn10Listener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			getSaque().setConta(getNumConta());
			getSaque().setAgencia(getAgencia());
			getSaque().fazerSaque(10);
			
		}
	}
	
	class btn20Listener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			getSaque().setConta(getNumConta());
			getSaque().setAgencia(getAgencia());
			getSaque().fazerSaque(20);
		}
	}
	class btn50Listener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			getSaque().setConta(getNumConta());
			getSaque().setAgencia(getAgencia());
			getSaque().fazerSaque(50);
		}
	}
	class btn100Listener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			getSaque().setConta(getNumConta());
			getSaque().setAgencia(getAgencia());
			getSaque().fazerSaque(100);
		}
	}
	class btn200Listener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			getSaque().setConta(getNumConta());
			getSaque().setAgencia(getAgencia());
			getSaque().fazerSaque(200);
		}
	}
	
	class btn500Listener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			getSaque().setConta(getNumConta());
			getSaque().setAgencia(getAgencia());
			getSaque().fazerSaque(500);
		}
	}
	
	class btnVoltarListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			TelaSelecionarOpcoes seleionar = new TelaSelecionarOpcoes();
			seleionar.internacionalizar(getIdioma());
			seleionar.setTitle(getNomeCliente());
			seleionar.setNomeCliente(getNomeCliente());
			seleionar.setNumConta(getNumConta());
			seleionar.setAgencia(getAgencia());
			seleionar.setSize(500,300);
			seleionar.setVisible(true);
			dispose();
		}
	}
	
	class btnOutrosValoresListener implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			TelaOutroValor outro = new TelaOutroValor();
			outro.internacionalizar(getIdioma());
			outro.setNumConta(getNumConta());
			outro.setAgencia(getAgencia());
			outro.setTitle(getNomeCliente());
			outro.setNomeCliente(getNomeCliente());
			outro.setSize(600, 400);
			outro.setVisible(true);
			dispose();
		} 
	}
}