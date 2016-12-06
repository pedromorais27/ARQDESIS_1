package br.com.usjt.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.usjt.view.TelaEntrarComCodigo;
import br.com.usjt.view.TelaGerarCodigo;

public class Acesso  extends Observable{

	private int agencia, conta, senha, codigoDeAcesso;
	private FileReader txtConta;
	private boolean validar;
	private ResourceBundle idioma;

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
		setChanged();
		notifyObservers();
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
		setChanged();
		notifyObservers();
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
		setChanged();
		notifyObservers();
	}

	public int getCodigoDeAcesso() {
		return codigoDeAcesso;		
	}

	public void setCodigoDeAcesso(int codigoDeAcesso) {
		this.codigoDeAcesso = codigoDeAcesso;
		setChanged();
		notifyObservers();
	}

	public ResourceBundle getIdioma() {
		return idioma;
	}

	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
	}


	// enable user to open file
	public FileReader openFile() throws FileNotFoundException {
		txtConta = new FileReader (""+ getConta());
		return txtConta;
	} // end method openFile
	// read record from file

	public boolean validar() throws IOException{

		BufferedReader entrada = new BufferedReader(openFile());

		ArrayList<Integer> linhasTxt = new ArrayList<Integer>();
		String texto;
		while((texto = entrada.readLine()) != null){

			linhasTxt.add(Integer.parseInt(texto, 16));//converte de hexadecimal para inteiro

		}

		int agencia = linhasTxt.get(1);
		int senha = linhasTxt.get(2);
		if(agencia == getAgencia() && senha == getSenha()){
			validar = true;
			JOptionPane.showMessageDialog(null, "Acesso Autorizado!");

			File arquivoLeitura = new File("" + getConta()); 
			LineNumberReader linhaLeitura = new LineNumberReader(openFile());  
			linhaLeitura.skip(arquivoLeitura.length());  
			int qtdLinha = linhaLeitura.getLineNumber(); 

			if(qtdLinha != 3){
				TelaGerarCodigo telaG = new TelaGerarCodigo();
				telaG.setNumConta(getConta());
				try{//verifica se nenhum idioma foi selecionado
					telaG.internacionalizar(getIdioma());
				}catch(NullPointerException e){//se nenhum idioma for selecionado ele começa com padrão pelo português
					telaG.internacionalizar(ResourceBundle.getBundle("projeto", new Locale("pt", "BR")));
				}
				telaG.setAgencia(getAgencia());
				telaG.setSize(800, 400);
				telaG.setVisible(true);
			}else{
				TelaEntrarComCodigo entCod = new TelaEntrarComCodigo();
				entCod.setNumConta(getConta());
				entCod.setAgencia(getAgencia());
				try{//verifica se nenhum idioma foi selecionado
					entCod.internacionalizar(getIdioma());
				}catch(NullPointerException e){//se nenhum idioma for selecionado ele começa com padrão pelo português
					entCod.internacionalizar(ResourceBundle.getBundle("projeto", new Locale("pt", "BR")));
				}
			
				
			}	
		}else{
			JOptionPane.showMessageDialog(null, "Favor verifique as informações digitadas e tente novamente.");
			validar = false;
		}
		return validar;
	}
}
