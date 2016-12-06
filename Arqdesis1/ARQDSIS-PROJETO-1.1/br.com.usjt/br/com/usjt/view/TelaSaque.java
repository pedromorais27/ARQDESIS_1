package br.com.usjt.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.usjt.model.Movimento;
import br.com.usjt.model.Saque;

public class TelaSaque extends JFrame implements Observer{
	private JLabel lblSelecioneOValor;
	private JButton btn10, btn20, btn50, btn100, btn200, btn500, btnOutrosValores, btnVoltar;
	private Saque saque;
	private ResourceBundle resourseBundle;
	private ResourceBundle idioma;
	private int numConta, agencia;
	private String nomeCliente;

	public TelaSaque(Saque saque) {
		setResizable(false);
		setBounds(100, 100, 459, 350);
		lblSelecioneOValor = new JLabel("Selecione o valor que deseja sacar:");
		lblSelecioneOValor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		Container layout = getContentPane();//cria um pane para serem inseridos os componentes
		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		layout.setBackground(Color.white);//coloca o fundo da tela na co branca
		GridBagConstraints grid = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna

		btn10 = new JButton("R$ 10,00");
		btn10.setPreferredSize(new Dimension(80, 20));

		btn20 = new JButton("R$ 20,00");
		btn20.setPreferredSize(new Dimension(80, 20));

		btn50 = new JButton("R$ 50,00");
		btn50.setPreferredSize(new Dimension(80, 20));

		btn100 = new JButton("R$ 100,00");
		btn100.setPreferredSize(new Dimension(80, 20));

		btn200 = new JButton("R$ 200,00");
		btn200.setPreferredSize(new Dimension(80, 20));

		btn500 = new JButton("R$ 500,00");
		btn500.setPreferredSize(new Dimension(80, 20));

		btnOutrosValores = new JButton("Outros Valores");
		btnOutrosValores.setPreferredSize(new Dimension(70, 20));

		btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(70, 20));

		//adiciona a label no GridBagLayout

		grid.ipadx = 50; //define o tamanho das celulas
		grid.ipady = 15; //define o tamanho das coluna 

		grid.weightx = 1;//separa as linhas  
		grid.weighty = 1;//separa as colunas

		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridwidth = 4;//quantos espaços ira ocupar
		layout.add(lblSelecioneOValor, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 2;//linha
		layout.add(btn10, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 3;//linha
		layout.add(btn20, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 4;//linha
		layout.add(btn50, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 4;//clouna
		grid.gridy = 2;//linha
		layout.add(btn100, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 4;//clouna
		grid.gridy = 3;//linha
		layout.add(btn200, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 4;//clouna
		grid.gridy = 4;//linha
		layout.add(btn500, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 9;//linha
		layout.add(btnOutrosValores, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 4;//clouna
		grid.gridy = 9;//linha
		layout.add(btnVoltar, grid);//aciciona a botao em forma de grid na Container

		this.saque = saque;///define que a variabel do tipo Acesso recebera o que estiver no parametro acesso
		saque.addObserver(this);//esta classe é a que vai ser observada

	}

	protected Saque getSaque() {
		return saque;
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


	public void addBtn10(ActionListener a) {
		btn10.addActionListener(a);
	}

	public void addBtn20(ActionListener a) {
		btn20.addActionListener(a);
	}

	public void addBtn50(ActionListener a) {
		btn50.addActionListener(a);
	}

	public void addBtn100(ActionListener a) {
		btn100.addActionListener(a);
	}

	public void addBtn200(ActionListener a) {
		btn200.addActionListener(a);
	}

	public void addBtn500(ActionListener a) {
		btn500.addActionListener(a);
	}

	public void addBtnVoltar(ActionListener a) {
		btnVoltar.addActionListener(a);
	}

	public void addbtnOutrosValores( ActionListener a) {
		btnOutrosValores.addActionListener(a);
	}

	public ResourceBundle getIdioma() {
		return idioma;
	}

	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
	}
	public void internacionalizar(ResourceBundle idiomaEscolhido) {
		resourseBundle = idiomaEscolhido;
		// acessa o .properties com o idioma portugues todo codigo para alterar o idioma dos componentes ficara aqui

		lblSelecioneOValor.setText(resourseBundle.getString("telaSaque.JLabel.SalecionarValor"));
		btnOutrosValores.setText(resourseBundle.getString("telaSaque.JButton.OutrosValores"));
		btnVoltar.setText(resourseBundle.getString("telaSaque.JButton.Voltar"));

		setIdioma(idiomaEscolhido);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
