package br.com.usjt.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.usjt.model.Conta;

public class TelaSaldo extends JFrame implements Observer{
	private JLabel lblSaldo, lblDisponivelParaSaque, labelData, lblData;
	protected JLabel labelSaque;
	private JButton btnImpressao, btnVoltar;
	private Calendar dateTime;
	private ResourceBundle resourseBundle;
	private Conta conta;
	private ResourceBundle idioma;
	private int numConta, agencia;
	private String nomeCliente;

	public TelaSaldo(Conta conta) {
		setBounds(100, 100, 450, 300);
		setResizable(false);
		Container layout = getContentPane();//cria um pane para serem inseridos os componentes
		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		layout.setBackground(Color.white);//coloca o fundo da tela na co branca
		GridBagConstraints grid = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna

		dateTime = Calendar.getInstance();

		lblSaldo = new JLabel("Saldo");

		lblDisponivelParaSaque = new JLabel("Disponivel para saque");

		JLabel lblR$ = new JLabel("R$");

		btnImpressao = new JButton("Imprimir");
		btnImpressao.setPreferredSize(new Dimension(80, 15)); //define o tamnho do botão

		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");//cria o formato da data brasileira
		labelData = new JLabel(String.format(formatoData.format(dateTime.getTime())));

		lblData = new JLabel("Data");

		labelSaque = new JLabel("00,00");

		btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(80, 15)); //define o tamnho do botão

		//definindo a posição que os componentes apareceram

		grid.ipadx = 20; //define o tamanho das celulas
		grid.ipady = 15; //define o tamanho das coluna 

		grid.weightx = 1;//separa as linhas  
		grid.weighty = 1;//separa as colunas

		//adiciona a label no GridBagLayout
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridwidth = 4;//quantos espaços ira ocupar
		layout.add(lblSaldo, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 7;//clouna
		grid.gridy = 0;//linha
		layout.add(labelData, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 6;//clouna
		grid.gridy = 0;//linha
		layout.add(lblData, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 1;//linha
		layout.add(lblDisponivelParaSaque, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 6;//clouna
		grid.gridy = 1;//linha
		layout.add(lblR$, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 7;//clouna
		grid.gridy = 1;//linha
		layout.add(labelSaque, grid);//aciciona a botao em forma de grid na Container
		
		//adiciona a botao no GridBagLayout
		grid.gridx = 5;//clouna
		grid.gridy = 3;//linha
		layout.add(btnVoltar, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 9;//clouna
		grid.gridy = 3;//linha
		layout.add(btnImpressao, grid);//aciciona a botao em forma de grid na Container
		
		this.conta = conta;///define que a variabel do tipo Acesso recebera o que estiver no parametro acesso
		conta.addObserver(this);//esta classe é a que vai ser observada
	}
	protected Conta getConta(){
		return conta;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
		
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
		
	public int getNumConta() {
		return numConta;
	}
	
	
	public void setNumConta(int numConta) {
		
		this.numConta = numConta;
		
	}

	public void addbtnVoltarListener(ActionListener a) {
		btnVoltar.addActionListener(a);
	}

	public void addbtnImpressaoListener(ActionListener a) {
		btnImpressao.addActionListener(a);
	}
	
	
	public void mudaLabel(String saldo){
		labelSaque.setText(saldo);
	}
	
	
	public ResourceBundle getIdioma() {
		return idioma;
	}

	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
	}

	public void internacionalizar(ResourceBundle idiomaEscolhido){
		resourseBundle = idiomaEscolhido;

		//muda o idioma das labels
		lblSaldo.setText(resourseBundle.getString("telaSaldo.JLabel.Saldo"));
		lblDisponivelParaSaque.setText(resourseBundle.getString("telaSaldo.JLabel.DisponivelParaSaque"));
		lblData.setText(resourseBundle.getString("telaSaldo.JLabel.Data"));

		//muda o idioma dos botões
		btnImpressao.setText(resourseBundle.getString("telaSaldo.JButton.Imprimir"));
		btnVoltar.setText(resourseBundle.getString("telaSaldo.JButton.Voltar"));

		setIdioma(idiomaEscolhido);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
