package br.com.usjt.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
import javax.swing.JOptionPane;
import br.com.usjt.DAO.ContaDAO;
import br.com.usjt.TO.ContaTO;

public class Conta extends Observable{
	private int agencia, saldo, numConta;
	private String nome;

	public Conta() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAgencia() {		
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
		setChanged();
		notifyObservers();
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
		setChanged();
		notifyObservers();
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
		setChanged();
		notifyObservers();
	}

	public String consultarSaldo(){		
		ContaDAO contaDAO = new ContaDAO();
		ContaTO contaTO = contaDAO.selectSaldo(getNumConta());

		return String.valueOf(contaTO.getSaldo());
	}

	public void imprimir() throws IOException{
		SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy" + " HH.mm.ss");//cria um tipo date para colocar a data de que foi criado o arquivo no nome do arquivo 
		Calendar data = Calendar.getInstance();

		File arquivo;
		
		String nomeArq = "Saldo da conta " + getNumConta() + " do dia e hora " + formatoData.format(data.getTime()) + ".txt";
		//criando arquivo para preencher com o extrato 
		try
		{
			arquivo = new File(nomeArq);
			arquivo.createNewFile();
			JOptionPane.showMessageDialog(null,"Arquivo '"+ nomeArq + "' criado!","Arquivo",1);
		}
		//mostrando erro em caso se nao for possivel gerar arquivo
		catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Arquivo nao pode ser gerado!","Erro",0);
		}

		FileWriter output = new FileWriter(new File(nomeArq),true);
		PrintWriter gravarArq = new PrintWriter(output, true);//coloca o arquivo na variavel para preenchelo (o true permite que escreve em um arquivo de texto ja preenchido)
	
		String newLine = System.getProperty("line.separator");
	
		String saldoDoDia  = "\t" + "Saldo do dia e hora " + formatoData.format(data.getTime())
		+ newLine + newLine + "Nome: " + getNome()
		+ newLine +"Conta: " + getNumConta()
		+ newLine + "Agencia: " + getAgencia()
		+ newLine + "saldo: " + getSaldo();

		gravarArq.format("\n" + saldoDoDia);
	}
}