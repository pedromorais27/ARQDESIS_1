package br.com.usjt.main;

import java.awt.EventQueue;

import br.com.usjt.controller.AcessarContaCTRL;
import br.com.usjt.model.Acesso;
import br.com.usjt.view.TelaDeAcesso;

public class CaixaEletronicoApp {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeAcesso frame = new AcessarContaCTRL(new Acesso());
					new AcessarContaCTRL(new Acesso());	
					frame.setSize(300, 300);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}