package br.com.usjt.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.usjt.model.Acesso;
import br.com.usjt.view.TelaAdmDoSistemaLogin;
import br.com.usjt.view.TelaDeAcesso;
import br.com.usjt.view.TelaSobre;

public class AcessarContaCTRL extends TelaDeAcesso {

	public AcessarContaCTRL(Acesso acesso) {
		super(acesso);
		addBtnOkListener(new btnOkListener());
		addBtnCancelarListener(new btnCancelarListener());
		addEscolherIdiomaListener(new btnEscolherIdiomaListener());
		addmntmSairListener(new mntmSairListener());
		addmntmSobreListener(new mntmSobreListener());
		addmntmmtmAdmListener(new mntmmtmAdmListener());
	}

	public void update(Observable arg0, Object arg1) {

	}

	class btnOkListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			try { 
				getAcesso().setAgencia(getTextAgencia());
			}catch(NumberFormatException erro){ 
				JOptionPane.showMessageDialog(null, "entre com uma agencia valida"); 
				return; 
			}

			try { 
				getAcesso().setConta(getTextConta()); 
			}catch(NumberFormatException erro){ 
				JOptionPane.showMessageDialog(null, "entre com uma conta valida"); 
				return; 
			}

			try { 
				getAcesso().setSenha(Integer.parseInt(String.valueOf(getTextSenha())));//converte o jPassword para string e depois para inteiro 
			}catch(NumberFormatException erro){ 
				JOptionPane.showMessageDialog(null," entre com uma senha valida"); 
				return; 
			}

			try {
				if(getAcesso().validar() == true){
					dispose();
					getAcesso().setIdioma(getIdioma());
				

				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "conta inexistente");
				e.printStackTrace();
			}
		}
	}

	class btnCancelarListener implements ActionListener {
		public void actionPerformed(ActionEvent a){
			System.exit(0);
		}
	}

	class mntmSairListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			System.exit(0);
		}
	}

	class mntmSobreListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			TelaSobre about = new TelaSobre();
			about.setSize(400, 250);
			about.setVisible(true);

		}
	}

	class mntmmtmAdmListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			TelaAdmDoSistemaLogin adm =  new TelaAdmDoSistemaLogin();
			adm.validar();
		}
	}

	class btnEscolherIdiomaListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			if (getEscolherIdioma().getSelectedItem() == "Português") {
				internacionalizar(ResourceBundle.getBundle("projeto", new Locale("pt", "BR")));//coloca o idioma porgues na classe login
				setIdioma(ResourceBundle.getBundle("projeto", new Locale("pt", "BR")));
				getAcesso().setIdioma(ResourceBundle.getBundle("projeto", new Locale("pt", "BR")));


			}else if(getEscolherIdioma().getSelectedItem() == "Inglês"){
				internacionalizar(ResourceBundle.getBundle("Projeto", Locale.US));//coloca o idioma ingles na classe login
				setIdioma(ResourceBundle.getBundle("Projeto", Locale.US));
				getAcesso().setIdioma(ResourceBundle.getBundle("Projeto", Locale.US));

			}else if(getEscolherIdioma().getSelectedItem() == "Español"){
				internacionalizar(ResourceBundle.getBundle("projeto", new Locale("es", "ES")));//coloca o idioma espanhol na classe login
				setIdioma(ResourceBundle.getBundle("projeto", new Locale("es", "ES")));
				getAcesso().setIdioma(ResourceBundle.getBundle("projeto", new Locale("es", "ES")));
			}
		}
	}
}