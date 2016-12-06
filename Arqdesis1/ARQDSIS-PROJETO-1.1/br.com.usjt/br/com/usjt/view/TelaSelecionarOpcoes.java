package br.com.usjt.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.usjt.DAO.ContaDAO;
import br.com.usjt.controller.AcessarContaCTRL;
import br.com.usjt.controller.DebitoAutomaticoCTRL;
import br.com.usjt.controller.ExtratoContaCTRL;
import br.com.usjt.controller.SacarDinheiroCTRL;
import br.com.usjt.controller.SaldoDeContaCTRL;
import br.com.usjt.controller.TransferenciaCTRL;
import br.com.usjt.model.Acesso;
import br.com.usjt.model.Conta;
import br.com.usjt.model.DebitoAutomatico;
import br.com.usjt.model.Movimento;
import br.com.usjt.model.Saque;
import br.com.usjt.model.Transferencia;

public class TelaSelecionarOpcoes extends JFrame {

	private JLabel lblPorfavor;
	private JButton btnSaque, btnSaldo, btnExtrato, btnTransferencia, btnDebitoAutomatico, btnCancelar;
	private Acesso acesso;
	private ResourceBundle resourseBundle;;
	private ResourceBundle idioma;
	private int numConta, agencia;
	private String nomeCliente;

	public TelaSelecionarOpcoes() {
		setBounds(100, 100, 450, 300);
		setResizable(false);		
		
		Container layout = getContentPane();//cria um pane para serem inseridos os componentes
		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		layout.setBackground(Color.white);//coloca o fundo da tela na co branca
		GridBagConstraints grid = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna


		lblPorfavor = new JLabel("Por favor selecione uma das op\u00E7\u00F5es abaixo:");
		lblPorfavor.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnSaque = new JButton("Saque");
		btnSaque.setPreferredSize(new Dimension(80, 20)); //define o tamnho do botão
		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSaque saque = new SacarDinheiroCTRL(new Saque(new Movimento ()));
				saque.setTitle(getNomeCliente());
				saque.setNomeCliente(getNomeCliente());
				saque.internacionalizar(getIdioma());
				saque.setNumConta(getNumConta());
				saque.setAgencia(getAgencia());
				saque.setVisible(true);
				dispose();
			}
		});
		
		btnSaldo = new JButton("Saldo");
		btnSaldo.setPreferredSize(new Dimension(80, 20)); 
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSaldo saldo = new SaldoDeContaCTRL(new Conta());
				saldo.setTitle(getNomeCliente());
				saldo.setNomeCliente(getNomeCliente());
				saldo.internacionalizar(getIdioma());
				saldo.setNumConta(getNumConta());
				saldo.setAgencia(getAgencia());
				saldo.setVisible(true);
				saldo.getConta().setNumConta(getNumConta());
				saldo.getConta().setAgencia(getAgencia());
				saldo.getConta().setNome(getNomeCliente());
				saldo.mudaLabel(saldo.getConta().consultarSaldo());
				dispose();
			}
		});
		btnExtrato = new JButton("Extrato");
		btnExtrato.setPreferredSize(new Dimension(80, 20)); 
		btnExtrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExtratoDaConta extrato = new ExtratoContaCTRL(new Movimento());
				extrato.setTitle(getNomeCliente());
				extrato.setNomeCliente(getNomeCliente());
				extrato.internacionalizar(getIdioma());
				extrato.setNumConta(getNumConta());
				extrato.setAgencia(getAgencia());
				Conta conta = new Conta();
				conta.setNumConta(getNumConta());
				extrato.mudaLabel(conta.consultarSaldo());
				dispose();
			}
		});
		btnTransferencia = new JButton("Transferencia");
		btnTransferencia.setPreferredSize(new Dimension(80, 20)); 
		btnTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTranferencia transferencia;
				try {
					transferencia = new TransferenciaCTRL(new Transferencia(new Movimento()));
					transferencia.setTitle(getNomeCliente());
					transferencia.internacionalizar(getIdioma());
					transferencia.setNumConta(getNumConta());
					transferencia.setAgencia(getAgencia());
					transferencia.setVisible(true);
					transferencia.setNomeCliente(getNomeCliente());
					transferencia.mudaLabel(getNomeCliente(), String.valueOf(getAgencia()), String.valueOf(getNumConta()));
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnDebitoAutomatico = new JButton("Debito Automatico");
		btnDebitoAutomatico.setPreferredSize(new Dimension(80, 20)); 
		btnDebitoAutomatico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDebitoAutomatico debito;
				try {
					debito = new DebitoAutomaticoCTRL(new DebitoAutomatico());
					debito.setTitle(getNomeCliente());
					debito.setNomeCliente(getNomeCliente());
					debito.internacionalizar(getIdioma());
					debito.setNumConta(getNumConta());
					debito.setNumAgencia(getAgencia());
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setPreferredSize(new Dimension(80, 20)); 
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeAcesso login = new AcessarContaCTRL(new Acesso());
				login.internacionalizar(getIdioma());
				login.setVisible(true);
				dispose();
			}
		});

		//definindo a posição que os componentes apareceram

		grid.ipadx = 50; //define o tamanho das celulas
		grid.ipady = 15; //define o tamanho das coluna 
		
		grid.weightx = 1;//separa as linhas  
		grid.weighty = 1;//separa as colunas
		
		//adiciona a label no GridBagLayout
		grid.gridx = 1;
		grid.gridy = 0;
		grid.gridwidth = 4;//quantos espaços ira ocupar
		layout.add(lblPorfavor, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 2;//linha
		layout.add(btnSaque, grid);//aciciona a botao em forma de grid na Container

		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 3;//linha
		layout.add(btnSaldo, grid);//aciciona a botao em forma de grid na Containe
		
		//adiciona a botao no GridBagLayout
		grid.gridx = 0;//clouna
		grid.gridy = 4;//linha
		layout.add(btnExtrato, grid);//aciciona a botao em forma de grid na Containe
		
		//adiciona a botao no GridBagLayout
		grid.gridx = 4;//clouna
		grid.gridy = 2;//linha
		layout.add(btnTransferencia, grid);//aciciona a botao em forma de grid na Containe
		
		//adiciona a botao no GridBagLayout
		grid.gridx = 4;//clouna
		grid.gridy = 3;//linha
		layout.add(btnDebitoAutomatico, grid);//aciciona a botao em forma de grid na Containe
		
		//adiciona a botao no GridBagLayout
		grid.gridx = 4;//clouna
		grid.gridy = 5;//linha
		layout.add(btnCancelar, grid);//aciciona a botao em forma de grid na Containe
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public int getNumConta() {
		return numConta;
	}
	
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
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

		lblPorfavor.setText(resourseBundle.getString("telaSelecionarOpcoes.JLabel.PorFavorSelecione"));
		
		btnSaque.setText(resourseBundle.getString("telaSelecionarOpcoes.JButton.Saque"));
		btnSaldo.setText(resourseBundle.getString("telaSelecionarOpcoes.JButton.Saldo"));
		btnExtrato.setText(resourseBundle.getString("telaSelecionarOpcoes.JButton.Extrato"));
		btnTransferencia.setText(resourseBundle.getString("telaSelecionarOpcoes.JButton.Transferencia"));
		btnDebitoAutomatico.setText(resourseBundle.getString("telaSelecionarOpcoes.JButton.DebitoAutomatico"));
		btnCancelar.setText(resourseBundle.getString("telaSelecionarOpcoes.JButton.Cancelar"));

		setIdioma(idiomaEscolhido);
		
	}
}