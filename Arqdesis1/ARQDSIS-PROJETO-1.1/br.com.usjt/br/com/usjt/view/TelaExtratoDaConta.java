package br.com.usjt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
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

import br.com.usjt.model.Movimento;

public class TelaExtratoDaConta extends JFrame implements Observer {
	public JTable table;
	public JFormattedTextField txtDataDe, txtDataA;
	private JLabel lblTotalParaSaque, lblExtratoDaConta, lblFiltrarPorPeriodo, lblEntreCom, lblA, labelValor;
	private JButton btnVoltar, btnImprimir, btnConsultar;
	private JComboBox selecionaPeriodo;
	private JScrollPane scrollPane;
	private Movimento movimento;
	private ResourceBundle resourseBundle;
	private ResourceBundle idioma;
	private JFrame frame ;
	private int numConta, agencia;
	private String nomeCliente;
	public DefaultTableModel model;

	public TelaExtratoDaConta(Movimento movimento) {
		frame = new JFrame();
		frame.setLayout(new BorderLayout());	

		JPanel panelBotoes = new JPanel();
		JPanel layout = new JPanel();//cria um pane para serem inseridos os componentes


		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout

		lblExtratoDaConta = new JLabel("Extrato da Conta");
		lblExtratoDaConta.setFont(new Font("Tahoma", Font.PLAIN, 13));


		lblTotalParaSaque = new JLabel("Total para Saque");

		JLabel lblR = new JLabel("R$");

		labelValor = new JLabel();

		lblFiltrarPorPeriodo = new JLabel("Filtrar por periodo");

		selecionaPeriodo = new JComboBox();

		scrollPane = new JScrollPane();

		btnVoltar = new JButton("Voltar");

		btnImprimir = new JButton("Imprimir");

		btnConsultar = new JButton("Consultar");


		try {
			txtDataDe = new JFormattedTextField();
			txtDataDe.setSize(50, 50);
			MaskFormatter maskDe = new MaskFormatter( "##/##/####" );
			maskDe.install(txtDataDe); 

			txtDataA = new JFormattedTextField();
			MaskFormatter maskA   = new MaskFormatter( "##/##/####" );    
			maskA.install(txtDataA); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		lblEntreCom = new JLabel("Entre com\r\n a data: de");

		lblA = new JLabel("a");



		table = new JTable();

		model = new DefaultTableModel(
				new String [] {"codigoMovimento", "numConta", "dataOperacao", "valorOperacao", "agenciaDestino", 
						"contaDestino", "codCli", "tipoMovimento"},0);

		table.setModel(model);
		JScrollPane resultado = new JScrollPane();

		resultado.setViewportView(table);


		// adicionas as opções no JComboBox
		selecionaPeriodo.addItem(""); 
		selecionaPeriodo.addItem("Ultimos lançamentos"); 
		selecionaPeriodo.addItem("ultimos 7 dias"); 
		selecionaPeriodo.addItem("ultimos 15 dias");


		GridBagConstraints grid1 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid2 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid3 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid4 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid5 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid6 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid7 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid8 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid9 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid10 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna
		GridBagConstraints grid11 = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna

		//definindo a posição que os componentes apareceram

		grid1.anchor = GridBagConstraints.NORTHWEST;
		grid1.gridx = 0;//clouna
		grid1.gridy = 0;//linha
		layout.add(lblExtratoDaConta, grid1);//aciciona a botao em forma de grid na Container

		grid2.anchor = GridBagConstraints.WEST;
		grid2.gridx = 0;//clouna
		grid2.gridy = 1;//linha
		layout.add(lblTotalParaSaque, grid2);//aciciona a botao em forma de grid na Container


		grid3.anchor = GridBagConstraints.SOUTHWEST;
		grid3.gridx = 0;//clouna
		grid3.gridy = 2;//linha
		layout.add(lblFiltrarPorPeriodo, grid3);//aciciona a botao em forma de grid na Container

		grid4.anchor = GridBagConstraints.SOUTHWEST;
		grid4.gridx = 2;//clouna
		grid4.gridy = 2;//linha
		layout.add(selecionaPeriodo, grid4);//aciciona a botao em forma de grid na Container

		grid5.anchor = GridBagConstraints.SOUTHWEST;
		grid5.gridx = 3;//clouna
		grid5.gridy = 2;//linha
		layout.add(lblEntreCom, grid5);//aciciona a botao em forma de grid na Container

		grid6.anchor = GridBagConstraints.SOUTHWEST;
		grid6.gridx = 5;//clouna
		grid6.gridy = 2;//linha
		layout.add(txtDataDe, grid6);//aciciona a botao em forma de grid na Container

		grid7.anchor = GridBagConstraints.SOUTHWEST;
		grid7.gridx = 7;//clouna
		grid7.gridy = 2;//linha
		layout.add(lblA, grid7);//aciciona a botao em forma de grid na Container

		grid8.anchor = GridBagConstraints.SOUTHWEST;
		grid8.gridx = 8;//clouna
		grid8.gridy = 2;//linha
		layout.add(txtDataA, grid8);//aciciona a botao em forma de grid na Container

		grid9.anchor = GridBagConstraints.NORTHWEST;
		grid9.gridx = 6;//clouna
		grid9.gridy = 1;//linha
		layout.add(lblR, grid9);//aciciona a botao em forma de grid na Container

		grid10.anchor = GridBagConstraints.NORTHWEST;
		grid10.gridx = 7;//clouna
		grid10.gridy = 1;//linha
		layout.add(labelValor, grid10);//aciciona a botao em forma de grid na Container

		frame.setVisible(true);//este é o frame que sera exibido com o border layout
		frame.setBounds(100, 100, 606, 412);
		frame.setTitle(getNomeCliente());

		frame.setSize(990,600);

		panelBotoes.add(btnVoltar);
		panelBotoes.add(btnImprimir);
		panelBotoes.add(btnConsultar);

		frame.add(layout, BorderLayout.NORTH);
		frame.add(resultado, BorderLayout.CENTER);
		frame.add(panelBotoes, BorderLayout.SOUTH);

		this.movimento = movimento;///define que a variabel do tipo Acesso recebera o que estiver no parametro acesso
		movimento.addObserver(this);//esta classe é a que vai ser observada 
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


	public void visual(boolean f){
		frame.setVisible(f);
	}

	protected Movimento getMovimento() {
		return movimento;
	}


	public JComboBox<String> getselecionaPeriodo() {
		return selecionaPeriodo;
	}

	public void addSelecionaPeriodoListener(ActionListener a) {
		selecionaPeriodo.addActionListener(a);
	}

	public void addBtnVoltarListener(ActionListener a) {
		btnVoltar.addActionListener(a);
	}

	public void addBtnImprimirListener(ActionListener a) {
		btnImprimir.addActionListener(a);
	}

	public void addBtnConsultarListener(ActionListener a) {
		btnConsultar.addActionListener(a);
	}

	public String getTxtDataA() {
		return txtDataA.getText();
	}

	public void setTxtDataA(String dataA) {
		this.txtDataA.setText(dataA);
	}

	public String getTxtDataDe() {
		return txtDataDe.getText();
	}

	public void setTxtDataDe(String dataDe) {
		this.txtDataDe.setText(dataDe);
	}

	public void mudaLabel(String saldo){
		labelValor.setText(saldo);
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

		//muda o idioma das lables
		lblExtratoDaConta.setText(resourseBundle.getString("telaExtratoDaConta.JLabel.lblExtratoDaConta"));
		lblTotalParaSaque.setText(resourseBundle.getString("telaExtratoDaConta.JLabel.TotalParaSaque"));
		lblFiltrarPorPeriodo.setText(resourseBundle.getString("telaExtratoDaConta.JLabel.FiltrarPorPeriodo"));
		lblEntreCom.setText(resourseBundle.getString("telaExtratoDaConta.JLabel.lblEntreCom"));
		lblA.setText(resourseBundle.getString("telaExtratoDaConta.JLabel.lbla"));

		//muda o idioma dos botões
		btnImprimir.setText(resourseBundle.getString("telaExtratoDaConta.JButton.Imprimir"));
		btnVoltar.setText(resourseBundle.getString("telaExtratoDaConta.JButton.Voltar"));

		setIdioma(idiomaEscolhido);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
