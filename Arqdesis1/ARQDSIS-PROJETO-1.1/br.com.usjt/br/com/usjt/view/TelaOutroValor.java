package br.com.usjt.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.usjt.controller.SacarDinheiroCTRL;
import br.com.usjt.model.Movimento;
import br.com.usjt.model.Saque;

public class TelaOutroValor extends JFrame {
	private JTextField textValorSerSacado;
	private JLabel lblPorFavorInformar, lblR;
	private JButton btnCorrigir, btnRealizarSaque, btnVoltar;
	private ResourceBundle resourseBundle;;
	private ResourceBundle idioma;
	private int numConta, agencia;
	private String nomeCliente;
	
	public TelaOutroValor() {
		setBounds(100, 100, 450, 300);
		setResizable(false);
		Container layout = getContentPane();//cria um pane para serem inseridos os componentes
		layout.setLayout(new GridBagLayout());//avisa ao pane que ele recebera um GridBadgeLayout
		layout.setBackground(Color.white);//coloca o fundo da tela na co branca
		GridBagConstraints grid = new GridBagConstraints();//cria um gridBagLayout que funciona como se fosse uma tabela, linha e coluna

		lblPorFavorInformar = new JLabel("Por Favor Informar o valor que deseja sacar:");
		lblPorFavorInformar.setFont(new Font("Tahoma", Font.PLAIN, 16));

		textValorSerSacado = new JTextField();
		textValorSerSacado.setColumns(10);

		lblR  = new JLabel("R$");

		btnCorrigir = new JButton("Corrigir");
		btnRealizarSaque = new JButton("Realizar Saque");
		btnVoltar = new JButton("Voltar");

		grid.weighty = 1;//separa as colunas

		//adiciona a label no GridBagLayout
		grid.gridx = 1;
		grid.gridy = 0;
		layout.add(lblPorFavorInformar, grid);//aciciona a botao em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 1;
		grid.gridy = 2;
		layout.add(textValorSerSacado, grid);//aciciona a botao em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 0;
		grid.gridy = 2;
		layout.add(lblR, grid);//aciciona a botao em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 2;
		grid.gridy = 3;
		layout.add(btnCorrigir, grid);//aciciona a botao em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 1;
		grid.gridy = 3;
		layout.add(btnVoltar, grid);//aciciona a botao em forma de grid na Container

		//adiciona a label no GridBagLayout
		grid.gridx = 3;
		grid.gridy = 3;
		layout.add(btnRealizarSaque, grid);//aciciona a botao em forma de grid na Container


		btnCorrigir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textValorSerSacado.setText("");
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSaque saque = new SacarDinheiroCTRL(new Saque(new Movimento()));
				saque.setNumConta(getNumConta());
				saque.setAgencia(getAgencia());
				saque.setTitle(getNomeCliente());
				saque.setNomeCliente(getNomeCliente());
				saque.internacionalizar(getIdioma());
				saque.setVisible(true);
				dispose();
			}
		});

		btnRealizarSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Saque saque = new Saque(new Movimento());
				try { 
					Double valorSacar = Double.parseDouble(textValorSerSacado.getText());
					if(valorSacar <= 0){
						JOptionPane.showMessageDialog(null, "entre com um valor valido");
					}else{
						saque.setConta(getNumConta());
						saque.fazerSaque(valorSacar);
					}
				}catch(NumberFormatException erro){ 
					JOptionPane.showMessageDialog(null, "entre com um valor valido"); 
					return; 
				}	
			}
		});
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

	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
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

	
	public void internacionalizar(ResourceBundle idiomaEscolhido) {
		resourseBundle = idiomaEscolhido;
		// acessa o .properties com o idioma portugues todo codigo para alterar o idioma dos componentes ficara aqui
		
		//muda o idioma das label
		lblPorFavorInformar.setText(resourseBundle.getString("telaOutroValor.JLabel.PorFavorInformar"));
		
		//muda o idioma dos botões
		btnRealizarSaque.setText(resourseBundle.getString("telaSelecionarOpcoes.JButton.Saque"));
		btnCorrigir.setText(resourseBundle.getString("telaOutroValor.JButton.Corrigir"));
		btnVoltar.setText(resourseBundle.getString("telaOutroValor.JButton.Voltar"));
		
		setIdioma(idiomaEscolhido);
	}	
}
