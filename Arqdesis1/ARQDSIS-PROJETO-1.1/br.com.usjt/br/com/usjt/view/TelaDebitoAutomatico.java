package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.usjt.model.DebitoAutomatico;

public class TelaDebitoAutomatico extends JFrame implements Observer{
	private JTextField textCodigoOp, txtCodigoConsumidor, txtValor;
	private JFormattedTextField txtData;
	private JLabel lblCadastrarDbitoAutomatico, lblTipoDeConta, lblCodigoDaOperadora, lblDataDaDebito, lblValor,
	lblCodigoDoConsumidor;
	private JComboBox<String> EscolherConta;
	private JButton btnVoltar, btnConfirmar, btnConsultar;
	private ResourceBundle resourseBundle;
	private Calendar dateTime;
	private DebitoAutomatico debitoAutomatico;
	public JTable tblResultado;
	public JTable table;
	private JFrame frame;
	private ResourceBundle idioma;
	private int numConta, numAgencia;
	public DefaultTableModel model;
	private String nomeCliente;
	
	public TelaDebitoAutomatico(DebitoAutomatico debitoAutomatico) throws ParseException {
		frame = new JFrame();
		frame.setLayout(new BorderLayout());	
		frame.setTitle(getNomeCliente());
		frame.setResizable(false);
		JPanel panelBotoes = new JPanel();
		JPanel layout = new JPanel();//cria um pane para serem inseridos os componentes

		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		layout.setBackground(Color.white);//coloca o fundo da tela na co branca


		GridBagConstraints grid = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna


		lblCadastrarDbitoAutomatico = new JLabel("Cadastrar D\u00E9bito Automatico");
		lblCadastrarDbitoAutomatico.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblTipoDeConta = new JLabel("Tipo de Conta");

		tblResultado = new JTable();

		EscolherConta = new JComboBox();

		lblCodigoDaOperadora = new JLabel("Codigo da operadora");

		textCodigoOp = new JTextField();
		textCodigoOp.setColumns(10);

		lblDataDaDebito = new JLabel("Data da Debito:");

		dateTime = Calendar.getInstance();

		txtData = new JFormattedTextField();
		MaskFormatter mask   = new MaskFormatter( "##/##/####" );    
		mask.install(txtData); 


		lblCodigoDoConsumidor = new JLabel("Codigo do consumidor ");

		txtCodigoConsumidor = new JTextField();

		txtCodigoConsumidor.setColumns(10);

		lblValor = new JLabel("Valor");

		txtValor = new JTextField();

		txtValor.setColumns(10);

		btnVoltar = new JButton("Voltar");

		btnConfirmar = new JButton("Confirmar");

		btnConsultar = new JButton("Consultar");


		EscolherConta.addItem("");
		EscolherConta.addItem("Água");
		EscolherConta.addItem("Luz");
		EscolherConta.addItem("Telefone");

		//definindo a posição que os componentes apareceram

		grid.ipadx = 50; //define o tamanho das celulas
		grid.ipady = 15; //define o tamanho das coluna 

		grid.weightx = 1;//separa as linhas  
		grid.weighty = 1;//separa as colunas

		//adiciona a label no GridBagLayout
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridwidth = 4;//quantos espaços ira ocupar
		layout.add(lblCadastrarDbitoAutomatico, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 1;//linha
		layout.add(lblTipoDeConta, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 5;//clouna
		grid.gridy = 1;//linha
		layout.add(EscolherConta, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 2;//linha
		layout.add(lblDataDaDebito, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 5;//clouna
		grid.gridy = 2;//linha
		layout.add(txtData, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 10;//clouna
		grid.gridy = 1;//linha
		layout.add(lblCodigoDaOperadora, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 10;//clouna
		grid.gridy = 2;//linha
		layout.add(lblCodigoDoConsumidor, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 15;//clouna
		grid.gridy = 1;//linha
		layout.add(textCodigoOp, grid);

		//adiciona a botao no GridBagLayout
		grid.gridx = 15;//clouna
		grid.gridy = 2;//linha
		layout.add(txtCodigoConsumidor, grid);

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 4;//linha
		layout.add(lblValor, grid);

		//adiciona a botao no GridBagLayout
		grid.gridx = 5;//clouna
		grid.gridy = 4;//linha
		layout.add(txtValor, grid);

		panelBotoes.add(btnConsultar);
		panelBotoes.add(btnConfirmar);
		panelBotoes.add(btnVoltar);


		table = new JTable();
		//define o nome das colunas do JTable
		model = new DefaultTableModel(
				new String [] {"codigoDebito", "tipoDebito", "operadora", "codigoConsumidor", "dataDebito", 
				"valorDebito", "numConta"},0);

		
		table.setModel(model);
		JScrollPane resultado = new JScrollPane();

		resultado.setViewportView(table);

		frame.add(layout, BorderLayout.NORTH);
		frame.add(resultado, BorderLayout.CENTER);
		frame.add(panelBotoes, BorderLayout.SOUTH);

		frame.setSize(800, 700);
		frame.setVisible(true);

		this.debitoAutomatico = debitoAutomatico;///define que a variabel do tipo Acesso recebera o que estiver no parametro acesso
		debitoAutomatico.addObserver(this);//esta classe é a que vai ser observada 

	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public int getNumAgencia() {
		return numAgencia;
	}
	
	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
		
	public int getNumConta() {
		return numConta;
	}
	
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public void visual(boolean f){
		frame.setVisible(f);
	}
	public Double getTxtValor() {
		return Double.parseDouble(txtValor.getText());
	}

	public void settxtValor(double valor) {
		this.txtValor.setText(String.valueOf(valor));
	}

	public int getTxtCodigoConsumidor() {
		return Integer.valueOf(txtCodigoConsumidor.getText());
	}

	public void setTxtCodigoConsumidor(int codConsumidor) {
		this.txtCodigoConsumidor.setText(String.valueOf(codConsumidor));
	}

	public int getTextCodigoOp() {
		return Integer.valueOf(textCodigoOp.getText());
	}

	public void setTextCodigoOp(int codOperacao) {
		this.textCodigoOp.setText(String.valueOf(codOperacao));
	}

	public String getTxtData() {
		return txtData.getText();
	}

	public void setTxtData(String txtData) {
		this.txtData.setText(txtData);
	}

	public void setEscolherConta(JComboBox escolherConta) {
		EscolherConta = escolherConta;
	}

	public void addEscolherContaListener(ActionListener a) {
		EscolherConta.addActionListener(a);
	}

	public void addBtnConfirmarListener(ActionListener a) {
		btnConfirmar.addActionListener(a);
	}

	public void addBtnVoltarListener(ActionListener a) {
		btnVoltar.addActionListener(a);
	}

	public void addConsultarListener(ActionListener a) {
		btnConsultar.addActionListener(a);
	}

	protected DebitoAutomatico getDebitoAutomatico() {
		return debitoAutomatico;
	}

	public JComboBox<String> getEscolherConta() {
		return EscolherConta;
	}

	public ResourceBundle getIdioma() {
		return idioma;
	}

	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
	}

	public void internacionalizar(ResourceBundle idiomaEscolhido){
		resourseBundle = idiomaEscolhido;

		//muda o idioma das label
		lblCadastrarDbitoAutomatico.setText(resourseBundle.getString("telaDebitoAutomatico.JLabel.CadastrarDebitobitoAutomatico"));
		lblTipoDeConta.setText(resourseBundle.getString("telaDebitoAutomatico.JLabel.TipoDeConta"));
		lblCodigoDaOperadora.setText(resourseBundle.getString("telaDebitoAutomatico.JLabel.CodigoDaOperadora"));
		lblDataDaDebito.setText(resourseBundle.getString("telaDebitoAutomatico.JLabel.DataDoDebito"));
		lblCodigoDoConsumidor.setText(resourseBundle.getString("telaDebitoAutomatico.JLabel.CodigoDoConsumidor"));
		lblValor.setText(resourseBundle.getString("telaDebitoAutomatico.JLabel.Valor"));

		//muda o idioma dos botões
		btnVoltar.setText(resourseBundle.getString("telaDebitoAutomatico.JButton.Voltar"));
		btnConfirmar.setText(resourseBundle.getString("telaDebitoAutomatico.JButton.Confirmar"));
		btnConsultar.setText(resourseBundle.getString("telaDebitoAutomatico.JButton.Consultar"));


		setIdioma(idiomaEscolhido);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
