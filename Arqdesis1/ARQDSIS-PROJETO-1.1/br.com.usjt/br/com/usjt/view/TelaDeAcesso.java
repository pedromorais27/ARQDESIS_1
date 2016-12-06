package br.com.usjt.view;


import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.usjt.model.Acesso;

public class TelaDeAcesso extends JFrame implements Observer {

	private JTextField textAgencia, textConta;
	private JPasswordField textSenha;
	private JComboBox<String> EscolherIdioma;
	private JMenuBar menuBar;
	private JMenu mnArquivo, mnSobre;
	private JMenuItem mntmSair, mntmSobre, mtmAdm;
	private JLabel lblAgencia, lblConta, lblSenha, lblIdioma;
	private JButton btnOk, btnCancelar;
	private ResourceBundle resourseBundle;
	private Acesso acesso;
	private ResourceBundle idioma;

	public TelaDeAcesso(Acesso acesso) {
		setTitle("Login");//define o titulo do frame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 284, 302);//seta o local da tela que ele abrira

		Container layout = getContentPane();//cria um pane para serem inseridos os componentes
		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		layout.setBackground(Color.white);//coloca o fundo da tela na co branca
		GridBagConstraints grid = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna

		menuBar = new JMenuBar();//cria uma barra de menu 
		setJMenuBar(menuBar);//adiciona a barra de menu ao frame

		mnArquivo = new JMenu("Arquivo");//cria um menu com o nome Arquivo
		menuBar.add(mnArquivo);//adiciona o menu a barra de menu

		mntmSair = new JMenuItem("Sair");//cria um item demenu com o nome Sair 
		mnArquivo.add(mntmSair);//adiciona o item de menu sair dentro do menu arquivo

		mnSobre = new JMenu("Sobre");//cria um menu com o nome sobre
		menuBar.add(mnSobre);//adiciona o menu a barra de menu

		mntmSobre = new JMenuItem("Sobre");//cria um item de menu com o nome sobre
		mnSobre.add(mntmSobre);//adiciona o item de menu com o nome sobre ao menu sobre

		mtmAdm = new JMenuItem("Funcoes de Adm");
		mnSobre.add(mtmAdm);

		lblAgencia = new JLabel("Agencia");//cria uma label com o nome agencia

		lblConta = new JLabel("Conta");//cria uma label com o nome conta

		lblSenha = new JLabel("Senha"); //cria uma label com o nome senha

		textAgencia = new JTextField();//cria uma caixa de texto
		textAgencia.setColumns(10);//define o tamanho da caixa de texto para 10 espaços

		textConta = new JTextField();//cria uma caixa de texto
		textConta.setColumns(10);//define o tamanho da caixa de texto para 10 espaços

		textSenha = new JPasswordField();//cria uma caixa de texto
		textSenha.setColumns(10);//define o tamanho da caixa de texto para 10 espaços

		btnOk = new JButton("Ok");//cria um botão com o nome OK
		btnOk.setSize(20, 50);//define o tamanho do botão

		btnCancelar = new JButton("Calcelar");//cria um botão com o nome cncelar
		btnCancelar.setSize(20, 50);//define o tamanho do botão

		lblIdioma = new JLabel("Idioma");//cria uma label com o nome idioma

		EscolherIdioma = new JComboBox();//cria um JComboBox para selecionar o idioma

		EscolherIdioma.setToolTipText("");//define que o JComboBox recebera tipos textos nele

		// adicionas as opções no JComboBox
		EscolherIdioma.addItem(""); // Opção vazia
		EscolherIdioma.addItem("Português"); // Opção potugues
		EscolherIdioma.addItem("Inglês"); // opção Ingles
		EscolherIdioma.addItem("Español"); // opção espanhol


		//definindo a posição que os componentes apareceram

		//adiciona a label no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 0;//linha
		layout.add(lblAgencia, grid);//aciciona a label em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 1;//clouna
		grid.gridy = 0;//linha
		layout.add(textAgencia, grid);//aciciona a label em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 0;//coluna
		grid.gridy = 1;//linha
		layout.add(lblConta, grid);//aciciona a label em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 1;//linha 
		grid.gridy = 1;//coluna
		layout.add(textConta, grid);//aciciona a label em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 0;///linha
		grid.gridy = 2;//coluna
		layout.add(lblSenha, grid);//aciciona a label em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 1;//linha
		grid.gridy = 2;//coluna
		layout.add(textSenha, grid);//aciciona a label em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 0;//linha
		grid.gridy = 3;//coluna
		layout.add(lblIdioma, grid);//aciciona a label em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 1;//linha
		grid.gridy = 3;//coluna
		layout.add(EscolherIdioma, grid);//aciciona a label em forma de grid na Container

		//adiciona o JComboBox no GridBagLayout
		grid.gridx = 0;//linha
		grid.gridy = 4;//coluna
		layout.add(btnOk, grid);//aciciona a label em forma de grid na Container

		//adiciona o botão no GridBagLayout
		grid.gridx = 0;//linha
		grid.gridy = 4;//coluna
		layout.add(btnOk, grid);//aciciona a label em forma de grid na Container

		//adiciona o botão no GridBagLayout		
		grid.gridx = 1;//linha
		grid.gridy = 4;//coluna
		layout.add(btnCancelar, grid);//aciciona a label em forma de grid na Container

		//adiciona o botão no GridBagLayout
		grid.gridx = 1;//linha 
		grid.gridy = 4;//coluna
		layout.add(btnCancelar, grid);//aciciona a label em forma de grid na Container

		this.acesso = acesso;///define que a variabel do tipo Acesso recebera o que estiver no parametro acesso
		acesso.addObserver(this);//esta classe é a que vai ser observada 
	}

	protected Acesso getAcesso() {
		return acesso;
	}
	public int getTextAgencia() {
		return Integer.valueOf(textAgencia.getText());
	}

	public void setTextAgencia(int agencia) {
		this.textAgencia.setText(String.valueOf(agencia));
	}

	public int getTextConta() {
		return Integer.valueOf(textConta.getText());
	}

	public void setTextConta(String conta) {
		this.textConta.setText(conta);
	}

	public char[] getTextSenha() {
		return textSenha.getPassword();
	}

	public void setTextSenha(int senha) {
		this.textSenha.setText(String.valueOf(senha));
	}

	public void addBtnOkListener(ActionListener a) {
		btnOk.addActionListener(a);
	}

	public void addBtnCancelarListener(ActionListener a) {
		btnCancelar.addActionListener(a);
	}

	public JComboBox<String> getEscolherIdioma() {
		return EscolherIdioma;
	}

	public void addEscolherIdiomaListener(ActionListener a) {
		EscolherIdioma.addActionListener(a);
	}

	public void addmntmSairListener(ActionListener a) {
		mntmSair.addActionListener(a);
	}

	public void addmntmSobreListener(ActionListener a) {
		mntmSobre.addActionListener(a);
	}

	public void addmntmmtmAdmListener(ActionListener a) {
		mtmAdm.addActionListener(a);
	}

	public ResourceBundle getIdioma() {
		return idioma;
	}

	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
	}

	public void internacionalizar(ResourceBundle escolhaDeIdioma) {
		resourseBundle = escolhaDeIdioma;
		// acessa o .properties com o idioma portugues todo codigo para alterar o idioma dos componentes ficara aqui

		//muda o idioma da barra de menu
		mnArquivo.setText(resourseBundle.getString("telaDeLogin.JMenu.Arquivo"));
		mntmSair.setText(resourseBundle.getString("telaDeLogin.JMenuItem.Sair"));
		mnSobre.setText(resourseBundle.getString("telaDeLogin.JMenu.Sobre"));
		mntmSobre.setText(resourseBundle.getString("telaDeLogin.JMenuItem.Sobre"));
		mtmAdm.setText(resourseBundle.getString("telaDeLogin.JMenuItem.Adm"));

		//muda o idcioma das labels
		lblAgencia.setText(resourseBundle.getString("telaDeLogin.JLabel.Agencia"));
		lblConta.setText(resourseBundle.getString("telaDeLogin.JLabel.Conta"));
		lblSenha.setText(resourseBundle.getString("telaDeLogin.JLabel.Senha"));
		lblIdioma.setText(resourseBundle.getString("telaDeLogin.JLabel.Idioma"));

		//muda o idioma dos botões
		btnCancelar.setText(resourseBundle.getString("telaDeLogin.JButton.Cancelar"));
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
