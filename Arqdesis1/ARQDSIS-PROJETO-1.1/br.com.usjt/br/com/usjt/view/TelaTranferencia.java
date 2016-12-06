package br.com.usjt.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.usjt.model.Transferencia;

public class TelaTranferencia extends JFrame implements Observer{

	public JTextField txtConta, txtValor, txtAgencia;
	public JFormattedTextField txtData;
	private JLabel lblContaASer, lblNome, lblNomeTitular, lblTipoConta, NumeroAgencia, lblConta, NumeroDaAgencia,
			lblAgencia, NumeroDaConta;
	private JLabel lblContaASerC, lblContaCreditada, lblAgenciaCreditada, lblValorDaTranferencia, lblTranferir,
			lblCdigoDeAcesso;
	private ButtonGroup buttonGroup;
	public JPasswordField passwordField;
	private JButton btnVoltar, btnContinuar, btnLimpar;
	public JRadioButton rdbtnHoje, rdbtnAgendadaPara;
	private ResourceBundle resourseBundle;
	private ResourceBundle idioma;
	private Transferencia transferencia;
	private int numConta, agencia;
	private String nomeCliente;


	public TelaTranferencia(Transferencia transferencia) throws ParseException {
		setBounds(100, 100, 524, 419);
		setSize(900, 550);
		lblContaASer = new JLabel("Conta a ser debitada");
		lblContaASer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		setResizable(false);		
		Container layout = getContentPane();//cria um pane para serem inseridos os componentes
		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		layout.setBackground(Color.white);//coloca o fundo da tela na co branca
	    GridBagConstraints grid = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna


		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblNomeTitular = new JLabel();

		lblTipoConta = new JLabel("Tipo: Conta Corrente");

		lblAgencia = new JLabel("Ag\u00EAncia:");

		NumeroAgencia = new JLabel();

		lblConta = new JLabel("Conta:");
	
		NumeroDaConta = new JLabel();
		
		NumeroDaAgencia = new JLabel();

		lblContaASerC = new JLabel("Conta a ser creditada");
		lblContaASerC.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblAgenciaCreditada = new JLabel("Agencia:");

		txtAgencia = new JTextField();
		txtAgencia.setColumns(10);

		lblContaCreditada = new JLabel("Conta:");

		txtConta = new JTextField();
		txtConta.setColumns(10);

		lblValorDaTranferencia = new JLabel("Valor da Tranferencia");

		txtValor = new JTextField();
		txtValor.setColumns(10);

		lblTranferir = new JLabel("Tranferir:");

		rdbtnHoje = new JRadioButton("Hoje");
		rdbtnAgendadaPara = new JRadioButton("Agendada para ");

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnHoje);
		buttonGroup.add(rdbtnAgendadaPara);

		txtData = new JFormattedTextField();
		MaskFormatter mask   = new MaskFormatter( "##/##/####" );    
		mask.install(txtData); 

		lblCdigoDeAcesso = new JLabel("C\u00F3digo de acesso:");

		passwordField = new JPasswordField(10);

		btnVoltar = new JButton("Voltar");
		
		btnContinuar = new JButton("Continuar");
		
		btnLimpar = new JButton("Limpar");

		grid.ipadx = 30; //define o tamanho das celulas
		grid.ipady = 10; //define o tamanho das coluna 
		
		grid.weightx = 1;//separa as linhas  
		grid.weighty = 1;//separa as colunas
		
		
		//adiciona a label no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 0;//linha
		layout.add(lblContaASerC, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 0;//clouna
		grid.gridy = 1;//linha
		layout.add(lblNome, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 1;//clouna
		grid.gridy = 1;//linha
		layout.add(lblNomeTitular, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 0;//clouna
		grid.gridy = 2;//linha
		layout.add(lblTipoConta, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 0;//clouna
		grid.gridy = 3;//linha
		layout.add(lblAgencia, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 1;//clouna
		grid.gridy = 3;//linha
		layout.add(NumeroDaAgencia, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 4;//clouna
		grid.gridy = 3;//linha
		layout.add(lblConta, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 5;//clouna
		grid.gridy = 3;//linha
		layout.add(NumeroDaConta, grid);//aciciona a label em forma de grid na Container

		grid.gridx = 0;//clouna
		grid.gridy = 6;//linha
		layout.add(lblContaASerC, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 0;//clouna
		grid.gridy = 7;//linha
		layout.add(lblAgenciaCreditada, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 1;//clouna
		grid.gridy = 7;//linha
		layout.add(txtAgencia, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 4;//clouna
		grid.gridy = 7;//linha
		layout.add(lblContaCreditada, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 5;//clouna
		grid.gridy = 7;//linha
		layout.add(txtConta, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 0;//clouna
		grid.gridy = 8;//linha
		layout.add(lblValorDaTranferencia, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 1;//clouna
		grid.gridy = 8;//linha
		layout.add(txtValor, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 0;//clouna
		grid.gridy = 9;//linha
		layout.add(lblTranferir, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 0;//clouna
		grid.gridy = 11;//linha
		layout.add(rdbtnHoje, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 0;//clouna
		grid.gridy = 13;//linha
		layout.add(rdbtnAgendadaPara, grid);//aciciona a label em forma de grid na Container
			
		grid.gridx = 1;//clouna
		grid.gridy = 13;//linha
		layout.add(txtData, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 3;//clouna
		grid.gridy = 17;//linha
		layout.add(lblCdigoDeAcesso, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 4;//clouna
		grid.gridy = 17;//linha
		layout.add(passwordField, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 3;//clouna
		grid.gridy = 20;//linha
		layout.add(btnVoltar, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 4;//clouna
		grid.gridy = 20;//linha
		layout.add(btnContinuar, grid);//aciciona a label em forma de grid na Container
		
		grid.gridx = 5;//clouna
		grid.gridy = 20;//linha
		layout.add(btnLimpar, grid);//aciciona a label em forma de grid na Container
		
		
		this.transferencia = transferencia;///define que a variabel do tipo Acesso recebera o que estiver no parametro acesso
		transferencia.addObserver(this);//esta classe é a que vai ser observada 
	}
	
	protected Transferencia getTransferencia(){
		return transferencia;
	}

	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public ResourceBundle getIdioma() {
		return idioma;
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


	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
	}
	public int getTxtConta() {
		return Integer.valueOf(txtConta.getText());
	}
	
	public Double getTxtValor() {
		return Double.parseDouble(txtValor.getText());
	}
	
	public int getTxtAgencia() {
		return Integer.valueOf(txtAgencia.getText());
	}
	
	public String getTxtData() {
		return txtData.getText();
	}
	
	public char[] getPasswordField() {
		return passwordField.getPassword();
	}
	
	public void setPasswordField(int senha) {
		this.passwordField.setText(String.valueOf(senha));
	}
	
	public void setTxtConta(int txtConta) {
		this.txtConta.setText(String.valueOf(txtConta));
	}
	
	public void setTxtValor(Double valor) {
		this.txtValor.setText(String.valueOf(valor));
	}
	
	public void setTxtAgencia(int agencia) {
		this.txtAgencia.setText(String.valueOf(agencia));
	}
	
	public void setTxtData(String data) {
		this.txtData.setText(String.valueOf(data));
	}
	
	
	public void addbtnVoltarListener(ActionListener a) {
		btnVoltar.addActionListener(a);
	}
	
	public void addbtnContinuarListener(ActionListener a) {
		btnContinuar.addActionListener(a);
	}
	
	public void addbtnLimparListener(ActionListener a) {
		btnLimpar.addActionListener(a);
	}
	
	public void mudaLabel(String nome, String agenciaTitular, String contaTitular ){
		lblNomeTitular.setText(nome);
		NumeroDaConta.setText(contaTitular);
		NumeroDaAgencia.setText(agenciaTitular);
	}
	
	
	public void internacionalizar(ResourceBundle idiomaEScolhido) {
		resourseBundle = idiomaEScolhido;
		// acessa o .properties com o idioma portugues todo codigo para alterar o idioma dos componentes ficara aqui
		
		lblNome.setText(resourseBundle.getString("telaTransferencia.JLabel.Nome"));
		lblTipoConta.setText(resourseBundle.getString("telaTransferencia.JLabel.Tipo"));
		lblAgencia.setText(resourseBundle.getString("telaTransferencia.JLabel.Agencia"));
		lblConta.setText(resourseBundle.getString("telaTransferencia.JLabel.Conta"));
		lblContaASerC.setText(resourseBundle.getString("telaTransferencia.JLabel.ContaASer"));
		lblAgenciaCreditada.setText(resourseBundle.getString("telaTransferencia.JLabel.Agencia.creditada"));
		lblContaCreditada.setText(resourseBundle.getString("telaTransferencia.JLabel.Conta.creditada"));
		lblValorDaTranferencia.setText(resourseBundle.getString("telaTransferencia.JLabel.ValorDaTransferencia"));
		lblTranferir.setText(resourseBundle.getString("telaTransferencia.JLabel.Transferir"));
		rdbtnHoje.setText(resourseBundle.getString("telaTransferencia.JRadioButton.Hoje"));
		rdbtnAgendadaPara.setText(resourseBundle.getString("telaTransferencia.JRadioButton.Para"));
		lblCdigoDeAcesso.setText(resourseBundle.getString("telaTransferencia.JLabel.CodigoDeAcesso"));
		btnContinuar.setText(resourseBundle.getString("telaTransferencia.JButton.Continuar"));
		btnVoltar.setText(resourseBundle.getString("telaTransferencia.JButton.Voltar"));
		
		setIdioma(idiomaEScolhido);
	}

	protected Transferencia getTranferencia() {
		return transferencia;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
